/**
 * Daladas Plane Flight Physics
 * High-speed jet physics ported from Vanilla Vehicles PlaneBehavior.js.
 * Features:
 * - High jet propulsion speed (3.5+ blocks/tick) matching the Daladas jet airliner scale
 * - Authentic Vanilla Vehicles smooth view-direction and knockback flight equations
 * - Natural aerodynamic gliding and gravity (NO helicopter hovering)
 * - Throttle control: Forward = Full Afterburner, Neutral = High Cruise, S = Airbrake/Descent
 * - Dual wing jet engine contrail smoke trails
 * - Runway taxi, acceleration roll, takeoff, and smooth landing
 */

import { world } from "@minecraft/server";
import { smoothValue, smoothAngle, mathClamp } from "./mathUtils.js";

const JET_CONFIG = {
    AFTERBURNER_SPEED: 3.6,           // Full throttle jet flight speed
    CRUISE_SPEED: 2.8,                // Neutral gliding cruise speed
    BRAKE_SPEED: 1.2,                 // Airbrake / landing approach speed
    RUNWAY_ACCEL: 0.04,               // Ground roll acceleration
    TAKEOFF_SPEED_THRESHOLD: 0.9,     // Ground speed needed before lift-off
    VERTICAL_SPEED_FACTOR: 0.85,      // Responsive climb/dive control
    VERTICAL_DAMPENING: 0.4,          // Speed drop on steep vertical climb
    SMOOTHING_HORIZONTAL: 28,         // Responsive jet steering
    SMOOTHING_VERTICAL: 22            // Responsive pitch response
};

class DaladasJetSession {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.state = vehicle.isOnGround ? "taxi" : "flying";
        this.groundSpeed = 0;
        this.takeoffRollTicks = 0;

