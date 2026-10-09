/**
 * Villager News Helicopter - Advanced 6-DOF Flight Physics Controller
 *
 * Controls:
 * - Collective (Altitude):
 *   - Space / Jump key: Ascend smoothly
 *   - Look down sharply (< -30°): Descend smoothly
 *   - Neutral: Stable hover with gentle aerodynamic micro-bobbing
 * - Cyclic (Horizontal):
 *   - Forward (W): Leans nose down (-16° pitch) and moves forward
 *   - Backward (S): Leans nose up (+12° pitch) and reverses
 *   - Strafe Left/Right (A/D): Banks left/right (±14° roll) and moves sideways
 *   - Yaw: Turns smoothly to follow pilot view heading
 * - Ground & Landing:
 *   - Starts grounded with rotors idling.
 *   - Lifts off when holding Space (Jump) or Forward (W).
 *   - Lands softly on terrain or helipad when settling with low descent rate.
 */

import { world, system } from "@minecraft/server";
import { mathClamp, wrapDegrees, smoothAngle, getForwardVector, getRightVector, lerp } from "./mathUtils.js";

export const HELICOPTER_CONFIG = {
    MAX_HORIZONTAL_SPEED: 0.75,   // Forward/reverse cruise speed (blocks/tick)
    MAX_STRAFE_SPEED: 0.48,       // Sideways strafe speed
    HORIZONTAL_ACCEL: 0.040,      // Acceleration per tick
    HORIZONTAL_DRAG: 0.90,        // Air resistance drag

    MAX_ASCEND_SPEED: 0.48,       // Climb rate on Space/Jump
    MAX_DESCEND_SPEED: -0.35,     // Controlled descent rate
    VERTICAL_ACCEL: 0.045,        // Vertical response rate
    VERTICAL_DRAG: 0.88,          // Hover dampening rate

    MAX_PITCH_TILT: 16.0,         // Forward/backward tilt degrees
    MAX_ROLL_TILT: 14.0,          // Bank roll degrees
    TILT_LERP: 0.20,              // Tilt transition speed

    YAW_SMOOTH_FACTOR: 8,         // Heading smoothing
    HOVER_BOB_AMPLITUDE: 0.015    // Micro-bobbing in stable hover
};

