/**
 * Villager News Vehicle Addon - Weapons System
 * Fires villager missiles from Tank (head21 cannon) and Daladas Plane (nose)
 * with authentic high-speed projectile velocity and dense smoke trails.
 */

import { world, system } from "@minecraft/server";

// Track active missiles for continuous smoke trails
const activeMissiles = new Map();
// Cooldown per vehicle
const vehicleCooldowns = new Map();

/**
 * Fires a missile from Tank (head21) or Plane (nose) in the player's view direction
 */
export function shootMissile(vehicle, player) {
    if (!vehicle || !vehicle.isValid) return;

    const currentTick = system.currentTick;
    const lastShootTick = vehicleCooldowns.get(vehicle.id) || 0;
    if (currentTick - lastShootTick < 6) return; // 0.3s cooldown
    vehicleCooldowns.set(vehicle.id, currentTick);

    try {
        const dimension = vehicle.dimension;
        const viewDir = player ? player.getViewDirection() : vehicle.getViewDirection();
        const loc = vehicle.location;
        const vehicleRot = vehicle.getRotation();
        const yawRad = (-vehicleRot.y) * (Math.PI / 180);
        const fx = Math.sin(yawRad);
        const fz = Math.cos(yawRad);

        let spawnPos;
        if (vehicle.typeId === "renderphoenix:tank") {
            // Muzzle position at head21 bone: Y + 3.88 blocks, 4.15 blocks in front
            spawnPos = {
                x: loc.x + fx * 4.15,
                y: loc.y + 3.88,
                z: loc.z + fz * 4.15
            };
        } else if (vehicle.typeId === "renderphoenix:plane") {
            // Nose position of Daladas airliner: Y + 2.0 blocks, 8.2 blocks forward
            spawnPos = {
                x: loc.x + fx * 8.2,
                y: loc.y + 2.0,
                z: loc.z + fz * 8.2
            };
        } else {
            spawnPos = {
                x: loc.x + fx * 3.5,
                y: loc.y + 1.8,
                z: loc.z + fz * 3.5
            };
        }

        // Spawn missile entity
        const missile = dimension.spawnEntity("renderphoenix:missile", spawnPos);

        // Native Bedrock projectile component shoot API:
        // shoot(velocity: Vector3, options?: { uncertainty?: number })
        // High rocket velocity: 4.8 blocks/tick
        const speed = 4.8;
        const velocity = {
            x: viewDir.x * speed,
            y: viewDir.y * speed,
            z: viewDir.z * speed
        };

        const projectileComp = missile.getComponent("minecraft:projectile");
        if (projectileComp) {
            projectileComp.shoot(velocity, { uncertainty: 0 });
        }

        // Sounds and muzzle smoke puff
        dimension.playSound("random.bow", spawnPos, { volume: 1.5, pitch: 0.5 });
        dimension.playSound("random.explode", spawnPos, { volume: 1.2, pitch: 1.8 });
        dimension.spawnParticle("minecraft:basic_smoke_particle", spawnPos);
        dimension.spawnParticle("minecraft:huge_explosion_emitter", spawnPos);

        // Track for dense smoke trail
        activeMissiles.set(missile.id, {
            entity: missile,
            ticksLived: 0
        });

    } catch (err) {
        // Silently handle edge cases
    }
}

/**
 * Updates smoke trails behind all active missiles
 */
export function tickMissiles() {
    for (const [id, data] of activeMissiles.entries()) {
        const { entity } = data;
        if (!entity || !entity.isValid) {
            activeMissiles.delete(id);
            continue;
        }

        data.ticksLived++;
        if (data.ticksLived > 140) { // Max 7 seconds flight time
            try {
                entity.triggerEvent("renderphoenix:explode");
            } catch (e) {}
            activeMissiles.delete(id);
            continue;
        }

        try {
            const loc = entity.location;
            const dim = entity.dimension;
            // Dense smoke trail behind missile
            dim.spawnParticle("minecraft:basic_smoke_particle", loc);
            dim.spawnParticle("minecraft:campfire_smoke_particle", loc);
        } catch (e) {
            activeMissiles.delete(id);
        }
    }
}

// Guaranteed impact explosion handlers
world.afterEvents.projectileHitBlock.subscribe((event) => {
    if (event.projectile?.typeId === "renderphoenix:missile") {
        try {
            event.projectile.triggerEvent("renderphoenix:explode");
        } catch (e) {}
    }
});

world.afterEvents.projectileHitEntity.subscribe((event) => {
    if (event.projectile?.typeId === "renderphoenix:missile") {
        try {
            event.projectile.triggerEvent("renderphoenix:explode");
        } catch (e) {}
    }
});
