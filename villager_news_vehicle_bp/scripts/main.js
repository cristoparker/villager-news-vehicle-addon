/**
 * Villager News Vehicle Addon - Main Script
 * Central controller coordinating all 5 vehicles:
 * - Daladas Plane
 * - Villager Helicopter
 * - Villager Tank
 * - Firefighter Truck
 * - Villager Boat
 * Plus weapon systems and tricks.
 */

import { world, system } from "@minecraft/server";
import { initVehicleManager, tickVehicles, getControllingDriver } from "./vehicleManager.js";
import { shootMissile, tickMissiles } from "./weapons.js";

// Initialize lifecycle listeners and session registry
initVehicleManager();

// 1. Data-driven entity trigger (fired by interact or damage_sensor events)
world.afterEvents.dataDrivenEntityTrigger.subscribe((event) => {
    if (event.eventId === "renderphoenix:shoot_missile") {
        const vehicle = event.entity;
        if (vehicle && vehicle.isValid) {
            const driver = getControllingDriver(vehicle);
            if (driver) {
                shootMissile(vehicle, driver);
            }
        }
    }
});

// 2. Left-click attack / punch detection while riding (Tank cannon & Plane nose weapon)
world.afterEvents.entityHitEntity.subscribe((event) => {
    const attacker = event.damagingEntity;
    const target = event.hitEntity;

    if (!attacker || !target || attacker.typeId !== "minecraft:player") return;

    // Tank can always shoot cannon on punch while riding
    if (target.typeId === "renderphoenix:tank") {
        const rideable = target.getComponent("minecraft:rideable");
        const isRider = rideable?.getRiders().some(r => r.id === attacker.id);
        if (isRider) {
            shootMissile(target, attacker);
        }
    } else if (target.typeId === "renderphoenix:plane") {
        // Plane triggers trick if ready & flying, or fires missile on ground / non-flying
        const state = target.getProperty("renderphoenix:plane_state");
        const trick = target.getProperty("renderphoenix:trick");
        if (state !== "flying" || trick !== "ready") {
            const rideable = target.getComponent("minecraft:rideable");
            const isRider = rideable?.getRiders().some(r => r.id === attacker.id);
            if (isRider) {
                shootMissile(target, attacker);
            }
        }
    }
});

// 3. Central game loop (runs every tick)
system.runInterval(() => {
    try {
        tickVehicles();
        tickMissiles();
    } catch (e) {
        console.warn("[Villager News Vehicle Addon] Tick error:", e);
    }
}, 1);

console.warn("[Villager News Vehicle Addon] All 5 vehicles and physics initialized successfully!");
