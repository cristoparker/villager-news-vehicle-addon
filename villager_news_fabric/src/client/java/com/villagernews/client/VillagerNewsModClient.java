package com.villagernews.client;

import com.mojang.blaze3d.platform.InputConstants;
import com.villagernews.client.render.*;
import com.villagernews.entity.DaladasPlaneEntity;
import com.villagernews.entity.VillagerFirefighterEntity;
import com.villagernews.entity.VillagerTankEntity;
import com.villagernews.init.ModEntities;
import com.villagernews.network.VehicleActionPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.entity.Entity;

public class VillagerNewsModClient implements ClientModInitializer {

    private static KeyMapping keySpecialAction;
    private static KeyMapping keyFireWeapon;

    @Override
    public void onInitializeClient() {
        // Register Entity Renderers
        EntityRendererRegistry.register(ModEntities.DALADAS, DaladasPlaneRenderer::new);
        EntityRendererRegistry.register(ModEntities.HELICOPTER, VillagerHelicopterRenderer::new);
        EntityRendererRegistry.register(ModEntities.TANK, VillagerTankRenderer::new);
        EntityRendererRegistry.register(ModEntities.BOAT, VillagerBoatRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIREFIGHTER, VillagerFirefighterRenderer::new);
        EntityRendererRegistry.register(ModEntities.MISSILE, VillagerMissileRenderer::new);

        // Register Key Mappings
        keySpecialAction = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.renderphoenix.special_action",
                InputConstants.Type.KEYBOARD,
                InputConstants.KEY_R,
                KeyMapping.Category.GAMEPLAY
        ));

        keyFireWeapon = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.renderphoenix.fire_weapon",
                InputConstants.Type.KEYBOARD,
                InputConstants.KEY_V,
                KeyMapping.Category.GAMEPLAY
        ));

        // Client tick event for keyboard input when riding vehicles
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            Entity vehicle = client.player.getVehicle();
            if (vehicle == null) return;

            if (vehicle instanceof com.villagernews.entity.VehicleBaseEntity) {
                boolean forward = client.options.keyUp.isDown();
                boolean backward = client.options.keyDown.isDown();
                boolean left = client.options.keyLeft.isDown();
                boolean right = client.options.keyRight.isDown();
                boolean jump = client.options.keyJump.isDown();
                boolean shift = client.options.keyShift.isDown();
                boolean sprint = client.options.keySprint.isDown();
                float yaw = client.player.getYRot();
                float pitch = client.player.getXRot();

                ClientPlayNetworking.send(new com.villagernews.network.VehicleInputPayload(
                        forward, backward, left, right, jump, shift, sprint, yaw, pitch
                ));
            }

            while (keySpecialAction.consumeClick()) {
                if (vehicle instanceof DaladasPlaneEntity) {
                    ClientPlayNetworking.send(new VehicleActionPayload(VehicleActionPayload.ACTION_BARREL_ROLL, 1));
                } else if (vehicle instanceof VillagerFirefighterEntity) {
                    ClientPlayNetworking.send(new VehicleActionPayload(VehicleActionPayload.ACTION_SPRAY_WATER, 0));
                }
            }

            while (keyFireWeapon.consumeClick()) {
                if (vehicle instanceof DaladasPlaneEntity || vehicle instanceof VillagerTankEntity) {
                    ClientPlayNetworking.send(new VehicleActionPayload(VehicleActionPayload.ACTION_SHOOT_MISSILE, 0));
                }
            }
        });
    }
}
