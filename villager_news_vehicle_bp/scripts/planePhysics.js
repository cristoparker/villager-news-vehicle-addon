/**
 * Daladas Plane - Arcade Aerodynamic Aircraft Flight Physics Controller
 *
 * Implements a stable, responsive arcade flight model:
 * - Ground Taxi & Takeoff:
 *   - Controlled ground throttle with W / Space (Jump)
 *   - Steers along the runway heading
 *   - Liftoff rotation when reaching takeoff speed and pulling up
 * - Airborne Aerodynamics:
 *   - Cruise speed: 1.20 blocks/tick (~86 km/h)
 *   - Boost speed: 1.60 blocks/tick (~115 km/h) on Space / Jump
 *   - Airbrake: 0.60 blocks/tick (~43 km/h) on S / Backward
 *   - Dynamic lift proportional to forward speed
 *   - Controlled gliding descent / stall when unpowered or slow
 *   - Pitch climb & dive following pilot view
 *   - Coordinated yaw steering and aerodynamic bank roll
 *   - Barrel roll aerial trick on attack / punch
 * - Touchdown Landing & Crash Safety:
 *   - Smooth runway / water touchdown on shallow descent
 *   - Crash landing on steep high-speed terrain impact
 * - Clean closed-loop delta impulse tracking (no runaway velocity!)
 * - Authentic Telemetry HUD
 */

import { world, system } from "@minecraft/server";
import { mathClamp, wrapDegrees, lerpAngle, smoothAngle, getForwardVector, lerp } from "./mathUtils.js";

export const PLANE_CONFIG = {
    // Airspeeds (blocks/tick: 1 block/tick = 72 km/h)
    CRUISE_SPEED: 1.20,            // Cruise airspeed (~86 km/h)
    BOOST_SPEED: 1.60,             // Afterburner boost speed (~115 km/h)
    AIRBRAKE_SPEED: 0.60,          // Airbrake minimum flight speed (~43 km/h)
    STALL_SPEED: 0.40,             // Stall threshold below which lift decays

    // Acceleration & Drag
    ACCELERATION: 0.025,           // Throttle acceleration per tick
    DRAG_DECEL: 0.015,             // Air resistance deceleration
    BRAKE_RATE: 0.040,             // Airbrake rate

    // Ground Taxi
    MAX_TAXI_SPEED: 0.45,          // Runway taxi speed (~32 km/h)
    TAXI_ACCEL: 0.022,             // Runway acceleration
    TAXI_BRAKE: 0.035,             // Runway brake
    ROTATION_SPEED_MIN: 0.28,      // Minimum speed for liftoff rotation pull-up
    TAKEOFF_TIME_MAX: 40,          // Runway roll ticks before forced liftoff
    LIFTOFF_Y_POP: 0.28,           // Vertical impulse pop clearing runway

    // Aerodynamics
    MAX_CLIMB_SPEED: 0.60,         // Vertical climb speed
    MAX_DIVE_SPEED: -0.80,         // Vertical dive speed
    GRAVITY: 0.04,                 // Gravity pull when stalling / unpowered
    PITCH_MAX: 60.0,               // Maximum climb/dive pitch angle in degrees
    BANK_MAX: 45.0,                // Maximum wing bank angle in degrees

    // Steering
    YAW_TURN_RATE: 2.8,            // Turn rate in degrees/tick
    TRICK_COOLDOWN: 30             // Cooldown between barrel rolls (ticks)
};

