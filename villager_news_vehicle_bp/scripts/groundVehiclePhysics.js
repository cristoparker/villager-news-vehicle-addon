/**
 * Villager News Vehicle Addon - Ground & Water Vehicle Physics Controllers
 * Handles Firefighter Truck, Heavy Tank, and Villager Boat.
 */

import { world, system } from "@minecraft/server";
import { mathClamp, wrapDegrees, getForwardVector, lerp } from "./mathUtils.js";

/**
 * Extracts player input states reliably across Keyboard, Controller, and Mobile/Touch.
 */
export function getPlayerDriverInput(player, vehicleYaw) {
    if (!player || !player.isValid) {
        return { forward: false, backward: false, left: false, right: false, isJumping: false, yawDiff: 0 };
    }

    let inputVec = null;
    try {
        if (player.inputInfo) {
            inputVec = player.inputInfo.getMovementVector();
        }
    } catch (e) {}

    const isJumping = player.isJumping || false;
    let playerRot = { x: 0, y: vehicleYaw };
    try {
        playerRot = player.getRotation();
    } catch (e) {}

    const yawDiff = wrapDegrees(playerRot.y - vehicleYaw);

    let forward = false;
    let backward = false;
    let left = false;
    let right = false;

    if (inputVec && (Math.abs(inputVec.x) > 0.05 || Math.abs(inputVec.y) > 0.05)) {
        forward = inputVec.y > 0.1 || isJumping;
        backward = inputVec.y < -0.1;
        // In Bedrock getMovementVector: positive X is Left, negative X is Right
        left = inputVec.x > 0.1;
        right = inputVec.x < -0.1;
    } else {
        // Fallback for mobile/touch or when inputInfo vector is neutral:
        // Jump button functions as forward accelerator
        forward = isJumping;
    }

    return { forward, backward, left, right, isJumping, yawDiff };
}

// ============================================================================
// 1. FIREFIGHTER TRUCK CONTROLLER
// ============================================================================
export const FIREFIGHTER_CONFIG = {
    MAX_FORWARD_SPEED: 0.52,   // ~37 km/h - fast emergency response truck
    MAX_REVERSE_SPEED: -0.25,  // Reverse speed
    ACCEL: 0.040,              // Acceleration per tick
    BRAKE: 0.060,              // Braking / deceleration per tick
    TURN_RATE: 3.5             // Steering turn rate in degrees/tick
};

