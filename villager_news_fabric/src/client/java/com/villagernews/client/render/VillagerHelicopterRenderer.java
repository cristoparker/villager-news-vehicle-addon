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
import net.minecraft.util.Mth;

public class VillagerHelicopterRenderer extends EntityRenderer<VillagerHelicopterEntity, VillagerHelicopterRenderer.HelicopterRenderState> {

    public static class HelicopterRenderState extends EntityRenderState {
        public float yRot;
        public float xRot;
        public float pitchTilt;
        public float rollTilt;
        /** Accumulated main rotor angle in degrees. */
        public float mainPropAngle;
        /** Accumulated tail rotor angle in degrees. */
        public float tailPropAngle;
        /** 0.0 = idle speed, 1.0 = full flight speed. */
        public float rotorSpeedFactor;
    }

    // Bedrock Edition-calibrated speeds (degrees per tick)
    /** Idle spin when engines are warm but helicopter is on the ground. */
    private static final float IDLE_MAIN_SPEED   =  8.0f;
    private static final float IDLE_TAIL_SPEED   = 24.0f;
    /** Full spin during flight – Bedrock uses ~720 deg/s = 36 deg/tick. */
    private static final float FLIGHT_MAIN_SPEED  = 36.0f;
    private static final float FLIGHT_TAIL_SPEED  = 90.0f;

    private final VillagerHelicopterJavaModel<HelicopterRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("renderphoenix", "textures/entity/villager_helicopter/farmer.png");

    private float accMainAngle  = 0.0f;
    private float accTailAngle  = 0.0f;
    private float currentSpeedFactor = 0.0f;

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
        state.yRot      = entity.getViewYRot(partialTick);
        state.xRot      = entity.getViewXRot(partialTick);
        state.pitchTilt = entity.getPitchTilt();
        state.rollTilt  = entity.getRollTilt();

        // Smooth speed factor: 0 = idle, 1 = full flight (Bedrock-style spool up/down)
        float targetFactor = entity.isFlying() ? 1.0f : 0.0f;
        currentSpeedFactor = Mth.lerp(0.04f, currentSpeedFactor, targetFactor);

        float mainSpeed = Mth.lerp(currentSpeedFactor, IDLE_MAIN_SPEED, FLIGHT_MAIN_SPEED);
        float tailSpeed = Mth.lerp(currentSpeedFactor, IDLE_TAIL_SPEED, FLIGHT_TAIL_SPEED);

        accMainAngle += mainSpeed;
        accTailAngle += tailSpeed;

        state.mainPropAngle    = accMainAngle;
        state.tailPropAngle    = accTailAngle;
        state.rotorSpeedFactor = currentSpeedFactor;
    }

    @Override
    public void submit(HelicopterRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        // Main rotor – spins around Y axis (horizontal blades)
        ModelPart mainProp = this.model.getPart("main_propeller");
        if (mainProp != null) {
            mainProp.yRot = (float) Math.toRadians(state.mainPropAngle);
        }

        // Tail rotor – spins around X axis (vertical side blades)
        ModelPart backProp = this.model.getPart("back_propeller");
        if (backProp != null) {
            backProp.xRot = (float) Math.toRadians(state.tailPropAngle);
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
