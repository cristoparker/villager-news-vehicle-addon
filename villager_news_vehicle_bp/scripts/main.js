/**
 * Villager News Vehicle Addon - Main Script
 * Handles Daladas Plane flight physics, missile firing, and smoke effects.
 */

import { world, system } from "@minecraft/server";
import { tickPlanePhysics } from "./planePhysics.js";
import { shootMissile, tickMissiles } from "./weapons.js";

// Helper to get player rider on a vehicle
function getVehicleRiderPlayer(vehicle) {
    if (!vehicle || !vehicle.isValid) return null;
    const rideable = vehicle.getComponent("minecraft:rideable");
    return rideable?.getRiders().find(r => r.typeId === "minecraft:player") || null;
}

// 1. Data-driven entity trigger (fired by interact or damage_sensor event: renderphoenix:shoot_missile)
world.afterEvents.dataDrivenEntityTrigger.subscribe((event) => {
    if (event.eventId === "renderphoenix:shoot_missile") {
        const vehicle = event.entity;
        if (vehicle && vehicle.isValid) {
            const player = getVehicleRiderPlayer(vehicle);
            if (player) {
                shootMissile(vehicle, player);
            }
        }
    }
});

// 2. Left-click attack / punch detection while riding
world.afterEvents.entityHitEntity.subscribe((event) => {
    const attacker = event.damagingEntity;
    const target = event.hitEntity;

    if (!attacker || !target || attacker.typeId !== "minecraft:player") return;

    if (target.typeId === "renderphoenix:tank" || target.typeId === "renderphoenix:plane") {
        const rideable = target.getComponent("minecraft:rideable");
        const isRider = rideable?.getRiders().some(r => r.id === attacker.id);
        if (isRider) {
            shootMissile(target, attacker);
        }
    }
});

// 3. Central game loop (runs every tick)
system.runInterval(() => {
    try {
        tickPlanePhysics();
        tickMissiles();
    } catch (e) {
        // Prevent script engine crashes
    }
}, 1);

console.warn("[Villager News Vehicle Addon] Scripts initialized successfully!");
