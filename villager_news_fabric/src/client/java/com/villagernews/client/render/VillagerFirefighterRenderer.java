package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.VillagerFirefighterJavaModel;
import com.villagernews.entity.VillagerFirefighterEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class VillagerFirefighterRenderer extends EntityRenderer<VillagerFirefighterEntity, VillagerFirefighterRenderer.FirefighterRenderState> {

    public static class FirefighterRenderState extends EntityRenderState {
        public float yRot;
    }

    private final VillagerFirefighterJavaModel<FirefighterRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/villager_helicopter/farmer.png");

    public VillagerFirefighterRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new VillagerFirefighterJavaModel<>(VillagerFirefighterJavaModel.createBodyLayer().bakeRoot());
        this.shadowRadius = 1.6f;
    }

    @Override
    public FirefighterRenderState createRenderState() {
        return new FirefighterRenderState();
    }

    @Override
    public void extractRenderState(VillagerFirefighterEntity entity, FirefighterRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getViewYRot(partialTick);
    }

    @Override
    public void submit(FirefighterRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(0.0, -1.5, 0.0);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
