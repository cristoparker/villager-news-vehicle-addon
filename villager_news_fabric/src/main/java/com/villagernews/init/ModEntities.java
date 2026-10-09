package com.villagernews.init;

import com.villagernews.VillagerNewsMod;
import com.villagernews.entity.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.phys.Vec3;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> DALADAS_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "daladas"));
    public static final EntityType<DaladasPlaneEntity> DALADAS = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            DALADAS_KEY,
            EntityType.Builder.<DaladasPlaneEntity>of(DaladasPlaneEntity::new, MobCategory.MISC)
                    .sized(3.2f, 1.6f)
                    .passengerAttachments(new Vec3(0.0, 0.3, 5.0))
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(DALADAS_KEY)
    );

    public static final ResourceKey<EntityType<?>> HELICOPTER_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "helicopter"));
    public static final EntityType<VillagerHelicopterEntity> HELICOPTER = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            HELICOPTER_KEY,
            EntityType.Builder.<VillagerHelicopterEntity>of(VillagerHelicopterEntity::new, MobCategory.MISC)
                    .sized(3.2f, 3.8f)
                    .passengerAttachments(new Vec3(0.0, 0.5, -0.6))
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(HELICOPTER_KEY)
    );

    public static final ResourceKey<EntityType<?>> TANK_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "tank"));
    public static final EntityType<VillagerTankEntity> TANK = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            TANK_KEY,
            EntityType.Builder.<VillagerTankEntity>of(VillagerTankEntity::new, MobCategory.MISC)
                    .sized(3.6f, 2.6f)
                    .passengerAttachments(new Vec3(0.0, 3.7, 3.3))
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(TANK_KEY)
    );

    public static final ResourceKey<EntityType<?>> BOAT_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "boat"));
    public static final EntityType<VillagerBoatEntity> BOAT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            BOAT_KEY,
            EntityType.Builder.<VillagerBoatEntity>of(VillagerBoatEntity::new, MobCategory.MISC)
                    .sized(2.8f, 1.6f)
                    .passengerAttachments(
                            new Vec3(0.0, 0.5, 1.7),
                            new Vec3(0.0, 0.5, -0.5),
                            new Vec3(0.0, 0.5, -2.0),
                            new Vec3(0.0, 0.5, -3.0)
                    )
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(BOAT_KEY)
    );

    public static final ResourceKey<EntityType<?>> FIREFIGHTER_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "firefighter"));
    public static final EntityType<VillagerFirefighterEntity> FIREFIGHTER = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            FIREFIGHTER_KEY,
            EntityType.Builder.<VillagerFirefighterEntity>of(VillagerFirefighterEntity::new, MobCategory.MISC)
                    .sized(3.2f, 3.0f)
                    .passengerAttachments(new Vec3(0.0, 4.1, 4.5))
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(FIREFIGHTER_KEY)
    );

    public static final ResourceKey<EntityType<?>> MISSILE_KEY =
            ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(VillagerNewsMod.MOD_ID, "missile"));
    public static final EntityType<VillagerMissileEntity> MISSILE = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            MISSILE_KEY,
            EntityType.Builder.<VillagerMissileEntity>of(VillagerMissileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(16)
                    .updateInterval(1)
                    .build(MISSILE_KEY)
    );

    public static void initialize() {
        // Called to trigger classloading & registry
    }
}
