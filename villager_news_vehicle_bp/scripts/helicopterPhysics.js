/**
 * Villager News Helicopter - Advanced 6-DOF Flight Physics
 *
 * Features:
 * - Proper vertical collective control:
 *   - Hold Space / Jump to ascend smoothly
 *   - Look down sharply to descend smoothly
 *   - Stable aerodynamic hover with micro-bobbing when neutral
 * - Full cyclic horizontal control (WASD):
 *   - Forward (W): Leans nose down (-20° pitch) and propels forward
 *   - Backward (S): Leans nose up (+16° pitch) and reverses
 *   - Strafe (A/D): Banks left/right (±16° roll) and strafes sideways
 *   - Smooth yaw rotation matching player view heading
 * - Real momentum, aerodynamic drag, and inertia
 * - Safe runway / helipad landing and touchdown
 * - Auto-dismount ground safety
 */

import { world, system } from "@minecraft/server";
import { smoothAngle, mathClamp } from "./mathUtils.js";

export const HELICOPTER_CONFIG = {
    MAX_HORIZONTAL_SPEED: 0.82,          // Cruise top speed forward/back (blocks/tick)
    MAX_STRAFE_SPEED: 0.62,              // Lateral strafe speed
    HORIZONTAL_ACCEL: 0.045,             // Acceleration per tick
    HORIZONTAL_DRAG: 0.91,               // Inertial air resistance drag

    MAX_ASCEND_SPEED: 0.52,              // Vertical lift when holding Space (Jump)
    MAX_DESCEND_SPEED: -0.38,            // Vertical descent when looking down
    VERTICAL_ACCEL: 0.05,                // Vertical response rate
    VERTICAL_DRAG: 0.86,                 // Dampening to hold altitude in hover

    MAX_PITCH_TILT: 20.0,                // Max forward/backward tilt in degrees
    MAX_ROLL_TILT: 16.0,                 // Max bank angle in degrees
    TILT_LERP: 0.16,                     // Smooth tilt transition speed

    YAW_SMOOTHING: 10,                   // Smoothing factor for turning heading to match player view
    HOVER_BOB_AMPLITUDE: 0.02            // Realistic aerodynamic micro-bob in hover
};

