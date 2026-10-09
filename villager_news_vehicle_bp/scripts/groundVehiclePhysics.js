/**
 * Villager News Vehicle Addon - Ground & Water Vehicle Physics Controllers
 * Handles Firefighter Truck, Heavy Tank, and Villager Boat.
 */

import { world, system } from "@minecraft/server";
import { mathClamp, wrapDegrees, lerpAngle, getForwardVector, lerp } from "./mathUtils.js";

/**
 * Extracts player input states reliably across Keyboard, Controller, and Mobile/Touch.
 */
export function getPlayerDriverInput(player, vehicleYaw) {
    if (!player || !player.isValid) {
        return { forward: false, backward: false, left: false, right: false, isJumping: false, yawDiff: 0, inputX: 0, inputY: 0 };
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
    let inputX = 0;
    let inputY = 0;

    if (inputVec && (Math.abs(inputVec.x) > 0.05 || Math.abs(inputVec.y) > 0.05)) {
        inputX = inputVec.x;
        inputY = inputVec.y;
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

    return { forward, backward, left, right, isJumping, yawDiff, inputX, inputY };
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
        this.currentYaw = this.headingYaw;
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
            // Decelerate smoothly to stop when rider dismounts
            if (Math.abs(this.currentSpeed) > 0.02) {
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.15);
                const f = getForwardVector(this.currentYaw);
                try {
                    this.vehicle.applyImpulse({
                        x: (f.x * this.currentSpeed - curVel.x) * 0.35,
                        y: 0,
                        z: (f.z * this.currentSpeed - curVel.z) * 0.35
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            try {
                this.vehicle.setProperty("renderphoenix:wasd", "none");
            } catch (e) {}
            return;
        }

        // Process inputs
        const input = getPlayerDriverInput(this.player, this.currentYaw);

        // Synchronize wasd property for client animations
        let wasd = "none";
        if (input.forward) {
            wasd = input.left ? "wa" : (input.right ? "wd" : "w");
        } else if (input.backward) {
            wasd = input.left ? "sa" : (input.right ? "sd" : "s");
        } else if (input.right) {
            wasd = "d";
        } else if (input.left) {
            wasd = "a";
        }

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

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
        const isMoving = Math.abs(this.currentSpeed) > 0.02;

        if (input.left) {
            this.headingYaw -= FIREFIGHTER_CONFIG.TURN_RATE * steerDir;
        } else if (input.right) {
            this.headingYaw += FIREFIGHTER_CONFIG.TURN_RATE * steerDir;
        } else if (isMoving && Math.abs(input.yawDiff) > 5) {
            // Smooth camera steering assistance without abrupt step thresholds
            this.headingYaw += mathClamp(input.yawDiff * 0.06, -FIREFIGHTER_CONFIG.TURN_RATE, FIREFIGHTER_CONFIG.TURN_RATE) * steerDir;
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Smooth angle interpolation eliminates heading snap/jitter
        this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);

        // Apply local forward motion with stable, critically-damped impulse
        const f = getForwardVector(this.currentYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        if (Math.abs(this.currentSpeed) > 0.01) {
            const impulseX = (targetVx - curVel.x) * 0.35;
            const impulseZ = (targetVz - curVel.z) * 0.35;
            try {
                this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        } else {
            // When stopped, gently dampen residual drift
            if (Math.hypot(curVel.x, curVel.z) > 0.02) {
                try {
                    this.vehicle.applyImpulse({ x: -curVel.x * 0.25, y: 0, z: -curVel.z * 0.25 });
                } catch (e) {}
            }
            try {
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        }
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
        this.currentYaw = this.headingYaw;
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
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.15);
                const f = getForwardVector(this.currentYaw);
                try {
                    this.vehicle.applyImpulse({
                        x: (f.x * this.currentSpeed - curVel.x) * 0.35,
                        y: 0,
                        z: (f.z * this.currentSpeed - curVel.z) * 0.35
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            try {
                this.vehicle.setProperty("renderphoenix:wasd", "none");
            } catch (e) {}
            return;
        }

        const input = getPlayerDriverInput(this.player, this.currentYaw);

        // Synchronize wasd property for client track animations
        let wasd = "none";
        if (input.forward) {
            wasd = input.left ? "wa" : (input.right ? "wd" : "w");
        } else if (input.backward) {
            wasd = input.left ? "sa" : (input.right ? "sd" : "s");
        } else if (input.right) {
            wasd = "d";
        } else if (input.left) {
            wasd = "a";
        }

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

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
        } else if (Math.abs(this.currentSpeed) > 0.02 && Math.abs(input.yawDiff) > 5) {
            this.headingYaw += mathClamp(input.yawDiff * 0.06, -TANK_CONFIG.TURN_RATE, TANK_CONFIG.TURN_RATE);
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Smooth angle interpolation
        this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);

        // Apply local forward motion with stable, critically-damped impulse
        const f = getForwardVector(this.currentYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        if (Math.abs(this.currentSpeed) > 0.01) {
            const impulseX = (targetVx - curVel.x) * 0.35;
            const impulseZ = (targetVz - curVel.z) * 0.35;
            try {
                this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        } else {
            if (Math.hypot(curVel.x, curVel.z) > 0.02) {
                try {
                    this.vehicle.applyImpulse({ x: -curVel.x * 0.25, y: 0, z: -curVel.z * 0.25 });
                } catch (e) {}
            }
            try {
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        }
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
        this.currentYaw = this.headingYaw;
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
                this.currentSpeed = lerp(this.currentSpeed, 0, 0.15);
                const f = getForwardVector(this.currentYaw);
                try {
                    this.vehicle.applyImpulse({
                        x: (f.x * this.currentSpeed - curVel.x) * 0.35,
                        y: 0,
                        z: (f.z * this.currentSpeed - curVel.z) * 0.35
                    });
                } catch (e) {}
            } else {
                this.currentSpeed = 0;
            }
            try {
                this.vehicle.setProperty("renderphoenix:wasd", "none");
            } catch (e) {}
            return;
        }

        const input = getPlayerDriverInput(this.player, this.currentYaw);

        let wasd = "none";
        if (input.forward) wasd = "w";
        else if (input.backward) wasd = "s";
        else if (input.right) wasd = "d";
        else if (input.left) wasd = "a";

        try {
            this.vehicle.setProperty("renderphoenix:wasd", wasd);
        } catch (e) {}

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
        const isMoving = Math.abs(this.currentSpeed) > 0.02;

        if (input.left) {
            this.headingYaw -= BOAT_CONFIG.TURN_RATE * steerDir;
        } else if (input.right) {
            this.headingYaw += BOAT_CONFIG.TURN_RATE * steerDir;
        } else if (isMoving && Math.abs(input.yawDiff) > 5) {
            this.headingYaw += mathClamp(input.yawDiff * 0.06, -BOAT_CONFIG.TURN_RATE, BOAT_CONFIG.TURN_RATE) * steerDir;
        }
        this.headingYaw = wrapDegrees(this.headingYaw);

        // Smooth angle interpolation
        this.currentYaw = lerpAngle(this.currentYaw, this.headingYaw, 0.35);

        const f = getForwardVector(this.currentYaw);
        const targetVx = f.x * this.currentSpeed;
        const targetVz = f.z * this.currentSpeed;

        if (Math.abs(this.currentSpeed) > 0.01) {
            const impulseFactor = inWater ? 0.35 : 0.40;
            const impulseX = (targetVx - curVel.x) * impulseFactor;
            const impulseZ = (targetVz - curVel.z) * impulseFactor;

            try {
                this.vehicle.applyImpulse({ x: impulseX, y: 0, z: impulseZ });
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        } else {
            if (Math.hypot(curVel.x, curVel.z) > 0.02) {
                try {
                    this.vehicle.applyImpulse({ x: -curVel.x * 0.25, y: 0, z: -curVel.z * 0.25 });
                } catch (e) {}
            }
            try {
                this.vehicle.setRotation({ x: 0, y: this.currentYaw });
            } catch (e) {}
        }
    }

    cleanup() {
        this.removed = true;
    }
}
