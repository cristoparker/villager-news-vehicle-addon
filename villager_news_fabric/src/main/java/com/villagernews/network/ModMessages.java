package com.villagernews.network;

import com.villagernews.entity.DaladasPlaneEntity;
import com.villagernews.entity.VillagerFirefighterEntity;
import com.villagernews.entity.VillagerTankEntity;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.entity.Entity;

public class ModMessages {

    public static void initialize() {
        PayloadTypeRegistry.serverboundPlay().register(VehicleActionPayload.TYPE, VehicleActionPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(VehicleActionPayload.TYPE, (payload, context) -> {
            context.server().execute(() -> {
                Entity vehicle = context.player().getVehicle();
                if (vehicle == null) return;

                switch (payload.action()) {
                    case VehicleActionPayload.ACTION_BARREL_ROLL -> {
                        if (vehicle instanceof DaladasPlaneEntity plane) {
                            plane.performBarrelRoll(payload.param());
                        }
                    }
                    case VehicleActionPayload.ACTION_SHOOT_MISSILE -> {
                        if (vehicle instanceof DaladasPlaneEntity plane) {
                            plane.shootMissile();
                        } else if (vehicle instanceof VillagerTankEntity tank) {
                            tank.shootCannon();
                        }
                    }
                    case VehicleActionPayload.ACTION_SPRAY_WATER -> {
                        if (vehicle instanceof VillagerFirefighterEntity firefighter) {
                            firefighter.sprayWater();
                        }
                    }
                }
            });
        });
    }
}
