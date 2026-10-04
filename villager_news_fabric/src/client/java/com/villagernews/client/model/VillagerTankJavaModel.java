package com.villagernews.client.model;

import com.villagernews.client.render.geo.BedrockEntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

public class VillagerTankJavaModel<S extends EntityRenderState> extends BedrockEntityModel<S> {

    public VillagerTankJavaModel(ModelPart root) {
        super(root);
    }

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition platform = partdefinition.addOrReplaceChild("platform", CubeListBuilder.create(), PartPose.offset(32.0F, -6.0F, 35.0F));

		PartDefinition bone3 = platform.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition villager11 = bone3.addOrReplaceChild("villager11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body11 = villager11.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head11 = body11.addOrReplaceChild("head11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose11 = head11.addOrReplaceChild("nose11", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms11 = body11.addOrReplaceChild("arms11", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg20 = body11.addOrReplaceChild("leg20", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg21 = body11.addOrReplaceChild("leg21", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager12 = bone3.addOrReplaceChild("villager12", CubeListBuilder.create(), PartPose.offsetAndRotation(-64.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body12 = villager12.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head12 = body12.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose12 = head12.addOrReplaceChild("nose12", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms12 = body12.addOrReplaceChild("arms12", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg22 = body12.addOrReplaceChild("leg22", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg23 = body12.addOrReplaceChild("leg23", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager13 = bone3.addOrReplaceChild("villager13", CubeListBuilder.create(), PartPose.offsetAndRotation(-48.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body13 = villager13.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head13 = body13.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose13 = head13.addOrReplaceChild("nose13", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms13 = body13.addOrReplaceChild("arms13", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg24 = body13.addOrReplaceChild("leg24", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg25 = body13.addOrReplaceChild("leg25", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager14 = bone3.addOrReplaceChild("villager14", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body14 = villager14.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head14 = body14.addOrReplaceChild("head14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose14 = head14.addOrReplaceChild("nose14", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms14 = body14.addOrReplaceChild("arms14", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg26 = body14.addOrReplaceChild("leg26", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg27 = body14.addOrReplaceChild("leg27", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager15 = bone3.addOrReplaceChild("villager15", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body15 = villager15.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head15 = body15.addOrReplaceChild("head15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose15 = head15.addOrReplaceChild("nose15", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms15 = body15.addOrReplaceChild("arms15", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg28 = body15.addOrReplaceChild("leg28", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg29 = body15.addOrReplaceChild("leg29", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition bone = platform.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-32.0F, 11.0F, -27.0F));

		PartDefinition villager = bone.addOrReplaceChild("villager", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.6107F, -13.9867F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body = villager.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg0 = body.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager2 = bone.addOrReplaceChild("villager2", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -0.2181F, -4.9952F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body2 = villager2.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head2 = body2.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose2 = head2.addOrReplaceChild("nose2", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms2 = body2.addOrReplaceChild("arms2", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg2 = body2.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg3 = body2.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager3 = bone.addOrReplaceChild("villager3", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, -0.2181F, -4.9952F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body3 = villager3.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head3 = body3.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose3 = head3.addOrReplaceChild("nose3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms3 = body3.addOrReplaceChild("arms3", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg4 = body3.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg5 = body3.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager4 = bone.addOrReplaceChild("villager4", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body4 = villager4.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head4 = body4.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose4 = head4.addOrReplaceChild("nose4", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms4 = body4.addOrReplaceChild("arms4", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg6 = body4.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg7 = body4.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager5 = bone.addOrReplaceChild("villager5", CubeListBuilder.create(), PartPose.offsetAndRotation(32.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body5 = villager5.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head5 = body5.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose5 = head5.addOrReplaceChild("nose5", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms5 = body5.addOrReplaceChild("arms5", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg8 = body5.addOrReplaceChild("leg8", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg9 = body5.addOrReplaceChild("leg9", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition bone4 = platform.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 7.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition villager16 = bone4.addOrReplaceChild("villager16", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.4798F, 10.9895F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body16 = villager16.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head16 = body16.addOrReplaceChild("head16", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose16 = head16.addOrReplaceChild("nose16", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms16 = body16.addOrReplaceChild("arms16", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg30 = body16.addOrReplaceChild("leg30", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg31 = body16.addOrReplaceChild("leg31", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager17 = bone4.addOrReplaceChild("villager17", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 0.2181F, 4.9952F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body17 = villager17.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head17 = body17.addOrReplaceChild("head17", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose17 = head17.addOrReplaceChild("nose17", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms17 = body17.addOrReplaceChild("arms17", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg32 = body17.addOrReplaceChild("leg32", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg33 = body17.addOrReplaceChild("leg33", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager18 = bone4.addOrReplaceChild("villager18", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.2181F, 4.9952F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body18 = villager18.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head18 = body18.addOrReplaceChild("head18", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose18 = head18.addOrReplaceChild("nose18", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms18 = body18.addOrReplaceChild("arms18", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg34 = body18.addOrReplaceChild("leg34", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg35 = body18.addOrReplaceChild("leg35", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager19 = bone4.addOrReplaceChild("villager19", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body19 = villager19.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head19 = body19.addOrReplaceChild("head19", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose19 = head19.addOrReplaceChild("nose19", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms19 = body19.addOrReplaceChild("arms19", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg36 = body19.addOrReplaceChild("leg36", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg37 = body19.addOrReplaceChild("leg37", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager20 = bone4.addOrReplaceChild("villager20", CubeListBuilder.create(), PartPose.offsetAndRotation(32.0F, 0.0F, 0.0F, 1.5272F, 0.0F, 0.0F));

		PartDefinition body20 = villager20.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head20 = body20.addOrReplaceChild("head20", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose20 = head20.addOrReplaceChild("nose20", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms20 = body20.addOrReplaceChild("arms20", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg38 = body20.addOrReplaceChild("leg38", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg39 = body20.addOrReplaceChild("leg39", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition bone2 = platform.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -28.0F));

		PartDefinition villager6 = bone2.addOrReplaceChild("villager6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body6 = villager6.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head6 = body6.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose6 = head6.addOrReplaceChild("nose6", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms6 = body6.addOrReplaceChild("arms6", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg10 = body6.addOrReplaceChild("leg10", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg11 = body6.addOrReplaceChild("leg11", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager7 = bone2.addOrReplaceChild("villager7", CubeListBuilder.create(), PartPose.offsetAndRotation(-64.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body7 = villager7.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head7 = body7.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose7 = head7.addOrReplaceChild("nose7", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms7 = body7.addOrReplaceChild("arms7", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg12 = body7.addOrReplaceChild("leg12", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg13 = body7.addOrReplaceChild("leg13", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager8 = bone2.addOrReplaceChild("villager8", CubeListBuilder.create(), PartPose.offsetAndRotation(-48.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body8 = villager8.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head8 = body8.addOrReplaceChild("head8", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose8 = head8.addOrReplaceChild("nose8", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms8 = body8.addOrReplaceChild("arms8", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg14 = body8.addOrReplaceChild("leg14", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg15 = body8.addOrReplaceChild("leg15", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager9 = bone2.addOrReplaceChild("villager9", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body9 = villager9.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head9 = body9.addOrReplaceChild("head9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose9 = head9.addOrReplaceChild("nose9", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms9 = body9.addOrReplaceChild("arms9", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg16 = body9.addOrReplaceChild("leg16", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg17 = body9.addOrReplaceChild("leg17", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager10 = bone2.addOrReplaceChild("villager10", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 1.789F, 0.0F, 0.0F));

		PartDefinition body10 = villager10.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head10 = body10.addOrReplaceChild("head10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.789F, 0.0F, 0.0F));

		PartDefinition nose10 = head10.addOrReplaceChild("nose10", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms10 = body10.addOrReplaceChild("arms10", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg18 = body10.addOrReplaceChild("leg18", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg19 = body10.addOrReplaceChild("leg19", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition track_r = platform.addOrReplaceChild("track_r", CubeListBuilder.create(), PartPose.offset(2.0F, 20.0F, -35.0F));

		PartDefinition wheel_r1 = track_r.addOrReplaceChild("wheel_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 20).mirror().addBox(-6.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, -26.0F));

		PartDefinition wheel_r2 = track_r.addOrReplaceChild("wheel_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 20).mirror().addBox(-6.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, -9.0F));

		PartDefinition wheel_r3 = track_r.addOrReplaceChild("wheel_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 20).mirror().addBox(-6.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 9.0F));

		PartDefinition wheel_r4 = track_r.addOrReplaceChild("wheel_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(16, 20).mirror().addBox(-6.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 26.0F));

		PartDefinition tread_r_bot1 = track_r.addOrReplaceChild("tread_r_bot1", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, -26.0F));

		PartDefinition tread_r_bot2 = track_r.addOrReplaceChild("tread_r_bot2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, -13.0F));

		PartDefinition tread_r_bot3 = track_r.addOrReplaceChild("tread_r_bot3", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition tread_r_bot4 = track_r.addOrReplaceChild("tread_r_bot4", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 13.0F));

		PartDefinition tread_r_bot5 = track_r.addOrReplaceChild("tread_r_bot5", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 26.0F));

		PartDefinition tread_r_top1 = track_r.addOrReplaceChild("tread_r_top1", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, -26.0F));

		PartDefinition tread_r_top2 = track_r.addOrReplaceChild("tread_r_top2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, -13.0F));

		PartDefinition tread_r_top3 = track_r.addOrReplaceChild("tread_r_top3", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition tread_r_top4 = track_r.addOrReplaceChild("tread_r_top4", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, 13.0F));

		PartDefinition tread_r_top5 = track_r.addOrReplaceChild("tread_r_top5", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, 26.0F));

		PartDefinition tread_r_f1 = track_r.addOrReplaceChild("tread_r_f1", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, -34.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tread_r_f2 = track_r.addOrReplaceChild("tread_r_f2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -4.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -3.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -42.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition tread_r_f3 = track_r.addOrReplaceChild("tread_r_f3", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.0F, -34.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition wheel_r_front = track_r.addOrReplaceChild("wheel_r_front", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -40.0F));

		PartDefinition tread_r_b1 = track_r.addOrReplaceChild("tread_r_b1", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.0F, 34.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tread_r_b2 = track_r.addOrReplaceChild("tread_r_b2", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -5.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 42.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition tread_r_b3 = track_r.addOrReplaceChild("tread_r_b3", CubeListBuilder.create().texOffs(0, 38).mirror().addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, 34.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition wheel_r_back = track_r.addOrReplaceChild("wheel_r_back", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 0).mirror().addBox(4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 40.0F));

		PartDefinition tread_r_strut1 = track_r.addOrReplaceChild("tread_r_strut1", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition tread_r_strut2 = track_r.addOrReplaceChild("tread_r_strut2", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition track_l = platform.addOrReplaceChild("track_l", CubeListBuilder.create(), PartPose.offset(-66.0F, 20.0F, -35.0F));

		PartDefinition wheel_l1 = track_l.addOrReplaceChild("wheel_l1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-6.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(4.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -26.0F));

		PartDefinition wheel_l2 = track_l.addOrReplaceChild("wheel_l2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-6.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(4.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -9.0F));

		PartDefinition wheel_l3 = track_l.addOrReplaceChild("wheel_l3", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-6.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(4.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 9.0F));

		PartDefinition wheel_l4 = track_l.addOrReplaceChild("wheel_l4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-6.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 20).addBox(4.0F, -4.0F, -3.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 26.0F));

		PartDefinition tread_l_bot1 = track_l.addOrReplaceChild("tread_l_bot1", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -26.0F));

		PartDefinition tread_l_bot2 = track_l.addOrReplaceChild("tread_l_bot2", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -13.0F));

		PartDefinition tread_l_bot3 = track_l.addOrReplaceChild("tread_l_bot3", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition tread_l_bot4 = track_l.addOrReplaceChild("tread_l_bot4", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 13.0F));

		PartDefinition tread_l_bot5 = track_l.addOrReplaceChild("tread_l_bot5", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 26.0F));

		PartDefinition tread_l_top1 = track_l.addOrReplaceChild("tread_l_top1", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -26.0F));

		PartDefinition tread_l_top2 = track_l.addOrReplaceChild("tread_l_top2", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -13.0F));

		PartDefinition tread_l_top3 = track_l.addOrReplaceChild("tread_l_top3", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition tread_l_top4 = track_l.addOrReplaceChild("tread_l_top4", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 13.0F));

		PartDefinition tread_l_top5 = track_l.addOrReplaceChild("tread_l_top5", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 26.0F));

		PartDefinition tread_l_f1 = track_l.addOrReplaceChild("tread_l_f1", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -34.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tread_l_f2 = track_l.addOrReplaceChild("tread_l_f2", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -4.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -42.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition tread_l_f3 = track_l.addOrReplaceChild("tread_l_f3", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -34.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition wheel_l_front = track_l.addOrReplaceChild("wheel_l_front", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -40.0F));

		PartDefinition tread_l_b1 = track_l.addOrReplaceChild("tread_l_b1", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 34.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tread_l_b2 = track_l.addOrReplaceChild("tread_l_b2", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -5.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 42.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition tread_l_b3 = track_l.addOrReplaceChild("tread_l_b3", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 34.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition wheel_l_back = track_l.addOrReplaceChild("wheel_l_back", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-4.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 40.0F));

		PartDefinition tread_l_strut1 = track_l.addOrReplaceChild("tread_l_strut1", CubeListBuilder.create().texOffs(16, 20).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition tread_l_strut2 = track_l.addOrReplaceChild("tread_l_strut2", CubeListBuilder.create().texOffs(16, 20).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition tank_head = partdefinition.addOrReplaceChild("tank_head", CubeListBuilder.create(), PartPose.offset(0.0F, -29.0962F, 5.7885F));

		PartDefinition villager21 = tank_head.addOrReplaceChild("villager21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.8977F, -47.439F, 1.3963F, 0.0F, 0.0F));

		PartDefinition body21 = villager21.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head21 = body21.addOrReplaceChild("head21", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4399F, 0.0F, 0.0F));

		PartDefinition nose21 = head21.addOrReplaceChild("nose21", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms21 = body21.addOrReplaceChild("arms21", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg40 = body21.addOrReplaceChild("leg40", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg41 = body21.addOrReplaceChild("leg41", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager22 = tank_head.addOrReplaceChild("villager22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.5929F, -13.8319F, 1.3963F, 0.0F, 0.0F));

		PartDefinition body22 = villager22.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head22 = body22.addOrReplaceChild("head22", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose22 = head22.addOrReplaceChild("nose22", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms22 = body22.addOrReplaceChild("arms22", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg42 = body22.addOrReplaceChild("leg42", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg43 = body22.addOrReplaceChild("leg43", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager23 = tank_head.addOrReplaceChild("villager23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.1016F, 20.4237F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body23 = villager23.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head23 = body23.addOrReplaceChild("head23", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose23 = head23.addOrReplaceChild("nose23", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms23 = body23.addOrReplaceChild("arms23", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg44 = body23.addOrReplaceChild("leg44", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg45 = body23.addOrReplaceChild("leg45", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager24 = tank_head.addOrReplaceChild("villager24", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 1.1016F, 20.4237F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body24 = villager24.addOrReplaceChild("body24", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head24 = body24.addOrReplaceChild("head24", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose24 = head24.addOrReplaceChild("nose24", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms24 = body24.addOrReplaceChild("arms24", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg46 = body24.addOrReplaceChild("leg46", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg47 = body24.addOrReplaceChild("leg47", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager25 = tank_head.addOrReplaceChild("villager25", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 1.1016F, 20.4237F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body25 = villager25.addOrReplaceChild("body25", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head25 = body25.addOrReplaceChild("head25", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose25 = head25.addOrReplaceChild("nose25", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms25 = body25.addOrReplaceChild("arms25", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition leg48 = body25.addOrReplaceChild("leg48", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg49 = body25.addOrReplaceChild("leg49", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}