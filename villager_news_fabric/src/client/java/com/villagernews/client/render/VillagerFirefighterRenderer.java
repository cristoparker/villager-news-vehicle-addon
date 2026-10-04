package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.VillagerFirefighterJavaModel;
import com.villagernews.entity.VillagerFirefighterEntity;
import net.minecraft.client.model.geom.ModelPart;
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
        /** Accumulated wheel rotation angle in degrees (driven by drive speed). */
        public float wheelAngle;
    }

    private final VillagerFirefighterJavaModel<FirefighterRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/villager_helicopter/farmer.png");

    /** Tracks accumulated wheel spin across frames. */
    private float accumulatedWheelAngle = 0.0f;

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

        // Accumulate wheel rotation: each unit of drive speed turns the wheels.
        // 360 degrees per ~2 blocks of travel (wheel circumference ≈ 2π * 0.5 = π blocks).
        float driveSpeed = entity.getDriveSpeed();
        // ~360 deg per block → multiply by frames-per-block factor
        accumulatedWheelAngle += driveSpeed * (360.0f / (float)(2.0f * Math.PI * 0.625f));
        state.wheelAngle = accumulatedWheelAngle;
    }

    @Override
    public void submit(FirefighterRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        // Animate all four wheels: spin around their Z axis (rolling forward = negative Z-rotation)
        applyWheelRotation("wheel1", state.wheelAngle);
        applyWheelRotation("wheel2", state.wheelAngle);
        applyWheelRotation("wheel3", state.wheelAngle);
        applyWheelRotation("wheel4", state.wheelAngle);

        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(0.0, -1.5, 0.0);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }

    private void applyWheelRotation(String partName, float angleDeg) {
        ModelPart part = this.model.getPart(partName);
        if (part != null) {
            // Rotate around Z axis to simulate rolling. Model faces -Z (forward),
            // so positive speed → positive Z-rotation when driving forward.
            part.zRot = (float) Math.toRadians(angleDeg);
        }
    }
}
