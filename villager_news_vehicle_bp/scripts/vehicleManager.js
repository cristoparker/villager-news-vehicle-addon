/**
 * Villager News Vehicle Addon - Centralized Vehicle Lifecycle & Session Manager
 * Coordinates all 5 vehicle entities efficiently without expensive per-tick world scans.
 */

import { world, system } from "@minecraft/server";
import { FirefighterBehavior, TankBehavior, BoatBehavior } from "./groundVehiclePhysics.js";
import { HelicopterBehavior } from "./helicopterPhysics.js";
import { PlaneBehavior } from "./planePhysics.js";

export const VEHICLE_TYPE_IDS = [
    "renderphoenix:firefighter",
    "renderphoenix:tank",
    "renderphoenix:boat",
    "renderphoenix:helicopter",
    "renderphoenix:plane"
];

// Active vehicle behavior sessions (vehicle.id -> behavior instance)
const activeVehicleSessions = new Map();

/**
 * Gets the controlling player rider (seat 0) of a vehicle
 */
export function getControllingDriver(vehicle) {
    if (!vehicle || !vehicle.isValid) return null;
    try {
        const rideable = vehicle.getComponent("minecraft:rideable");
        if (!rideable) return null;
        const riders = rideable.getRiders();
        if (!riders || riders.length === 0) return null;

        // Seat 0 is the designated controlling seat for all 5 vehicles
        const driver = riders[0];
        if (driver && driver.isValid && driver.typeId === "minecraft:player") {
            return driver;
        }

        // Fallback: any player rider
        return riders.find(r => r && r.isValid && r.typeId === "minecraft:player") || null;
    } catch (e) {
        return null;
    }
}

/**
 * Instantiates the appropriate behavior controller for a vehicle
 */
function createVehicleBehavior(vehicle, player) {
    switch (vehicle.typeId) {
        case "renderphoenix:firefighter":
            return new FirefighterBehavior(vehicle, player);
        case "renderphoenix:tank":
            return new TankBehavior(vehicle, player);
        case "renderphoenix:boat":
            return new BoatBehavior(vehicle, player);
        case "renderphoenix:helicopter":
            return new HelicopterBehavior(vehicle, player);
        case "renderphoenix:plane":
            return new PlaneBehavior(vehicle, player);
        default:
            return null;
    }
}

/**
 * Registers or retrieves an active behavior session for a vehicle
 */
export function getOrRegisterVehicleSession(vehicle, player) {
    if (!vehicle || !vehicle.isValid) return null;

    let session = activeVehicleSessions.get(vehicle.id);
    if (!session) {
        session = createVehicleBehavior(vehicle, player);
        if (session) {
            activeVehicleSessions.set(vehicle.id, session);
        }
    } else if (player) {
        session.setPlayer(player);
    }
    return session;
}

/**
 * Central tick loop updating all active vehicles
 */
let scanTimer = 0;

export function tickVehicles() {
    // 1. Update and prune active vehicle sessions
    for (const [id, behavior] of activeVehicleSessions.entries()) {
        const vehicle = behavior.vehicle;
        if (!vehicle || !vehicle.isValid || behavior.removed) {
            try { behavior.cleanup(); } catch (e) {}
            activeVehicleSessions.delete(id);
            continue;
        }

        // Keep controlling driver in sync
        const driver = getControllingDriver(vehicle);
        behavior.setPlayer(driver);

        try {
            behavior.update();
        } catch (err) {
            // Protect script loop while logging unexpected errors
            console.warn(`[VehicleManager] Error updating ${vehicle.typeId}:`, err);
        }
    }

    // 2. Periodic lightweight discovery (every 20 ticks = 1 second)
    // Ensures pre-existing or mounted vehicles are registered without per-tick overhead
    scanTimer++;
    if (scanTimer >= 20) {
        scanTimer = 0;
        try {
            for (const player of world.getPlayers()) {
                const dim = player.dimension;
                // Query only immediate radius around player
                const nearby = dim.getEntities({
                    location: player.location,
                    maxDistance: 5,
                    families: ["vehicle"]
                });

                for (const v of nearby) {
                    if (VEHICLE_TYPE_IDS.includes(v.typeId)) {
                        const driver = getControllingDriver(v);
                        if (driver && driver.id === player.id) {
                            getOrRegisterVehicleSession(v, player);
                        }
                    }
                }
            }
        } catch (e) {}
    }
}

/**
 * Setup lifecycle event listeners
 */
export function initVehicleManager() {
    // Register instantly on mount interaction
    world.afterEvents.playerInteractWithEntity.subscribe((event) => {
        const vehicle = event.target;
        const player = event.player;

        if (vehicle && vehicle.isValid && VEHICLE_TYPE_IDS.includes(vehicle.typeId)) {
            system.runTimeout(() => {
                if (vehicle.isValid) {
                    const driver = getControllingDriver(vehicle);
                    if (driver) {
                        getOrRegisterVehicleSession(vehicle, driver);
                    }
                }
            }, 1);
        }
    });

    // Clean up when player disconnects
    world.afterEvents.playerLeave.subscribe(({ playerId }) => {
        for (const [id, behavior] of activeVehicleSessions.entries()) {
            if (behavior.player && behavior.player.id === playerId) {
                behavior.setPlayer(null);
            }
        }
    });
}
