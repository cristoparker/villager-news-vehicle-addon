package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.VillagerHelicopterJavaModel;
import com.villagernews.entity.VillagerHelicopterEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class VillagerHelicopterRenderer extends EntityRenderer<VillagerHelicopterEntity, VillagerHelicopterRenderer.HelicopterRenderState> {

    public static class HelicopterRenderState extends EntityRenderState {
        public float yRot;
        public float xRot;
        public float propellerAngle;
    }

    private final VillagerHelicopterJavaModel<HelicopterRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/villager_helicopter/farmer.png");

    public VillagerHelicopterRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new VillagerHelicopterJavaModel<>(VillagerHelicopterJavaModel.createBodyLayer().bakeRoot());
        this.shadowRadius = 2.0f;
    }

    @Override
    public HelicopterRenderState createRenderState() {
        return new HelicopterRenderState();
    }

    @Override
    public void extractRenderState(VillagerHelicopterEntity entity, HelicopterRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getViewYRot(partialTick);
        state.xRot = entity.getViewXRot(partialTick);
        state.propellerAngle = (entity.tickCount + partialTick) * 45.0f;
    }

    @Override
    public void submit(HelicopterRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        ModelPart mainProp = this.model.getPart("main_propeller");
        if (mainProp != null) {
            mainProp.yRot = (float) Math.toRadians(state.propellerAngle);
        }
        ModelPart backProp = this.model.getPart("back_propeller");
        if (backProp != null) {
            backProp.xRot = (float) Math.toRadians(state.propellerAngle);
        }

        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.rotateDegrees(Axis.XP, state.xRot);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(0.0, -1.5, 0.0);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
