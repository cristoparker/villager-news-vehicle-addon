/**
 * Daladas Fighter Jet / Airliner - Flight Physics & Behavior System
 *
 * Implements full 3D aerodynamic flight model calibrated to EXACTLY 2x the speed
 * of the reference Vanilla Vehicles Plane addon:
 * - Reference Flight Speed: 1.1 blocks/tick  --> Daladas Cruise: 2.2 blocks/tick (Exact 2x)
 * - Reference Taxi Speed:   0.33 blocks/tick --> Daladas Taxi:   0.66 blocks/tick (Exact 2x)
 * - Reference Acceleration: 0.007 blocks/tick² -> Daladas Accel: 0.014 blocks/tick² (Exact 2x)
 * - Precision Delta Velocity Control: Prevents impulse accumulation & lightspeed runaway!
 * - Smooth ground taxiing, throttle acceleration, and liftoff rotation
 * - Powerful 3D aerodynamic lift and propulsion (climbing, level cruise, diving)
 * - Smooth yaw turning & bank roll following player view
 * - Fail-safe input handling (direct player.inputInfo + Jump/Spacebar fallback)
 * - Clean liftoff pop impulse ensuring separation from runway
 * - Ground safety landing detection (touchdown on runway/water)
 * - Aerial barrel roll trick (left/right) with third-person camera easing
 * - Telemetry action bar HUD with authentic km/h readout
 */

import { world, system } from "@minecraft/server";
import { smoothValue, smoothAngle, planeAnimCorrector, calculateQuickView, mathClamp } from "./mathUtils.js";

export const PLANE_CONFIG = {
    // Flight speeds (blocks/tick: 1 block/tick = 20 m/s = 72 km/h)
    // EXACTLY 2x of reference Vanilla Vehicles plane (reference TOTAL_SPEED = 1.1)
    TOTAL_SPEED: 2.2,                     // Exact 2x reference flight speed (158 km/h)
    BOOST_SPEED: 2.7,                     // Throttle boost speed (Hold W + Space/Jump, 194 km/h)
    BRAKE_SPEED: 1.1,                     // Airbrake speed (Hold S, 79 km/h - reference base speed)

    // Ground speeds - Exact 2x of reference Vanilla Vehicles plane (reference ground = 0.33, accel = 0.007)
    ACCELERATION: 0.014,                  // Exact 2x reference ground acceleration
    MAX_GROUND_SPEED: 0.66,               // Exact 2x reference ground taxi speed (47 km/h)
    ROTATION_SPEED_MIN: 0.35,             // Speed threshold for pilot rotation pull-up

    // Aerodynamics - Direct from reference proportions
    VERTICAL_SPEED_FACTOR: 0.60,          // Reference vertical factor (0.6 * 2.2 = 1.32 vertical speed)
    VERTICAL_FACTOR: 0.80,                // Reference pitch drag factor
    LIFTOFF_Y_IMPULSE: 0.32,              // Vertical liftoff pop impulse to clear runway

    // Timings - Direct from reference
    TAKEOFF_TIME: 40,                     // Runway taxi time in ticks (2.0s, matches reference)
    DISABLE_FLIGHT_COOLDOWN: 25,          // Ground immunity buffer after takeoff (1.25s, matches reference)
    TRICK_COOLDOWN: 30,                   // Cooldown between barrel rolls (1.5s, matches reference)

    // Smoothing filters - Direct from reference
    SMOOTHING_H: 30,                      // Reference horizontal look smoothing (SMOOTHING_FACTOR_HORIZONTAL)
    SMOOTHING_H_QUICK: 15,                // Reference steering responsiveness (SMOOTHING_FACTOR_HORIZONTAL_QUICKER)
    SMOOTHING_V_ON: 50,                   // Reference vertical smoothing when steep
    SMOOTHING_V_OFF: 20,                  // Reference vertical smoothing default
    SMOOTHING_V_TAIL: 25                  // Reference tail-off timer
};

