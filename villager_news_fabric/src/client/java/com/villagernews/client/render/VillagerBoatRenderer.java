package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.render.geo.BedrockEntityModel;
import com.villagernews.client.render.geo.BedrockModelLoader;
import com.villagernews.entity.VillagerBoatEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class VillagerBoatRenderer extends EntityRenderer<VillagerBoatEntity, VillagerBoatRenderer.BoatRenderState> {

    public static class BoatRenderState extends EntityRenderState {
        public float yRot;
    }

    private final BedrockEntityModel<BoatRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/villager_helicopter/farmer.png");

    public VillagerBoatRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BedrockEntityModel<>(BedrockModelLoader.load("/assets/villagernews/geo/villager_boat.geo.json"));
        this.shadowRadius = 1.0f;
    }

    @Override
    public BoatRenderState createRenderState() {
        return new BoatRenderState();
    }

    @Override
    public void extractRenderState(VillagerBoatEntity entity, BoatRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getViewYRot(partialTick);
    }

    @Override
    public void submit(BoatRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.scale(-1.0f, 1.0f, -1.0f);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