export class FirefighterBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.currentSpeed = 0;
        this.headingYaw = vehicle.getRotation()?.y || 0;
        this.removed = false;
    }

    setPlayer(player) {
        this.player = player;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        const hasDriver = this.player && this.player.isValid;
        const curVel = this.vehicle.getVelocity() || { x: 0, y: 0, z: 0 };

        if (!hasDriver) {
            // Decelerate to stop when rider dismounts
            if (Math.abs(this.currentSpeed) > 0.02) {
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.25);
                const f = getForwardVector(this.headingYaw);
                const targetVx = f.x * this.currentSpeed;
                const targetVz = f.z * this.currentSpeed;
                try {
                    this.vehicle.applyImpulse({
                        x: (targetVx - curVel.x) * 0.7,
                        y: 0,
                        z: (targetVz - curVel.z) * 0.7
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            return;
        }

        // Process inputs
        const input = getPlayerDriverInput(this.player, this.headingYaw);

        // Throttle & Acceleration
        if (input.forward) {
            this.currentSpeed = Math.min(this.currentSpeed + FIREFIGHTER_CONFIG.ACCEL, FIREFIGHTER_CONFIG.MAX_FORWARD_SPEED);
        } else if (input.backward) {
            this.currentSpeed = Math.max(this.currentSpeed - FIREFIGHTER_CONFIG.ACCEL, FIREFIGHTER_CONFIG.MAX_REVERSE_SPEED);
        } else {
            // Natural deceleration / braking
            if (this.currentSpeed > 0) {
                this.currentSpeed = Math.max(0, this.currentSpeed - FIREFIGHTER_CONFIG.BRAKE);
            } else if (this.currentSpeed < 0) {
                this.currentSpeed = Math.min(0, this.currentSpeed + FIREFIGHTER_CONFIG.BRAKE);
            }
        }

        // Steering (Inverts when reversing for realistic vehicular turning)
        const steerDir = this.currentSpeed >= 0 ? 1 : -1;
        const isMoving = Math.abs(this.currentSpeed) > 0.03;

        if (input.left) {
            this.headingYaw -= FIREFIGHTER_CONFIG.TURN_RATE * steerDir;
        } else if (input.right) {
            this.headingYaw += FIREFIGHTER_CONFIG.TURN_RATE * steerDir;
        } else if (isMoving && Math.abs(input.yawDiff) > 20) {
            // Mobile/camera steering assistance
            this.headingYaw += mathClamp(input.yawDiff * 0.12, -FIREFIGHTER_CONFIG.TURN_RATE, FIREFIGHTER_CONFIG.TURN_RATE) * steerDir;
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Apply local forward motion
        const f = getForwardVector(this.headingYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        const impulseX = (targetVx - curVel.x) * 0.85;
        const impulseZ = (targetVz - curVel.z) * 0.85;

        try {
            this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
            this.vehicle.setRotation({ x: 0, y: this.headingYaw });
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
    }
}

// ============================================================================
// 2. TANK CONTROLLER
// ============================================================================
export const TANK_CONFIG = {
    MAX_FORWARD_SPEED: 0.40,   // ~29 km/h - steady heavy armored combat tank
    MAX_REVERSE_SPEED: -0.22,  // Reverse speed
    ACCEL: 0.028,              // Heavier inertia acceleration
    BRAKE: 0.050,              // Braking rate
    TURN_RATE: 3.0             // Neutral pivot turn rate in degrees/tick
};

export class TankBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.currentSpeed = 0;
        this.headingYaw = vehicle.getRotation()?.y || 0;
        this.removed = false;
    }

    setPlayer(player) {
        this.player = player;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        const hasDriver = this.player && this.player.isValid;
        const curVel = this.vehicle.getVelocity() || { x: 0, y: 0, z: 0 };

        if (!hasDriver) {
            if (Math.abs(this.currentSpeed) > 0.02) {
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.25);
                const f = getForwardVector(this.headingYaw);
                try {
                    this.vehicle.applyImpulse({
                        x: (f.x * this.currentSpeed - curVel.x) * 0.7,
                        y: 0,
                        z: (f.z * this.currentSpeed - curVel.z) * 0.7
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            return;
        }

        const input = getPlayerDriverInput(this.player, this.headingYaw);

        // Throttle & Acceleration
        if (input.forward) {
            this.currentSpeed = Math.min(this.currentSpeed + TANK_CONFIG.ACCEL, TANK_CONFIG.MAX_FORWARD_SPEED);
        } else if (input.backward) {
            this.currentSpeed = Math.max(this.currentSpeed - TANK_CONFIG.ACCEL, TANK_CONFIG.MAX_REVERSE_SPEED);
        } else {
            if (this.currentSpeed > 0) {
                this.currentSpeed = Math.max(0, this.currentSpeed - TANK_CONFIG.BRAKE);
            } else if (this.currentSpeed < 0) {
                this.currentSpeed = Math.min(0, this.currentSpeed + TANK_CONFIG.BRAKE);
            }
        }

        // Tank neutral pivot steering: Can spin in place even at zero speed!
        if (input.left) {
            this.headingYaw -= TANK_CONFIG.TURN_RATE;
        } else if (input.right) {
            this.headingYaw += TANK_CONFIG.TURN_RATE;
        } else if (Math.abs(this.currentSpeed) > 0.03 && Math.abs(input.yawDiff) > 25) {
            this.headingYaw += mathClamp(input.yawDiff * 0.10, -TANK_CONFIG.TURN_RATE, TANK_CONFIG.TURN_RATE);
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Apply local forward motion
        const f = getForwardVector(this.headingYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        const impulseX = (targetVx - curVel.x) * 0.85;
        const impulseZ = (targetVz - curVel.z) * 0.85;

        try {
            this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
            this.vehicle.setRotation({ x: 0, y: this.headingYaw });
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
    }
}

// ============================================================================
// 3. VILLAGER BOAT CONTROLLER
// ============================================================================
export const BOAT_CONFIG = {
    WATER_FORWARD_SPEED: 0.45,  // Full boat speed in water (~32 km/h)
    WATER_REVERSE_SPEED: -0.20,
    LAND_FORWARD_SPEED: 0.12,   // Sliding on land
    LAND_REVERSE_SPEED: -0.06,
    ACCEL: 0.035,
    DECEL: 0.045,
    TURN_RATE: 3.2
};

export class BoatBehavior {
    constructor(vehicle, player) {
        this.vehicle = vehicle;
        this.player = player;
        this.currentSpeed = 0;
        this.headingYaw = vehicle.getRotation()?.y || 0;
        this.removed = false;
    }

    setPlayer(player) {
        this.player = player;
    }

    update() {
        if (this.removed || !this.vehicle || !this.vehicle.isValid) return;

        const hasDriver = this.player && this.player.isValid;
        const curVel = this.vehicle.getVelocity() || { x: 0, y: 0, z: 0 };
        const inWater = this.vehicle.isInWater || false;

        const maxForward = inWater ? BOAT_CONFIG.WATER_FORWARD_SPEED : BOAT_CONFIG.LAND_FORWARD_SPEED;
        const maxReverse = inWater ? BOAT_CONFIG.WATER_REVERSE_SPEED : BOAT_CONFIG.LAND_REVERSE_SPEED;

        if (!hasDriver) {
            if (Math.abs(this.currentSpeed) > 0.02) {
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.20);
                const f = getForwardVector(this.headingYaw);
                try {
                    this.vehicle.applyImpulse({
                        x: (f.x * this.currentSpeed - curVel.x) * 0.6,
                        y: 0,
                        z: (f.z * this.currentSpeed - curVel.z) * 0.6
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            return;
        }

        const input = getPlayerDriverInput(this.player, this.headingYaw);

        // Throttle
        if (input.forward) {
            this.currentSpeed = Math.min(this.currentSpeed + BOAT_CONFIG.ACCEL, maxForward);
        } else if (input.backward) {
            this.currentSpeed = Math.max(this.currentSpeed - BOAT_CONFIG.ACCEL, maxReverse);
        } else {
            if (this.currentSpeed > 0) {
                this.currentSpeed = Math.max(0, this.currentSpeed - BOAT_CONFIG.DECEL);
            } else if (this.currentSpeed < 0) {
                this.currentSpeed = Math.min(0, this.currentSpeed + BOAT_CONFIG.DECEL);
            }
        }

        // Rudder steering
        const steerDir = this.currentSpeed >= 0 ? 1 : -1;
        if (input.left) {
            this.headingYaw -= BOAT_CONFIG.TURN_RATE * steerDir;
        } else if (input.right) {
            this.headingYaw += BOAT_CONFIG.TURN_RATE * steerDir;
        } else if (Math.abs(this.currentSpeed) > 0.03 && Math.abs(input.yawDiff) > 20) {
            this.headingYaw += mathClamp(input.yawDiff * 0.12, -BOAT_CONFIG.TURN_RATE, BOAT_CONFIG.TURN_RATE) * steerDir;
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        const f = getForwardVector(this.headingYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        const impulseX = (targetVx - curVel.x) * (inWater ? 0.75 : 0.85);
        const impulseZ = (targetVz - curVel.z) * (inWater ? 0.75 : 0.85);

        try {
            this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
            this.vehicle.setRotation({ x: 0, y: this.headingYaw });
        } catch (e) {}
    }

    cleanup() {
        this.removed = true;
    }
}
