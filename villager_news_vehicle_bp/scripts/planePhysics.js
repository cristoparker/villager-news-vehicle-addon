/**
 * Daladas Fighter Jet - Flight Physics
 * Clean direct port of reference PlaneBehavior.js
 * No fuel, no smoke, fighter jet tuning.
 */

import { world, system } from "@minecraft/server";
import { smoothValue, smoothAngle, planeAnimCorrector, calculateQuickView } from "./mathUtils.js";

const PLANE_CONFIG = {
    TOTAL_SPEED: 1.8,
    ACCELERATION: 0.013,
    VERTICAL_SPEED_FACTOR: 0.85,
    VERTICAL_FACTOR: 0.5,
    TAKEOFF_TIME: 70,
    DISABLE_FLIGHT_COOLDOWN: 35,
    TRICK_COOLDOWN: 30,
    SMOOTHING_H: 20,
    SMOOTHING_H_QUICK: 10,
    SMOOTHING_V_ON: 40,
    SMOOTHING_V_OFF: 15,
    SMOOTHING_V_TAIL: 20
};

class PlaneBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.removed = false;

        this.state = "stationary";
        this.speed = 0;
        this.maxSpeed = PLANE_CONFIG.TOTAL_SPEED * 0.3;
        this.takeoffTime = PLANE_CONFIG.TAKEOFF_TIME;
        this.disableFlightCooldown = 0;
        this.trickCooldown = 0;
        this.tickCounter = 0;
        this.trick = "ready";

        this.velocity = { x: 0, y: 0, z: 0 };
        this.horizontalSpeed = 0;
        this.viewDir = { x: 0, y: 0, z: 0 };
        this.targetVerticalSpeed = 0;
        this.navigation = null;

        this.controls = { forward: false, backward: false };

        this.smoothV = PLANE_CONFIG.SMOOTHING_V_OFF;
        this.smoothVTimeout = null;
        this.wasConditionMet = false;
        this.cameraClearTimeout = null;

        this.hist = {
            quickX: [], quickZ: [], quickDeg: [],
            xView: [], yView: [], yViewAnim: [], zView: []
        };

        this.playerRot = { x: 0, y: 0 };
        this.vehicleRot = { x: 0, y: 0 };
        this.smooth_x = 0;
        this.smooth_z = 0;
        this.smooth_y = 0;
        this.smooth_y_anim = 0;
        this.quick_x = 0;
        this.quick_z = 0;
        this.quick_deg = 0;
    }

    setPlayer(p) { this.player = p; }
    clearPlayer() { this.player = null; }

    getRider() {
        if (!this.vehicle || !this.vehicle.isValid) return null;
        return this.vehicle.getComponent("minecraft:rideable")?.getRiders()
            ?.find(r => r.typeId === "minecraft:player") || null;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        this.tickCounter++;
        this.trickCooldown = Math.max(0, this.trickCooldown - 1);

        // Gather physics data
        this.velocity = this.vehicle.getVelocity();
        this.horizontalSpeed = Math.hypot(this.velocity.x, this.velocity.z);

        const rider = this.getRider();
        if (!rider) {
            if (this.state === "flying") this._setStationary();
            if (this.state === "takeoff") this._setStationary();
            return;
        }

        // Gather player data
        try { this.viewDir = this.player.getViewDirection(); } catch (e) {}
        try { this.playerRot = this.player.getRotation(); } catch (e) {}
        try { this.vehicleRot = this.vehicle.getRotation(); } catch (e) {}

        // Read trick property
        let prevTrick = this.trick;
        try { this.trick = this.vehicle.getProperty("renderphoenix:trick") || "ready"; } catch (e) {}
        if (this.trick === "active" && prevTrick !== "active") {
            this._performTrick();
        }

        // Controls
        this._updateControls();

        // maxSpeed per state
        if (this.state === "flying") {
            this.maxSpeed = PLANE_CONFIG.TOTAL_SPEED;
        } else {
            this.maxSpeed = PLANE_CONFIG.TOTAL_SPEED * 0.3;
        }

        // Navigation
        let yawChange = ((this.vehicleRot.y - this.playerRot.y) + 360) % 360;
        if (yawChange > 180) yawChange -= 360;
        this.navigation = yawChange > 1 ? "left" : yawChange < -1 ? "right" : null;

        // Smoothing factor
        this._updateSmoothingFactor();

        // Smooth values
        this._calcSmooth();

        // State logic
        if (this.state === "stationary") {
            this._handleStationary();
        } else if (this.state === "takeoff") {
            this._handleTakeoff();
        } else if (this.state === "flying") {
            this._handleFlying();
        } else if (this.state === "crashing") {
            if (this.vehicle.isOnGround || this.vehicle.isInWater) {
                this._setStationary();
            }
        }

        // Trim histories
        for (const arr of Object.values(this.hist)) {
            if (arr.length > 150) arr.splice(0, arr.length - 150);
        }
    }

    _updateControls() {
        if (!this.player || !this.player.isValid) {
            this.controls.forward = false;
            this.controls.backward = false;
            return;
        }

        let inputVec = null;
        try {
            if (this.player.inputInfo) {
                inputVec = this.player.inputInfo.getMovementVector();
            }
        } catch (e) {}

        if (inputVec) {
            this.controls.forward = inputVec.y > 0.1;
            this.controls.backward = inputVec.y < -0.1;
        } else {
            // Fallback: detect from velocity or jump
            const qv = calculateQuickView(this.vehicleRot.y);
            const fwdSpd = this.velocity.x * qv.x + this.velocity.z * qv.z;
            const jumping = this.player.isJumping || false;

            if (this.state === "flying") {
                this.controls.forward = true;
                this.controls.backward = false;
            } else {
                this.controls.forward = (fwdSpd > 0.005) || jumping || (this.horizontalSpeed > 0.01) || (this.speed > 0.05);
                this.controls.backward = fwdSpd < -0.02;
            }
        }

        // Sync WASD anim property
        let wasd = "none";
        if (this.controls.forward) wasd = "w";
        else if (this.controls.backward) wasd = "s";
        else if (inputVec && inputVec.x > 0.1) wasd = "d";
        else if (inputVec && inputVec.x < -0.1) wasd = "a";

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

        const onGround = this.vehicle.isOnGround || this.vehicle.isInWater;
        const cvAnim = onGround ? 0.1 : planeAnimCorrector(this.viewDir.y);
        const cv = onGround ? 0.1 : this.viewDir.y;

        this.smooth_y = smoothValue(cv, this.hist.yView, this.smoothV);
        this.smooth_y_anim = smoothValue(cvAnim, this.hist.yViewAnim, this.smoothV);
        this.smooth_x = smoothValue(this.viewDir.x, this.hist.xView, PLANE_CONFIG.SMOOTHING_H);
        this.smooth_z = smoothValue(this.viewDir.z, this.hist.zView, PLANE_CONFIG.SMOOTHING_H);
        this.quick_x = smoothValue(qv.x, this.hist.quickX, PLANE_CONFIG.SMOOTHING_H_QUICK);
        this.quick_z = smoothValue(qv.z, this.hist.quickZ, PLANE_CONFIG.SMOOTHING_H_QUICK);
        this.quick_deg = smoothAngle(quickerDir, this.hist.quickDeg, PLANE_CONFIG.SMOOTHING_H_QUICK);

        try { this.vehicle.setProperty("renderphoenix:plane_angle", -this.smooth_y * 0.9); } catch (e) {}
    }

    _handleStationary() {
        if (this.controls.forward) {
            this._setTakeoff();
        } else {
            this.speed = Math.max(0, this.speed - 0.03);
            this._applyGroundImpulse();
            try { this.vehicle.setRotation({ x: 0, y: this.quick_deg }); } catch (e) {}
        }
    }

    _handleTakeoff() {
        if (this.controls.forward) {
            this.speed = Math.min(this.speed + PLANE_CONFIG.ACCELERATION, this.maxSpeed);
            this._applyGroundImpulse();
            try { this.vehicle.setRotation({ x: 0, y: this.quick_deg }); } catch (e) {}

            this.takeoffTime--;
            if (this.takeoffTime <= 0) {
                this._setFlying();
            }
        } else {
            this._setStationary();
        }
    }

    _handleFlying() {
        this.disableFlightCooldown--;

        if (this.disableFlightCooldown <= 0) {
            if (this.vehicle.isOnGround || this.vehicle.isInWater) {
                this._setStationary();
                return;
            }
        }

        // Visual rotation
        const pitchFactor = Math.abs(this.smooth_y) * PLANE_CONFIG.VERTICAL_FACTOR;
        const yaw = Math.atan2(this.smooth_x, this.smooth_z) * (180 / Math.PI);
        const isExtreme = Math.abs(this.smooth_y_anim) > 1;
        const pitch = isExtreme
            ? (this.smooth_y_anim > 1 ? -90 : 90)
            : -Math.asin(Math.max(-1, Math.min(1, this.smooth_y_anim))) * (180 / Math.PI);

        try { this.vehicle.setRotation({ x: pitch * 1.2, y: -yaw }); } catch (e) {}

        // Flight thrust - direct port of reference
        const targetSpeed = this.maxSpeed * (1 - pitchFactor);
        this.targetVerticalSpeed = this.maxSpeed * this.smooth_y * PLANE_CONFIG.VERTICAL_SPEED_FACTOR;

        try {
            this.vehicle.applyKnockback(
                { x: this.smooth_x * targetSpeed, z: this.smooth_z * targetSpeed },
                this.targetVerticalSpeed
            );
        } catch (e) {
            try {
                this.vehicle.applyImpulse({
                    x: this.smooth_x * targetSpeed * 0.25,
                    y: this.targetVerticalSpeed * 0.25,
                    z: this.smooth_z * targetSpeed * 0.25
                });
            } catch (err) {}
        }
    }

    _applyGroundImpulse() {
        // Direct port of reference applyImpulse()
        const groundOffset = this.vehicle.isOnGround ? 1 : 0.2;
        if (!this.vehicle.isOnGround || this.speed > 0.01) {
            try {
                this.vehicle.applyImpulse({
                    x: this.quick_x * this.speed * groundOffset,
                    y: 0,
                    z: this.quick_z * this.speed * groundOffset
                });
            } catch (e) {}
        }
    }

    _setStationary() {
        this.state = "stationary";
        this.speed = 0;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "stationary");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _setTakeoff() {
        this.state = "takeoff";
        this.speed = 0.03;
        this.takeoffTime = PLANE_CONFIG.TAKEOFF_TIME;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "takeoff");
            this.vehicle.triggerEvent("renderphoenix:enter_ground_mode");
        } catch (e) {}
    }

    _setFlying() {
        this.state = "flying";
        this.disableFlightCooldown = PLANE_CONFIG.DISABLE_FLIGHT_COOLDOWN;
        try {
            this.vehicle.setProperty("renderphoenix:plane_state", "flying");
            this.vehicle.triggerEvent("renderphoenix:enter_flight_mode");
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
                easeOptions: { easeType: "InOutSine", easeTime: 1.0 }
            });
        } catch (e) {}

        const vf = (1 - this.targetVerticalSpeed * 1.2) * 0.4;
        const kx = dir === "right" ? -this.smooth_z * vf : this.smooth_z * vf;
        const kz = dir === "right" ? this.smooth_x * vf : -this.smooth_x * vf;
        let ticks = 0;

        const intervalId = system.runInterval(() => {
            if (ticks++ >= 15 || this.removed || !this.vehicle?.isValid ||
                this.vehicle.isOnGround || !this.getRider() || this.state !== "flying") {
                system.clearRun(intervalId);
                return;
            }
            try { this.vehicle.applyImpulse({ x: kx, y: 0, z: kz }); } catch (e) {}
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
        }, 50);
    }

    cleanup() {
        this.removed = true;
        if (this.cameraClearTimeout !== null) {
            system.clearRun(this.cameraClearTimeout);
            this.cameraClearTimeout = null;
        }
        try { this.player?.camera?.clear(); } catch (e) {}
    }
}

// ---------- Session registry ----------

const sessions = new Map();

export function tickPlanePhysics() {
    // Cleanup dead sessions
    for (const [id, b] of sessions.entries()) {
        if (!b.vehicle || !b.vehicle.isValid) {
            b.cleanup();
            sessions.delete(id);
        }
    }

    // Register planes with riders
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

    // Tick all
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
            maxDistance: 6,
            type: "renderphoenix:plane"
        });
        for (const v of nearby) {
            const r = v.getComponent("minecraft:rideable");
            if (r?.getRiders().some(x => x.id === player.id)) return v;
        }
    } catch (e) {}
    return null;
}
