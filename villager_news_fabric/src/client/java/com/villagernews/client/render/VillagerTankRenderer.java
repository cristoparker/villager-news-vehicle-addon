package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.VillagerTankJavaModel;
import com.villagernews.entity.VillagerTankEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class VillagerTankRenderer extends EntityRenderer<VillagerTankEntity, VillagerTankRenderer.TankRenderState> {

    public static class TankRenderState extends EntityRenderState {
        public float yRot;
        public float turretYaw;
        public float turretPitch;
    }

    private final VillagerTankJavaModel<TankRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/villager_helicopter/farmer.png");

    public VillagerTankRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new VillagerTankJavaModel<>(VillagerTankJavaModel.createBodyLayer().bakeRoot());
        this.shadowRadius = 1.8f;
    }

    @Override
    public TankRenderState createRenderState() {
        return new TankRenderState();
    }

    @Override
    public void extractRenderState(VillagerTankEntity entity, TankRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot = entity.getViewYRot(partialTick);
        state.turretYaw = entity.getTurretYaw();
        state.turretPitch = entity.getTurretPitch();
    }

    @Override
    public void submit(TankRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        ModelPart turret = this.model.getPart("tank_head");
        if (turret != null) {
            float relTurretYaw = Mth.wrapDegrees(state.turretYaw - state.yRot);
            turret.yRot = (float) Math.toRadians(-relTurretYaw);
        }

        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(0.0, -1.5, 0.0);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