export class HelicopterBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.state = vehicle.isOnGround ? "grounded" : "flying";
        this.removed = false;

        this.vx = 0;
        this.vz = 0;
        this.vy = 0;
        this.pitchTilt = 0;
        this.rollTilt = 0;
        this.headingYaw = vehicle.getRotation()?.y || 0;
        this.tickCounter = 0;
        this.yawHistory = [];
    }

    setPlayer(player) {
        this.player = player;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        this.tickCounter++;
        const hasDriver = this.player && this.player.isValid;
        const isOnGround = this.vehicle.isOnGround || false;
        const curVel = this.vehicle.getVelocity() || { x: 0, y: 0, z: 0 };

        // Unattended handling (rider dismounted in midair or on ground)
        if (!hasDriver) {
            if (this.state === "flying") {
                this.vx *= 0.85;
                this.vz *= 0.85;
                this.vy = Math.max(this.vy - 0.03, -0.30); // Gentle fall
                try {
                    this.vehicle.applyImpulse({
                        x: (this.vx - curVel.x) * 0.5,
                        y: (this.vy - curVel.y) * 0.5,
                        z: (this.vz - curVel.z) * 0.5
                    });
                } catch (e) {}

                if (isOnGround) {
                    this.enterGroundMode();
                }
            }
            return;
        }

        // 1. Gather player inputs
        let isJumping = false;
        let viewDir = { x: 0, y: 0, z: 0 };
        let playerRot = { x: 0, y: this.headingYaw };
        let inputVec = { x: 0, y: 0 };

        try {
            isJumping = this.player.isJumping || false;
            viewDir = this.player.getViewDirection();
            playerRot = this.player.getRotation();

            if (this.player.inputInfo) {
                const vec = this.player.inputInfo.getMovementVector();
                if (vec) inputVec = vec;
            }
        } catch (e) {}

        // Fallback: If on mobile/touch without explicit WASD, view direction steering
        const forwardInput = inputVec.y > 0.1;
        const backwardInput = inputVec.y < -0.1;
        const strafeLeftInput = inputVec.x > 0.1;
        const strafeRightInput = inputVec.x < -0.1;

        // 2. Heading Steering: Yaw follows player camera
        this.headingYaw = smoothAngle(playerRot.y, this.yawHistory, HELICOPTER_CONFIG.YAW_SMOOTH_FACTOR);
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Calculate world directional vectors from heading
        const f = getForwardVector(this.headingYaw);
        const r = getRightVector(this.headingYaw);

        // Sync WASD client property
        let wasd = "none";
        if (forwardInput) wasd = "w";
        else if (backwardInput) wasd = "s";
        else if (strafeRightInput) wasd = "d";
        else if (strafeLeftInput) wasd = "a";

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

        // 3. Grounded vs Flying State Machine
        if (this.state === "grounded") {
            this.pitchTilt = lerp(this.pitchTilt, 0, 0.25);
            this.rollTilt = lerp(this.rollTilt, 0, 0.25);
            this._syncProperties(false);

            try {
                this.vehicle.setRotation({ x: 0, y: this.headingYaw });
            } catch (e) {}

            // Liftoff on Jump / Space or Forward input
            const wantsLiftoff = isJumping || forwardInput || (viewDir.y > 0.45);
            if (wantsLiftoff) {
                this.enterFlightMode();
                this.vy = 0.35; // Initial liftoff push
                try {
                    this.vehicle.applyImpulse({ x: 0, y: 0.35, z: 0 });
                } catch (e) {}
            }
            return;
        }

        // ====================================================================
        // FLIGHT PHYSICS
        // ====================================================================

        // 4. Vertical Collective (Altitude)
        if (isJumping || viewDir.y > 0.40) {
            // Climbing
            this.vy = Math.min(this.vy + HELICOPTER_CONFIG.VERTICAL_ACCEL, HELICOPTER_CONFIG.MAX_ASCEND_SPEED);
        } else if (viewDir.y < -0.35) {
            // Descending
            this.vy = Math.max(this.vy - HELICOPTER_CONFIG.VERTICAL_ACCEL, HELICOPTER_CONFIG.MAX_DESCEND_SPEED);
        } else {
            // Stable hover with altitude dampening
            this.vy *= HELICOPTER_CONFIG.VERTICAL_DRAG;
            if (Math.abs(this.vy) < 0.02) {
                this.vy = Math.sin(this.tickCounter * 0.15) * HELICOPTER_CONFIG.HOVER_BOB_AMPLITUDE;
            }
        }

        // 5. Cyclic Horizontal Flight
        let targetVx = 0;
        let targetVz = 0;

        if (forwardInput) {
            targetVx += f.x * HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED;
            targetVz += f.z * HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED;
        } else if (backwardInput) {
            targetVx -= f.x * (HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED * 0.6);
            targetVz -= f.z * (HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED * 0.6);
        }

        if (strafeRightInput) {
            targetVx += r.x * HELICOPTER_CONFIG.MAX_STRAFE_SPEED;
            targetVz += r.z * HELICOPTER_CONFIG.MAX_STRAFE_SPEED;
        } else if (strafeLeftInput) {
            targetVx -= r.x * HELICOPTER_CONFIG.MAX_STRAFE_SPEED;
            targetVz -= r.z * HELICOPTER_CONFIG.MAX_STRAFE_SPEED;
        }

        const hasHorizontalInput = forwardInput || backwardInput || strafeLeftInput || strafeRightInput;

        if (hasHorizontalInput) {
            this.vx = lerp(this.vx, targetVx, 0.20);
            this.vz = lerp(this.vz, targetVz, 0.20);
        } else {
            this.vx *= HELICOPTER_CONFIG.HORIZONTAL_DRAG;
            this.vz *= HELICOPTER_CONFIG.HORIZONTAL_DRAG;
            if (Math.abs(this.vx) < 0.005) this.vx = 0;
            if (Math.abs(this.vz) < 0.005) this.vz = 0;
        }

        // 6. Dynamic Pitch & Bank Roll Tilt
        let targetPitch = 0;
        if (forwardInput) targetPitch = HELICOPTER_CONFIG.MAX_PITCH_TILT;
        else if (backwardInput) targetPitch = -HELICOPTER_CONFIG.MAX_PITCH_TILT * 0.75;

        let targetRoll = 0;
        if (strafeRightInput) targetRoll = HELICOPTER_CONFIG.MAX_ROLL_TILT;
        else if (strafeLeftInput) targetRoll = -HELICOPTER_CONFIG.MAX_ROLL_TILT;

        this.pitchTilt = lerp(this.pitchTilt, targetPitch, HELICOPTER_CONFIG.TILT_LERP);
        this.rollTilt = lerp(this.rollTilt, targetRoll, HELICOPTER_CONFIG.TILT_LERP);
        this._syncProperties(true);

        // 7. Closed-loop impulse application
        const impulseX = (this.vx - curVel.x) * 0.85;
        const impulseY = (this.vy - curVel.y) * 0.85;
        const impulseZ = (this.vz - curVel.z) * 0.85;

        try {
            this.vehicle.applyImpulse({ x: impulseX, y: impulseY, z: impulseZ });
            this.vehicle.setRotation({ x: 0, y: this.headingYaw });
        } catch (e) {}

        // 8. Soft touchdown landing detection
        if (isOnGround && this.vy <= 0.05 && !isJumping && !forwardInput && viewDir.y <= 0.1) {
            this.enterGroundMode();
        }
    }

    _syncProperties(isFlying) {
        try {
            this.vehicle.setProperty("renderphoenix:heli_pitch", mathClamp(this.pitchTilt, -45, 45));
            this.vehicle.setProperty("renderphoenix:heli_roll", mathClamp(this.rollTilt, -45, 45));
            this.vehicle.setProperty("renderphoenix:heli_flying", isFlying);
        } catch (e) {}
    }

    enterFlightMode() {
        this.state = "flying";
        try {
            this.vehicle.triggerEvent("renderphoenix:enter_flight_mode");
            this.vehicle.setProperty("renderphoenix:heli_flying", true);
        } catch (e) {}
    }

    enterGroundMode() {
        this.state = "grounded";
        this.vx = 0;
        this.vz = 0;
        this.vy = 0;
        this.pitchTilt = 0;
        this.rollTilt = 0;
        try {
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
            this.vehicle.setProperty("renderphoenix:heli_flying", false);
            this.vehicle.setProperty("renderphoenix:heli_pitch", 0.0);
            this.vehicle.setProperty("renderphoenix:heli_roll", 0.0);
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
        this.enterGroundMode();
    }
}