export class PlaneBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.removed = false;

        this.state = "stationary";
        this.speed = 0;
        this.takeoffTime = PLANE_CONFIG.TAKEOFF_TIME;
        this.disableFlightCooldown = 0;
        this.trickCooldown = 0;
        this.tickCounter = 0;
        this.trick = "ready";

        this.velocity = { x: 0, y: 0, z: 0 };
        this.horizontalSpeed = 0;
        this.viewDir = { x: 0, y: 0, z: 1 };
        this.playerRot = { x: 0, y: 0 };
        this.vehicleRot = { x: 0, y: 0 };
        this.targetVerticalSpeed = 0;
        this.navigation = null;

        this.controls = {
            forward: false,
            backward: false,
            left: false,
            right: false
        };

        this.smoothV = PLANE_CONFIG.SMOOTHING_V_OFF;
        this.smoothVTimeout = null;
        this.wasConditionMet = false;
        this.cameraClearTimeout = null;
        this.trickIntervalId = null;

        this.hist = {
            quickX: [],
            quickZ: [],
            quickDeg: [],
            xView: [],
            yView: [],
            yViewAnim: [],
            zView: []
        };

        this.smooth_x = 0;
        this.smooth_z = 0;
        this.smooth_y = 0;
        this.smooth_y_anim = 0;
        this.quick_x = 0;
        this.quick_z = 0;
        this.quick_deg = 0;
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
        if (this.removed || !this.vehicle || !this.vehicle.isValid) {
            this.cleanup();
            return;
        }

        this.tickCounter++;
        this.trickCooldown = Math.max(0, this.trickCooldown - 1);

        const rider = this.getRider();
        if (!rider || !this.player || !this.player.isValid) {
            if (this.state === "flying" || this.state === "takeoff") {
                this._enterStationary();
            }
            return;
        }

        // 1. Gather player and entity physics data
        try { this.velocity = this.vehicle.getVelocity(); } catch (e) {}
        this.horizontalSpeed = Math.hypot(this.velocity.x, this.velocity.z);

        try { this.viewDir = this.player.getViewDirection(); } catch (e) {}
        try { this.playerRot = this.player.getRotation(); } catch (e) {}
        try { this.vehicleRot = this.vehicle.getRotation(); } catch (e) {}

        // 2. Read trick property (triggered by damage_sensor / punch)
        let currentTrick = "ready";
        try {
            currentTrick = this.vehicle.getProperty("renderphoenix:trick") || "ready";
        } catch (e) {}

        if (currentTrick === "active" && this.trick !== "active") {
            this.trick = currentTrick;
            this._performTrick();
        } else {
            this.trick = currentTrick;
        }

        // 3. Process inputs
        this._updateControls();

        // 4. Calculate turn direction for barrel roll trick
        let yawChange = ((this.vehicleRot.y - this.playerRot.y) + 360) % 360;
        if (yawChange > 180) yawChange -= 360;
        this.navigation = yawChange > 1 ? "left" : yawChange < -1 ? "right" : null;

        // 5. Smoothing factor updates (direct from reference)
        this._updateSmoothingFactor();
        this._calcSmooth();

        // 6. State machine logic
        switch (this.state) {
            case "stationary":
                this._handleStationary();
                break;
            case "takeoff":
                this._handleTakeoff();
                break;
            case "flying":
                this._handleFlying();
                break;
            case "crashing":
                this._handleCrashing();
                break;
        }

        // 7. Trim history buffers
        for (const arr of Object.values(this.hist)) {
            if (arr.length > 100) arr.splice(0, arr.length - 100);
        }

        // 8. Flight Telemetry HUD
        this._updateActionBar();
    }

    _updateControls() {
        if (!this.player || !this.player.isValid) {
            this.controls = { forward: false, backward: false, left: false, right: false };
            return;
        }

        let inputVec = null;
        try {
            if (this.player.inputInfo) {
                inputVec = this.player.inputInfo.getMovementVector();
            }
        } catch (e) {}

        const isJumping = this.player.isJumping || false;

        if (inputVec && (Math.abs(inputVec.x) > 0.05 || Math.abs(inputVec.y) > 0.05)) {
            this.controls.forward = inputVec.y > 0.1 || isJumping;
            this.controls.backward = inputVec.y < -0.1;
            this.controls.left = inputVec.x < -0.1;
            this.controls.right = inputVec.x > 0.1;
        } else {
            // Robust fallback if inputInfo is unavailable on player client
            if (this.state === "flying") {
                // Plane cruises forward automatically in flight
                this.controls.forward = true;
                this.controls.backward = false;
                this.controls.left = false;
                this.controls.right = false;
            } else {
                // On ground: Spacebar / Jump throttles forward taxi
                this.controls.forward = isJumping || (this.speed > 0.05);
                this.controls.backward = false;
                this.controls.left = false;
                this.controls.right = false;
            }
        }

        // Sync WASD enum property for client-side anims
        let wasd = "none";
        if (this.controls.forward) wasd = "w";
        else if (this.controls.backward) wasd = "s";
        else if (this.controls.right) wasd = "d";
        else if (this.controls.left) wasd = "a";

        try {
            if (this.vehicle.getProperty("renderphoenix:wasd") !== wasd) {
                this.vehicle.setProperty("renderphoenix:wasd", wasd);
            }
        } catch (e) {}
    }

    _updateSmoothingFactor() {
        const condMet = this.disableFlightCooldown <= 0 && (this.viewDir.y < -0.8 || this.viewDir.y > 0.9);

        if (!condMet && this.wasConditionMet && this.smoothVTimeout === null) {
            this.smoothVTimeout = PLANE_CONFIG.SMOOTHING_V_TAIL;
        }

        if (this.smoothVTimeout !== null) {
            this.smoothVTimeout--;
            if (this.smoothVTimeout <= 0) {
                this.smoothV = condMet ? PLANE_CONFIG.SMOOTHING_V_ON : PLANE_CONFIG.SMOOTHING_V_OFF;
                this.smoothVTimeout = null;
            }
        } else if (condMet) {
            this.smoothV = PLANE_CONFIG.SMOOTHING_V_ON;
        }

        this.wasConditionMet = condMet;
    }

    _calcSmooth() {
        const quickerDir = this.state === "takeoff" ? this.playerRot.y : this.vehicleRot.y;
        const qv = calculateQuickView(quickerDir);

        // When grounded/stationary, dampen pitch so model doesn't clip into the ground
        // BUT when flying, use active view direction immediately for climbing/diving!
        const onGroundStationary = (this.state === "stationary" || this.state === "takeoff") &&
            (this.vehicle.isOnGround || this.vehicle.isInWater);

        const cvAnim = onGroundStationary ? 0.05 : planeAnimCorrector(this.viewDir.y);
        const cv = onGroundStationary ? 0.05 : this.viewDir.y;

        this.smooth_y = smoothValue(cv, this.hist.yView, this.smoothV);
        this.smooth_y_anim = smoothValue(cvAnim, this.hist.yViewAnim, this.smoothV);
        this.smooth_x = smoothValue(this.viewDir.x, this.hist.xView, PLANE_CONFIG.SMOOTHING_H);
        this.smooth_z = smoothValue(this.viewDir.z, this.hist.zView, PLANE_CONFIG.SMOOTHING_H);
        this.quick_x = smoothValue(qv.x, this.hist.quickX, PLANE_CONFIG.SMOOTHING_H_QUICK);
        this.quick_z = smoothValue(qv.z, this.hist.quickZ, PLANE_CONFIG.SMOOTHING_H_QUICK);
        this.quick_deg = smoothAngle(quickerDir, this.hist.quickDeg, PLANE_CONFIG.SMOOTHING_H_QUICK);

        try {
            this.vehicle.setProperty("renderphoenix:plane_angle", -this.smooth_y * 80);
        } catch (e) {}
    }

    _handleStationary() {
        if (this.controls.forward) {
            this._enterTakeoff();
        } else {
            // Controlled ground braking to complete stop
            this.speed = Math.max(0, this.speed - 0.03);
            const curVx = this.velocity?.x || 0;
            const curVz = this.velocity?.z || 0;

            if (Math.hypot(curVx, curVz) > 0.02) {
                try {
                    this.vehicle.applyImpulse({
                        x: -curVx * 0.35,
                        y: 0,
                        z: -curVz * 0.35
                    });
                } catch (e) {}
            }
            try {
                this.vehicle.setRotation({ x: 0, y: this.quick_deg });
            } catch (e) {}
        }
    }

    _handleTakeoff() {
        if (this.controls.forward) {
            // Accelerate along runway up to MAX_GROUND_SPEED (0.66 blocks/tick = 2x reference)
            this.speed = Math.min(this.speed + PLANE_CONFIG.ACCELERATION, PLANE_CONFIG.MAX_GROUND_SPEED);

            const targetVx = this.quick_x * this.speed;
            const targetVz = this.quick_z * this.speed;
            const curVx = this.velocity?.x || 0;
            const curVz = this.velocity?.z || 0;

            // Precision velocity tracking: prevents runaway ground speed
            const groundImpulseX = (targetVx - curVx) * 0.40 + (targetVx * 0.04);
            const groundImpulseZ = (targetVz - curVz) * 0.40 + (targetVz * 0.04);

            try {
                this.vehicle.applyImpulse({
                    x: groundImpulseX,
                    y: 0,
                    z: groundImpulseZ
                });
            } catch (e) {}

            try {
                this.vehicle.setRotation({ x: 0, y: this.quick_deg });
            } catch (e) {}

            this.takeoffTime--;

            // Liftoff condition: runway roll completed (40 ticks) OR pilot pulls up at rotation speed
            const isPullingUp = this.viewDir.y > 0.12 || (this.player && this.player.isJumping);
            const canRotate = this.speed >= PLANE_CONFIG.ROTATION_SPEED_MIN && isPullingUp;

            if (this.takeoffTime <= 0 || canRotate) {
                this._enterFlight();
            }
        } else {
            // Forward input released - abort takeoff
            this._enterStationary();
        }
    }

    _handleFlying() {
        if (this.disableFlightCooldown > 0) {
            this.disableFlightCooldown--;
        }

        // Landing & surface detection (only active after takeoff immunity window)
        if (this.disableFlightCooldown <= 0) {
            const touchingSurface = this.vehicle.isOnGround || this.vehicle.isInWater;
            if (touchingSurface) {
                const isSteepDive = this.viewDir.y < -0.45 && this.horizontalSpeed > 0.65;
                if (isSteepDive) {
                    this._enterCrash();
                    return;
                } else if (this.viewDir.y <= 0.15) {
                    // Smooth touchdown on runway or water
                    this._enterStationary();
                    return;
                }
            }
        }

        // Target flight speed: EXACTLY 2.2 blocks/tick (2x reference 1.1)
        let targetSpeed = PLANE_CONFIG.TOTAL_SPEED;
        if (this.controls.forward && this.player && this.player.isJumping) {
            targetSpeed = PLANE_CONFIG.BOOST_SPEED; // 2.7
        } else if (this.controls.backward) {
            targetSpeed = PLANE_CONFIG.BRAKE_SPEED; // 1.1 (reference base speed)
        }

        // Pitch aerodynamic drag factor (matches reference)
        const pitchFactor = Math.abs(this.smooth_y) * PLANE_CONFIG.VERTICAL_FACTOR;
        const forwardThrust = targetSpeed * (1 - pitchFactor * 0.40);
        this.targetVerticalSpeed = targetSpeed * this.smooth_y * PLANE_CONFIG.VERTICAL_SPEED_FACTOR;

        // Visual Rotation: Smooth 3D Bank, Pitch, and Yaw
        const yaw = Math.atan2(this.smooth_x, this.smooth_z) * (180 / Math.PI);
        const isExtreme = Math.abs(this.smooth_y_anim) > 1;
        const pitch = isExtreme
            ? (this.smooth_y_anim > 1 ? -90 : 90)
            : -Math.asin(Math.max(-1, Math.min(1, this.smooth_y_anim))) * (180 / Math.PI);

        try {
            this.vehicle.setRotation({ x: pitch * 1.10, y: -yaw });
        } catch (e) {}

        // Target 3D flight velocity vector
        const targetVx = this.smooth_x * forwardThrust;
        const targetVy = this.targetVerticalSpeed;
        const targetVz = this.smooth_z * forwardThrust;

        // Precision Delta Velocity Control:
        // Calculates the exact impulse needed to reach and hold target velocity without runaway accumulation!
        const curVx = this.velocity?.x || 0;
        const curVy = this.velocity?.y || 0;
        const curVz = this.velocity?.z || 0;

        const impulseX = (targetVx - curVx) * 0.35 + (targetVx * 0.02);
        const impulseY = (targetVy - curVy) * 0.35 + (targetVy * 0.02);
        const impulseZ = (targetVz - curVz) * 0.35 + (targetVz * 0.02);

        try {
            this.vehicle.applyImpulse({
                x: impulseX,
                y: impulseY,
                z: impulseZ
            });
        } catch (e) {}
    }

    _handleCrashing() {
        if (this.vehicle.isOnGround || this.vehicle.isInWater) {
            this._enterStationary();
        }
    }

    _enterTakeoff() {
        this.state = "takeoff";
        this.speed = 0.05;
        this.takeoffTime = PLANE_CONFIG.TAKEOFF_TIME;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "takeoff");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _enterFlight() {
        this.state = "flying";
        this.disableFlightCooldown = PLANE_CONFIG.DISABLE_FLIGHT_COOLDOWN;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "flying");
            this.vehicle.triggerEvent("renderphoenix:enter_flight_mode");
        } catch (e) {}

        // Clean vertical liftoff pop impulse to clear ground collision
        const qv = calculateQuickView(this.vehicleRot.y);
        try {
            this.vehicle.applyImpulse({
                x: qv.x * 0.30,
                y: PLANE_CONFIG.LIFTOFF_Y_IMPULSE,
                z: qv.z * 0.30
            });
        } catch (e) {}

        try {
            this.vehicle.dimension.playSound("random.fuse", this.vehicle.location, { volume: 0.7, pitch: 1.6 });
        } catch (e) {}
    }

    _enterStationary() {
        this.state = "stationary";
        this.speed = 0;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "stationary");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _enterCrash() {
        this.state = "crashing";
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "crashing");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
            this.vehicle.dimension.createExplosion(this.vehicle.location, 1.2, {
                breaksBlocks: false,
                causesFire: false
            });
        } catch (e) {}
    }

    _performTrick() {
        if (this.trickCooldown > 0 || !this.player || !this.player.isValid) return;

        const dir = this.navigation || "right";
        const anims = {
            right: "animation.renderphoenix.plane_trick_right",
            left: "animation.renderphoenix.plane_trick_left"
        };

        try { this.vehicle.setProperty("renderphoenix:trick", "cooldown"); } catch (e) {}
        try { this.vehicle.playAnimation(anims[dir]); } catch (e) {}

        if (this.cameraClearTimeout !== null) {
            system.clearRun(this.cameraClearTimeout);
            this.cameraClearTimeout = null;
        }

        try {
            this.player.camera.setCamera("minecraft:third_person", {
                easeOptions: { easeType: "InOutSine", easeTime: 0.8 }
            });
        } catch (e) {}

        // Lateral barrel roll impulse burst
        const vf = 0.40;
        const kx = dir === "right" ? -this.smooth_z * vf : this.smooth_z * vf;
        const kz = dir === "right" ? this.smooth_x * vf : -this.smooth_x * vf;
        let ticks = 0;

        if (this.trickIntervalId !== null) {
            system.clearRun(this.trickIntervalId);
        }

        this.trickIntervalId = system.runInterval(() => {
            if (ticks++ >= 14 || this.removed || !this.vehicle?.isValid ||
                this.vehicle.isOnGround || !this.getRider() || this.state !== "flying") {
                if (this.trickIntervalId !== null) {
                    system.clearRun(this.trickIntervalId);
                    this.trickIntervalId = null;
                }
                return;
            }
            try { this.vehicle.applyImpulse({ x: kx, y: 0.04, z: kz }); } catch (e) {}
        }, 1);

        this.trickCooldown = PLANE_CONFIG.TRICK_COOLDOWN;

        system.runTimeout(() => {
            if (!this.removed && this.vehicle?.isValid) {
                try { this.vehicle.setProperty("renderphoenix:trick", "ready"); } catch (e) {}
            }
        }, 25);

        this.cameraClearTimeout = system.runTimeout(() => {
            if (this.player?.isValid && !this.removed) {
                try { this.player.camera.clear(); } catch (e) {}
            }
            this.cameraClearTimeout = null;
        }, 40);
    }

    _updateActionBar() {
        if (!this.player || !this.player.isValid) return;

        try {
            if (this.state === "takeoff") {
                const kmh = Math.round(this.speed * 72);
                const secsRemaining = Math.max(0, (this.takeoffTime / 20).toFixed(1));
                this.player.onScreenDisplay.setActionBar(
                    `§6✈ Daladas Taxiing... §f| §eSpeed: §f${kmh} km/h §f| §aLiftoff in §f${secsRemaining}s §7(Hold W or Space)`
                );
            } else if (this.state === "flying") {
                const kmh = Math.round(this.horizontalSpeed * 72);
                const alt = Math.round(this.vehicle.location.y);
                const trickStatus = this.trick === "ready" ? "§aREADY" : "§7CD";
                this.player.onScreenDisplay.setActionBar(
                    `§b✈ Daladas Airborne §f| §7Alt: §f${alt}m §f| §7Spd: §f${kmh} km/h §f| §6Roll: ${trickStatus} §7(Punch)`
                );
            } else if (this.state === "stationary") {
                this.player.onScreenDisplay.setActionBar(
                    "§7✈ Daladas Grounded §f| §aHold W or Space to Take Off!"
                );
            }
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
        if (this.cameraClearTimeout !== null) {
            system.clearRun(this.cameraClearTimeout);
            this.cameraClearTimeout = null;
        }
        if (this.trickIntervalId !== null) {
            system.clearRun(this.trickIntervalId);
            this.trickIntervalId = null;
        }
        try { this.player?.camera?.clear(); } catch (e) {}
        try { this.player?.onScreenDisplay?.setActionBar(""); } catch (e) {}
    }
}

