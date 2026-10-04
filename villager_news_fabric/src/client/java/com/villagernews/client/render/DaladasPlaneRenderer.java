package com.villagernews.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagernews.client.model.DaladasPlaneJavaModel;
import com.villagernews.entity.DaladasPlaneEntity;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class DaladasPlaneRenderer extends EntityRenderer<DaladasPlaneEntity, DaladasPlaneRenderer.PlaneRenderState> {

    public static class PlaneRenderState extends EntityRenderState {
        public float yRot;
        public float xRot;
        public float roll;
        public int planeState;
        /** Current horizontal flight speed (blocks/tick). */
        public float flightSpeed;
    }

    private final DaladasPlaneJavaModel<PlaneRenderState> model;
    private final Identifier texture = Identifier.fromNamespaceAndPath("villagernews", "textures/entity/plane/librarian.png");

    public DaladasPlaneRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new DaladasPlaneJavaModel<>(DaladasPlaneJavaModel.createBodyLayer().bakeRoot());
        this.shadowRadius = 2.5f;
    }

    @Override
    public PlaneRenderState createRenderState() {
        return new PlaneRenderState();
    }

    @Override
    public void extractRenderState(DaladasPlaneEntity entity, PlaneRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.yRot       = entity.getViewYRot(partialTick);
        state.xRot       = entity.getViewXRot(partialTick);
        state.roll       = entity.getVisualRoll();
        state.planeState = entity.getPlaneState();
        state.flightSpeed = entity.getFlightSpeed();
    }

    @Override
    public void submit(PlaneRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        // Animate elevator control surface (pitch: nose up/down)
        // all_horizontal_steer rotates around X to deflect elevators
        ModelPart horizontalSteer = this.model.getPart("all_horizontal_steer");
        if (horizontalSteer != null) {
            float elevatorDeflection = Mth.clamp(-state.xRot * 0.3f, -25.0f, 25.0f);
            horizontalSteer.xRot = (float) Math.toRadians(elevatorDeflection);
        }

        // Animate rudder control surface (yaw: nose left/right)
        // all_vertical_steer rotates around Y for rudder
        ModelPart verticalSteer = this.model.getPart("all_vertical_steer");
        if (verticalSteer != null) {
            // Roll drives rudder slightly for coordinated turns
            float rudderDeflection = Mth.clamp(-state.roll * 0.15f, -20.0f, 20.0f);
            verticalSteer.yRot = (float) Math.toRadians(rudderDeflection);
        }

        poseStack.pushPose();
        poseStack.rotateDegrees(Axis.YP, 180.0f - state.yRot);
        poseStack.rotateDegrees(Axis.XP, state.xRot);
        poseStack.rotateDegrees(Axis.ZP, state.roll);
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.translate(0.0, -1.5, 0.0);

        collector.submitModel(this.model, state, poseStack, this.texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