export class HelicopterBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.state = vehicle.isOnGround ? "grounded" : "flying";
        this.removed = false;

        this.vx = 0;
        this.vz = 0;
        this.verticalVelocity = 0;
        this.pitchTilt = 0;
        this.rollTilt = 0;
        this.tickCounter = 0;

        this.histories = {
            yaw: []
        };
    }

    setPlayer(player) {
        this.player = player;
    }

    clearPlayer() {
        this.player = null;
    }

    getRider() {
        if (!this.vehicle || !this.vehicle.isValid) return null;
        const rideable = this.vehicle.getComponent("minecraft:rideable");
        return rideable?.getRiders()?.find(r => r.typeId === "minecraft:player") || null;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        this.tickCounter++;
        const rider = this.getRider();

        // If no player rider - let it fall naturally rather than snap to ground
        if (!rider || !this.player || !this.player.isValid) {
            if (this.state === "flying") {
                // Gently cut horizontal thrust but let gravity handle landing
                this.vx *= 0.85;
                this.vz *= 0.85;
                this.verticalVelocity = Math.max(this.verticalVelocity - 0.04, -0.3);
                try {
                    this.vehicle.applyKnockback({ x: this.vx, z: this.vz }, this.verticalVelocity);
                } catch (e) {}
                if (this.vehicle.isOnGround) this.enterGroundMode();
            }
            return;
        }

        // 1. Gather player inputs
        let isJumping = false;
        let inputVector = { x: 0, y: 0 };
        let viewDir = { x: 0, y: 0, z: 0 };
        let playerRot = { x: 0, y: 0 };
        let hasDirectInput = false;

        try {
            isJumping = this.player.isJumping || false;
            viewDir = this.player.getViewDirection();
            playerRot = this.player.getRotation();

            if (this.player.inputInfo) {
                const vec = this.player.inputInfo.getMovementVector();
                if (vec && (Math.abs(vec.x) > 0.05 || Math.abs(vec.y) > 0.05)) {
                    inputVector = vec;
                    hasDirectInput = true;
                }
            }
        } catch (e) {}

        const currentVel = this.vehicle.getVelocity();
        const isOnGround = this.vehicle.isOnGround;

        // 2. Smooth Yaw Rotation to face player look direction
        const smoothYaw = smoothAngle(playerRot.y, this.histories.yaw, HELICOPTER_CONFIG.YAW_SMOOTHING);
        try {
            this.vehicle.setRotation({ x: 0, y: smoothYaw });
        } catch (e) {}

        // Forward and strafe vectors in world space
        const yawRad = (-smoothYaw) * (Math.PI / 180);
        const fx = Math.sin(yawRad);
        const fz = Math.cos(yawRad);
        const rx = Math.cos(yawRad);
        const rz = -Math.sin(yawRad);

        // Fallback input detection from velocity if inputInfo is not active (non-beta world)
        if (!hasDirectInput) {
            const forwardVel = currentVel.x * fx + currentVel.z * fz;
            const rightVel = currentVel.x * rx + currentVel.z * rz;

            if (forwardVel > 0.03) inputVector.y = 1.0;
            else if (forwardVel < -0.03) inputVector.y = -1.0;

            if (rightVel > 0.03) inputVector.x = 1.0;
            else if (rightVel < -0.03) inputVector.x = -1.0;
        }

        // Sync WASD property for client anims
        let wasd = "none";
        if (inputVector.y > 0.1) wasd = "w";
        else if (inputVector.y < -0.1) wasd = "s";
        else if (inputVector.x > 0.1) wasd = "d";
        else if (inputVector.x < -0.1) wasd = "a";

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

        // 3. State Machine: Grounded vs Flying
        if (this.state === "grounded") {
            // Level out tilt on ground
            this.pitchTilt += (0 - this.pitchTilt) * 0.2;
            this.rollTilt += (0 - this.rollTilt) * 0.2;
            this.syncTiltProperties();

            // Lift off only on explicit input - Space, W, or clearly looking up
            const wantsTakeoff = isJumping || (inputVector.y > 0.1) || (viewDir.y > 0.55);
            if (wantsTakeoff) {
                this.enterFlightMode();
                this.verticalVelocity = 0.32; // initial liftoff push
            }
            return;
        }

        // --- FLYING STATE PHYSICS ---

        // 4. Vertical Collective (Ascend / Descend / Hover)
        if (isJumping || viewDir.y > 0.35) {
            // Ascend vertically when jumping (Space) OR looking up
            this.verticalVelocity = Math.min(
                this.verticalVelocity + HELICOPTER_CONFIG.VERTICAL_ACCEL * 1.5,
                HELICOPTER_CONFIG.MAX_ASCEND_SPEED
            );
        } else if (viewDir.y < -0.35) {
            // Descend vertically when looking down sharply
            this.verticalVelocity = Math.max(
                this.verticalVelocity - HELICOPTER_CONFIG.VERTICAL_ACCEL * 1.5,
                HELICOPTER_CONFIG.MAX_DESCEND_SPEED
            );
        } else {
            // Stable hover with dampening & micro-bobbing
            this.verticalVelocity *= HELICOPTER_CONFIG.VERTICAL_DRAG;
            if (Math.abs(this.verticalVelocity) < 0.02) {
                this.verticalVelocity = Math.sin(this.tickCounter * 0.15) * HELICOPTER_CONFIG.HOVER_BOB_AMPLITUDE;
            }
        }

        // 5. Cyclic Horizontal Flight (WASD)
        const hasHorizontalInput = Math.abs(inputVector.y) > 0.05 || Math.abs(inputVector.x) > 0.05;

        // Target velocities in world space
        const targetVx = (fx * inputVector.y * HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED) +
                         (rx * inputVector.x * HELICOPTER_CONFIG.MAX_STRAFE_SPEED);
        const targetVz = (fz * inputVector.y * HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED) +
                         (rz * inputVector.x * HELICOPTER_CONFIG.MAX_STRAFE_SPEED);

        if (hasHorizontalInput) {
            // Accelerate smoothly towards target
            this.vx += (targetVx - this.vx) * 0.22;
            this.vz += (targetVz - this.vz) * 0.22;
        } else {
            // Natural aerodynamic drag & deceleration
            this.vx *= HELICOPTER_CONFIG.HORIZONTAL_DRAG;
            this.vz *= HELICOPTER_CONFIG.HORIZONTAL_DRAG;
            if (Math.abs(this.vx) < 0.005) this.vx = 0;
            if (Math.abs(this.vz) < 0.005) this.vz = 0;
        }

        // 6. Dynamic Rotor & Fuselage Tilt (Pitch & Roll)
        const currentSpeed = Math.hypot(this.vx, this.vz);
        const speedRatio = Math.min(1.0, currentSpeed / HELICOPTER_CONFIG.MAX_HORIZONTAL_SPEED);

        // Pitch tilt: Forward = nose dips DOWN (tail rises) = positive pitch
        //             Backward = nose pitches UP (tail lowers) = negative pitch
        let targetPitch = 0;
        if (inputVector.y > 0.05) {
            targetPitch = HELICOPTER_CONFIG.MAX_PITCH_TILT * speedRatio;   // nose down, tail up
        } else if (inputVector.y < -0.05) {
            targetPitch = -HELICOPTER_CONFIG.MAX_PITCH_TILT * 0.8 * speedRatio; // nose up, tail down
        }

        // Roll tilt: Strafe Left = bank left (-Z); Strafe Right = bank right (+Z)
        let targetRoll = 0;
        if (inputVector.x < -0.05) {
            targetRoll = -HELICOPTER_CONFIG.MAX_ROLL_TILT;
        } else if (inputVector.x > 0.05) {
            targetRoll = HELICOPTER_CONFIG.MAX_ROLL_TILT;
        }

        // Interpolate tilts smoothly
        this.pitchTilt += (targetPitch - this.pitchTilt) * HELICOPTER_CONFIG.TILT_LERP;
        this.rollTilt += (targetRoll - this.rollTilt) * HELICOPTER_CONFIG.TILT_LERP;
        this.syncTiltProperties();

        // 7. Apply 3D aerodynamic flight impulse with fallback
        try {
            this.vehicle.applyKnockback(
                { x: this.vx, z: this.vz },
                this.verticalVelocity
            );
        } catch (e) {
            try {
                this.vehicle.applyImpulse({
                    x: this.vx * 0.25,
                    y: this.verticalVelocity * 0.25,
                    z: this.vz * 0.25
                });
            } catch (err) {}
        }

        // 8. Touchdown / Landing detection
        // Only land if: on ground, descending or hovering, not jumping, not holding forward
        const isHoldingInput = Math.abs(inputVector.y) > 0.05 || Math.abs(inputVector.x) > 0.05;
        if (isOnGround && this.verticalVelocity <= 0.03 && !isJumping && !isHoldingInput && viewDir.y <= 0.1) {
            this.enterGroundMode();
        }
    }

    syncTiltProperties() {
        try {
            this.vehicle.setProperty("renderphoenix:heli_pitch", mathClamp(this.pitchTilt, -45, 45));
            this.vehicle.setProperty("renderphoenix:heli_roll", mathClamp(this.rollTilt, -45, 45));
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
        this.verticalVelocity = 0;
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

// Active session registry
const activeHelicopterSessions = new Map(); // vehicleId -> HelicopterBehavior

export function tickHelicopterPhysics() {
    // 1. Clean up invalid sessions
    for (const [vehicleId, behavior] of activeHelicopterSessions.entries()) {
        if (!behavior.vehicle || !behavior.vehicle.isValid) {
            behavior.cleanup();
            activeHelicopterSessions.delete(vehicleId);
        }
    }

    // 2. Discover helicopters with riders
    const players = world.getPlayers();
    for (const player of players) {
        const vehicle = getPlayerRidingHelicopter(player);
        if (vehicle && vehicle.typeId === "renderphoenix:helicopter") {
            let behavior = activeHelicopterSessions.get(vehicle.id);
            if (!behavior) {
                behavior = new HelicopterBehavior(vehicle, player);
                activeHelicopterSessions.set(vehicle.id, behavior);
            } else {
                behavior.setPlayer(player);
            }
        }
    }

    // 3. Update all active helicopter behaviors
    for (const [vehicleId, behavior] of activeHelicopterSessions.entries()) {
        try {
            behavior.update();
        } catch (e) {
            // Prevent crashes
        }
    }
}

function getPlayerRidingHelicopter(player) {
    try {
        const dim = player.dimension;
        const nearby = dim.getEntities({
            location: player.location,
            maxDistance: 6,
            type: "renderphoenix:helicopter"
        });

        for (const vehicle of nearby) {
            const rideable = vehicle.getComponent("minecraft:rideable");
            if (rideable?.getRiders().some(r => r.id === player.id)) {
                return vehicle;
            }
        }
    } catch (e) {}
    return null;
}
