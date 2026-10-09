package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.VillagerMissileJavaModel;
import com.villagernews.entity.VillagerMissileEntity;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class VillagerMissileRenderer extends EntityRenderer<VillagerMissileEntity, VillagerMissileRenderer.MissileRenderState> {

    public static class MissileRenderState extends EntityRenderState {
        public float yRot;
        public float xRot;
    }

    private final VillagerMissileJavaModel<MissileRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("renderphoenix", "textures/entity/villager_helicopter/farmer.png");

    public VillagerMissileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new VillagerMissileJavaModel<>(VillagerMissileJavaModel.createBodyLayer().bakeRoot());
        this.shadowRadius = 0.3f;
    }

    @Override
    public MissileRenderState createRenderState() {
        return new MissileRenderState();
    }

    @Override
    public void extractRenderState(VillagerMissileEntity entity, MissileRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getViewYRot(partialTick);
        state.xRot = entity.getViewXRot(partialTick);
    }

    @Override
    public void submit(MissileRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
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