// ---------- Session Registry ----------

const sessions = new Map();

export function tickPlanePhysics() {
    // Cleanup invalid or dead sessions
    for (const [id, b] of sessions.entries()) {
        if (!b.vehicle || !b.vehicle.isValid || b.removed) {
            b.cleanup();
            sessions.delete(id);
        }
    }

    // Register active planes with player riders
    for (const player of world.getPlayers()) {
        const vehicle = _getRidingPlane(player);
        if (!vehicle) continue;
        let b = sessions.get(vehicle.id);
        if (!b) {
            b = new PlaneBehavior(vehicle, player);
            sessions.set(vehicle.id, b);
        } else {
            b.setPlayer(player);
        }
    }

    // Update active behaviors
    for (const [, b] of sessions.entries()) {
        try { b.update(); } catch (e) {}
    }
}

export function getPlaneBehavior(vehicleId) {
    return sessions.get(vehicleId) || null;
}

function _getRidingPlane(player) {
    try {
        const nearby = player.dimension.getEntities({
            location: player.location,
            maxDistance: 12,
            type: "renderphoenix:plane"
        });
        for (const v of nearby) {
            const r = v.getComponent("minecraft:rideable");
            if (r?.getRiders().some(x => x.id === player.id)) return v;
        }
    } catch (e) {}
    return null;
}