export class PlaneBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.state = "stationary"; // "stationary", "takeoff", "flying", "crashing"
        this.airspeed = 0;
        this.takeoffTicks = PLANE_CONFIG.TAKEOFF_TIME_MAX;
        this.flightImmunityTicks = 0;
        this.trickCooldown = 0;
        this.barrelRollTicks = 0;
        this.barrelRollDir = 1; // 1 = right, -1 = left
        this.tickCounter = 0;
        this.trick = "ready";

        this.headingYaw = vehicle.getRotation()?.y || 0;
        this.currentYaw = this.headingYaw;
        this.currentPitch = 0;
        this.bankRoll = 0;
        this.removed = false;
        this.yawHistory = [];
    }

    setPlayer(player) {
        this.player = player;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        this.tickCounter++;
        this.trickCooldown = Math.max(0, this.trickCooldown - 1);

        const hasDriver = this.player && this.player.isValid;
        const curVel = this.vehicle.getVelocity() || { x: 0, y: 0, z: 0 };
        const isOnGround = this.vehicle.isOnGround || false;
        const isInWater = this.vehicle.isInWater || false;

        if (!hasDriver) {
            if (this.state === "flying" || this.state === "takeoff") {
                this._enterStationary();
            }
            return;
        }

        // 1. Gather pilot inputs
        let isJumping = false;
        let viewDir = { x: 0, y: 0, z: 1 };
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

        const forwardInput = (inputVec.y > 0.1) || isJumping;
        const backwardInput = inputVec.y < -0.1;
        const leftInput = inputVec.x > 0.1;
        const rightInput = inputVec.x < -0.1;

        // Sync WASD enum property for animations
        let wasd = "none";
        if (forwardInput) wasd = "w";
        else if (backwardInput) wasd = "s";
        else if (rightInput) wasd = "d";
        else if (leftInput) wasd = "a";

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

        // Read trick property (triggered by punch/damage_sensor)
        let currentTrick = "ready";
        try {
            currentTrick = this.vehicle.getProperty("renderphoenix:trick") || "ready";
        } catch (e) {}

        if (currentTrick === "active" && this.trick !== "active") {
            this.trick = currentTrick;
            this._startBarrelRoll();
        } else {
            this.trick = currentTrick;
        }

        // 2. State Machine
        switch (this.state) {
            case "stationary":
                this._handleStationary(forwardInput, curVel);
                break;
            case "takeoff":
                this._handleTakeoff(forwardInput, isJumping, playerRot, curVel);
                break;
            case "flying":
                this._handleFlying(forwardInput, backwardInput, isJumping, playerRot, viewDir, isOnGround, isInWater, curVel);
                break;
            case "crashing":
                this._handleCrashing(isOnGround, isInWater);
                break;
        }

        // 3. Update HUD
        this._updateActionBar();
    }

    _handleStationary(forwardInput, curVel) {
        if (forwardInput) {
            this._enterTakeoff();
        } else {
            this.airspeed = Math.max(0, this.airspeed - PLANE_CONFIG.TAXI_BRAKE);
            this.currentPitch = lerp(this.currentPitch, 0, 0.15);
            this.bankRoll = lerp(this.bankRoll, 0, 0.15);

            if (Math.hypot(curVel.x, curVel.z) > 0.04) {
                try {
                    this.vehicle.applyImpulse({
                        x: -curVel.x * 0.25,
                        y: 0,
                        z: -curVel.z * 0.25
                    });
                } catch (e) {}
            }
            this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);
            try {
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        }
    }

    _handleTakeoff(forwardInput, isJumping, playerRot, curVel) {
        if (forwardInput) {
            // Accelerate along runway
            this.airspeed = Math.min(this.airspeed + PLANE_CONFIG.TAXI_ACCEL, PLANE_CONFIG.MAX_TAXI_SPEED);

            // Ground steering follows pilot look smoothly
            const yawDiff = wrapDegrees(playerRot.y - this.headingYaw);
            this.headingYaw += mathClamp(yawDiff * 0.12, -PLANE_CONFIG.YAW_TURN_RATE, PLANE_CONFIG.YAW_TURN_RATE);
            this.headingYaw = wrapDegrees(this.headingYaw);
            this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);

            const f = getForwardVector(this.currentYaw);
            const targetVx = f.x * this.airspeed;
            const targetVz = f.z * this.airspeed;

            try {
                this.vehicle.applyImpulse({
                    x: (targetVx - curVel.x) * 0.35,
                    y: 0,
                    z: (targetVz - curVel.z) * 0.35
                });
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}

            this.takeoffTicks--;

            // Liftoff condition: pilot pulls up (pitch < -4° looking up or holding Space) at rotation speed
            // OR runway taxi time completes
            const pullingUp = playerRot.x < -4.0 || isJumping;
            const canRotate = this.airspeed >= PLANE_CONFIG.ROTATION_SPEED_MIN && pullingUp;

            if (this.takeoffTicks <= 0 || canRotate) {
                this._enterFlight();
            }
        } else {
            this._enterStationary();
        }
    }

    _handleFlying(forwardInput, backwardInput, isJumping, playerRot, viewDir, isOnGround, isInWater, curVel) {
        if (this.flightImmunityTicks > 0) {
            this.flightImmunityTicks--;
        }

        // Landing & surface collision detection (after takeoff immunity window)
        if (this.flightImmunityTicks <= 0 && (isOnGround || isInWater)) {
            const isSteepDive = this.currentPitch > 25.0 && this.airspeed > 0.65;
            if (isSteepDive) {
                this._enterCrash();
                return;
            } else if (this.currentPitch < 15.0) {
                // Smooth touchdown on runway or water
                this._enterStationary();
                return;
            }
        }

        // 1. Airspeed Throttle Management
        let targetAirspeed = PLANE_CONFIG.CRUISE_SPEED;
        if (isJumping) {
            targetAirspeed = PLANE_CONFIG.BOOST_SPEED;
        } else if (backwardInput) {
            targetAirspeed = PLANE_CONFIG.AIRBRAKE_SPEED;
        } else if (!forwardInput) {
            // Slight cruise drag when neutral
            targetAirspeed = PLANE_CONFIG.CRUISE_SPEED * 0.90;
        }

        if (this.airspeed < targetAirspeed) {
            this.airspeed = Math.min(this.airspeed + PLANE_CONFIG.ACCELERATION, targetAirspeed);
        } else if (this.airspeed > targetAirspeed) {
            this.airspeed = Math.max(this.airspeed - PLANE_CONFIG.DRAG_DECEL, targetAirspeed);
        }

        // 2. Pitch Control (Climbing and Diving)
        // In Minecraft: negative pitch is UP (climbing), positive is DOWN (diving)
        const targetPitch = mathClamp(playerRot.x * 0.85, -PLANE_CONFIG.PITCH_MAX, PLANE_CONFIG.PITCH_MAX);
        this.currentPitch = lerp(this.currentPitch, targetPitch, 0.14);

        // 3. Yaw Steering & Heading
        const yawDiff = wrapDegrees(playerRot.y - this.headingYaw);
        this.headingYaw += mathClamp(yawDiff * 0.12, -PLANE_CONFIG.YAW_TURN_RATE, PLANE_CONFIG.YAW_TURN_RATE);
        this.headingYaw = wrapDegrees(this.headingYaw);
        this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);

        // 4. Aerodynamic Bank Angle (Roll)
        if (this.barrelRollTicks > 0) {
            this.barrelRollTicks--;
            const progress = 1.0 - (this.barrelRollTicks / 16.0);
            this.bankRoll = this.barrelRollDir * progress * 360.0;
        } else {
            // Wings bank into turns
            const targetRoll = mathClamp(-yawDiff * 1.5, -PLANE_CONFIG.BANK_MAX, PLANE_CONFIG.BANK_MAX);
            this.bankRoll = lerp(this.bankRoll, targetRoll, 0.15);
        }

        // 5. Dynamic Aerodynamic Lift & Vertical Rate
        // Vertical speed from pitch angle: climbing (pitch < 0) gives +Y, diving (pitch > 0) gives -Y
        const pitchRad = this.currentPitch * (Math.PI / 180);
        let verticalRate = -Math.sin(pitchRad) * this.airspeed;
        verticalRate = mathClamp(verticalRate, PLANE_CONFIG.MAX_DIVE_SPEED, PLANE_CONFIG.MAX_CLIMB_SPEED);

        // Lift vs Gravity: at full cruise speed, lift counters gravity completely.
        // Below stall speed, lift decays and gravity causes controlled gliding descent.
        const speedRatio = Math.min(1.0, this.airspeed / PLANE_CONFIG.CRUISE_SPEED);
        const lift = speedRatio * PLANE_CONFIG.GRAVITY;
        const gravityFall = (1.0 - speedRatio) * PLANE_CONFIG.GRAVITY;
        const netVy = verticalRate + lift - gravityFall;

        // Horizontal forward thrust accounting for pitch angle
        const forwardThrust = this.airspeed * Math.cos(pitchRad);
        const f = getForwardVector(this.currentYaw);

        let targetVx = f.x * forwardThrust;
        let targetVz = f.z * forwardThrust;

        // Lateral boost during barrel roll trick
        if (this.barrelRollTicks > 0) {
            const r = { x: -f.z, z: f.x };
            targetVx += r.x * this.barrelRollDir * 0.35;
            targetVz += r.z * this.barrelRollDir * 0.35;
        }

        // 6. Stable critically-damped impulse application
        const impulseX = (targetVx - curVel.x) * 0.35;
        const impulseY = (netVy - curVel.y) * 0.35;
        const impulseZ = (targetVz - curVel.z) * 0.35;

        try {
            this.vehicle.applyImpulse({ x: impulseX, y: impulseY, z: impulseZ });
            this.vehicle.setRotation({ x: this.currentPitch, y: this.currentYaw });
        } catch (e) {}
    }

    _handleCrashing(isOnGround, isInWater) {
        if (isOnGround || isInWater) {
            this._enterStationary();
        }
    }

    _enterTakeoff() {
        this.state = "takeoff";
        this.airspeed = 0.08;
        this.takeoffTicks = PLANE_CONFIG.TAKEOFF_TIME_MAX;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "takeoff");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _enterFlight() {
        this.state = "flying";
        this.flightImmunityTicks = 30; // 1.5 seconds immunity to clear runway
        this.airspeed = Math.max(this.airspeed, PLANE_CONFIG.CRUISE_SPEED * 0.8);

        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "flying");
            this.vehicle.triggerEvent("renderphoenix:enter_flight_mode");
        } catch (e) {}

        // Gentle vertical pop impulse clearing ground collision
        try {
            this.vehicle.applyImpulse({ x: 0, y: PLANE_CONFIG.LIFTOFF_Y_POP, z: 0 });
            this.vehicle.dimension.playSound("random.fuse", this.vehicle.location, { volume: 0.8, pitch: 1.4 });
        } catch (e) {}
    }

    _enterStationary() {
        this.state = "stationary";
        this.airspeed = 0;
        this.currentPitch = 0;
        this.bankRoll = 0;

        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "stationary");
            this.vehicle.setProperty("renderphoenix:wasd", "none");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _enterCrash() {
        this.state = "crashing";
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "crashing");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
            this.vehicle.dimension.createExplosion(this.vehicle.location, 1.0, {
                breaksBlocks: false,
                causesFire: false
            });
        } catch (e) {}
    }

    _startBarrelRoll() {
        if (this.trickCooldown > 0 || !this.player || !this.player.isValid || this.state !== "flying") return;

        this.barrelRollTicks = 16;
        // Determine roll direction based on yaw turn
        const yawDiff = wrapDegrees(this.player.getRotation().y - this.headingYaw);
        this.barrelRollDir = yawDiff < 0 ? -1 : 1;

        const anim = this.barrelRollDir === 1
            ? "animation.renderphoenix.plane_trick_right"
            : "animation.renderphoenix.plane_trick_left";

        try {
            this.vehicle.setProperty("renderphoenix:trick", "cooldown");
            this.vehicle.playAnimation(anim);
        } catch (e) {}

        this.trickCooldown = PLANE_CONFIG.TRICK_COOLDOWN;

        system.runTimeout(() => {
            if (!this.removed && this.vehicle?.isValid) {
                try {
                    this.vehicle.setProperty("renderphoenix:trick", "ready");
                } catch (e) {}
            }
        }, PLANE_CONFIG.TRICK_COOLDOWN);
    }

    _updateActionBar() {
        if (!this.player || !this.player.isValid) return;

        try {
            const kmh = Math.round(this.airspeed * 72);
            if (this.state === "takeoff") {
                this.player.onScreenDisplay.setActionBar(
                    `§6✈ Daladas Taxiing §f| §eSpeed: §f${kmh} km/h §f| §aPull up or Space to Lift Off!`
                );
            } else if (this.state === "flying") {
                const alt = Math.round(this.vehicle.location.y);
                const rollStatus = this.trick === "ready" ? "§aREADY" : "§7CD";
                this.player.onScreenDisplay.setActionBar(
                    `§b✈ Daladas Airborne §f| §7Spd: §f${kmh} km/h §f| §7Alt: §f${alt}m §f| §6Roll: ${rollStatus} §7(Punch)`
                );
            } else if (this.state === "stationary") {
                this.player.onScreenDisplay.setActionBar(
                    "§7✈ Daladas Grounded §f| §aHold W or Space to Taxi & Take Off"
                );
            }
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
        this._enterStationary();
        try {
            this.player?.onScreenDisplay?.setActionBar("");
        } catch (e) {}
    }
}