        this.histories = {
            xView: [],
            yView: [],
            zView: [],
            yaw: []
        };
    }

    update() {
        if (!this.vehicle || !this.vehicle.isValid) return false;
        if (!this.player || !this.player.isValid) return false;

        // Check if player is still riding
        const rideable = this.vehicle.getComponent("minecraft:rideable");
        const riders = rideable?.getRiders() || [];
        const isRider = riders.some(r => r.id === this.player.id);
        if (!isRider) return false;

        // Controls input
        let forwardHeld = false;
        let backwardHeld = false;
        if (this.player.inputInfo) {
            const inputVec = this.player.inputInfo.getMovementVector();
            forwardHeld = inputVec.y > 0.1;
            backwardHeld = inputVec.y < -0.1;
        }

        const viewDir = this.player.getViewDirection();
        const isOnGround = this.vehicle.isOnGround;

        // Smooth view direction
        const smooth_x = smoothValue(viewDir.x, this.histories.xView, JET_CONFIG.SMOOTHING_HORIZONTAL);
        const smooth_z = smoothValue(viewDir.z, this.histories.zView, JET_CONFIG.SMOOTHING_HORIZONTAL);
        const smooth_y = smoothValue(viewDir.y, this.histories.yView, JET_CONFIG.SMOOTHING_VERTICAL);

        const targetYaw = Math.atan2(smooth_x, smooth_z) * (180 / Math.PI);
        const smooth_yaw = smoothAngle(targetYaw, this.histories.yaw, 10);

        // State Machine
        if (this.state === "taxi") {
            // Ground taxi & runway acceleration
            if (forwardHeld) {
                this.takeoffRollTicks++;
                this.groundSpeed = Math.min(this.groundSpeed + JET_CONFIG.RUNWAY_ACCEL, 1.4);

                // Steer heading with player look
                this.vehicle.setRotation({ x: 0, y: -smooth_yaw });

                // Push forward along runway
                const yawRad = (-smooth_yaw) * (Math.PI / 180);
                const fx = Math.sin(yawRad);
                const fz = Math.cos(yawRad);
                this.vehicle.applyImpulse({
                    x: fx * this.groundSpeed * 0.5,
                    y: 0,
                    z: fz * this.groundSpeed * 0.5
                });

                // Lift off when speed is up and player pitches up (or sustained roll)
                if ((this.groundSpeed >= JET_CONFIG.TAKEOFF_SPEED_THRESHOLD && smooth_y > 0.05) || this.takeoffRollTicks > 35) {
                    this.state = "flying";
                }
            } else if (backwardHeld) {
                this.groundSpeed = Math.max(0, this.groundSpeed - 0.06);
                this.takeoffRollTicks = 0;
            } else {
                this.groundSpeed = Math.max(0, this.groundSpeed - 0.03);
            }

            // If player spawns or drives off cliff, immediately enter flying
            if (!isOnGround) {
                this.state = "flying";
            }

        } else if (this.state === "flying") {
            // Touchdown detection: on ground with downward/level pitch and holding backward or low vertical speed
            if (isOnGround && smooth_y <= 0.05 && (backwardHeld || this.takeoffRollTicks > 30)) {
                this.state = "taxi";
                this.groundSpeed = 0.8;
                this.takeoffRollTicks = 0;
                return true;
            }

            this.takeoffRollTicks++;

            // Visual bank and pitch
            const yaw = Math.atan2(smooth_x, smooth_z) * (180 / Math.PI);
            const pitch = -Math.asin(mathClamp(smooth_y, -0.92, 0.92)) * (180 / Math.PI);
            this.vehicle.setRotation({ x: pitch * 1.1, y: -yaw });

            // Determine jet airspeed based on throttle input
            let baseSpeed = JET_CONFIG.CRUISE_SPEED;
            if (forwardHeld) {
                baseSpeed = JET_CONFIG.AFTERBURNER_SPEED; // Full jet throttle!
            } else if (backwardHeld) {
                baseSpeed = JET_CONFIG.BRAKE_SPEED;       // Airbrake / landing speed
            }

            const pitchFactor = Math.abs(smooth_y) * JET_CONFIG.VERTICAL_DAMPENING;
            const targetHorizSpeed = baseSpeed * (1 - pitchFactor);
            const targetVertSpeed = baseSpeed * smooth_y * JET_CONFIG.VERTICAL_SPEED_FACTOR;

            // Apply flight propulsion
            this.vehicle.applyKnockback(
                {
                    x: smooth_x * targetHorizSpeed,
                    z: smooth_z * targetHorizSpeed
                },
                targetVertSpeed
            );

            // Dual engine jet contrails
            this.emitJetSmoke(yaw);
        }

        return true;
    }

    emitJetSmoke(yaw) {
        try {
            const loc = this.vehicle.location;
            const dim = this.vehicle.dimension;

            const yawRad = (-yaw) * (Math.PI / 180);
            const fx = Math.sin(yawRad);
            const fz = Math.cos(yawRad);
            const rx = Math.cos(yawRad);
            const rz = -Math.sin(yawRad);

            // Wing engines: 3.5m out left and right, 1.5m behind
            const leftEngine = {
                x: loc.x - rx * 3.5 - fx * 1.5,
                y: loc.y + 0.4,
                z: loc.z - rz * 3.5 - fz * 1.5
            };
            const rightEngine = {
                x: loc.x + rx * 3.5 - fx * 1.5,
                y: loc.y + 0.4,
                z: loc.z + rz * 3.5 - fz * 1.5
            };

            dim.spawnParticle("minecraft:basic_smoke_particle", leftEngine);
            dim.spawnParticle("minecraft:basic_smoke_particle", rightEngine);
            dim.spawnParticle("minecraft:campfire_smoke_particle", leftEngine);
            dim.spawnParticle("minecraft:campfire_smoke_particle", rightEngine);
        } catch (e) {}
    }
}

const activeJetSessions = new Map();

export function tickPlanePhysics() {
    const players = world.getPlayers();
    for (const player of players) {
        if (!player || !player.isValid) continue;

        let riddenPlane = null;
        try {
            const nearby = player.dimension.getEntities({
                location: player.location,
                maxDistance: 8,
                type: "renderphoenix:plane"
            });

            for (const plane of nearby) {
                const rideable = plane.getComponent("minecraft:rideable");
                if (rideable?.getRiders().some(r => r.id === player.id)) {
                    riddenPlane = plane;
                    break;
                }
            }
        } catch (e) {}

        if (riddenPlane) {
            let session = activeJetSessions.get(riddenPlane.id);
            if (!session) {
                session = new DaladasJetSession(riddenPlane, player);
                activeJetSessions.set(riddenPlane.id, session);
            }
        }
    }

    for (const [id, session] of activeJetSessions.entries()) {
        const stillActive = session.update();
        if (!stillActive) {
            activeJetSessions.delete(id);
        }
    }
}
