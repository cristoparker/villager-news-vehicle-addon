// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class renderphoenix.tank<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "renderphoenix.tank"), "main");
	private final ModelPart platform;
	private final ModelPart bone3;
	private final ModelPart villager11;
	private final ModelPart body11;
	private final ModelPart head11;
	private final ModelPart nose11;
	private final ModelPart arms11;
	private final ModelPart leg20;
	private final ModelPart leg21;
	private final ModelPart villager12;
	private final ModelPart body12;
	private final ModelPart head12;
	private final ModelPart nose12;
	private final ModelPart arms12;
	private final ModelPart leg22;
	private final ModelPart leg23;
	private final ModelPart villager13;
	private final ModelPart body13;
	private final ModelPart head13;
	private final ModelPart nose13;
	private final ModelPart arms13;
	private final ModelPart leg24;
	private final ModelPart leg25;
	private final ModelPart villager14;
	private final ModelPart body14;
	private final ModelPart head14;
	private final ModelPart nose14;
	private final ModelPart arms14;
	private final ModelPart leg26;
	private final ModelPart leg27;
	private final ModelPart villager15;
	private final ModelPart body15;
	private final ModelPart head15;
	private final ModelPart nose15;
	private final ModelPart arms15;
	private final ModelPart leg28;
	private final ModelPart leg29;
	private final ModelPart bone;
	private final ModelPart villager;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart arms;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart villager2;
	private final ModelPart body2;
	private final ModelPart head2;
	private final ModelPart nose2;
	private final ModelPart arms2;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart villager3;
	private final ModelPart body3;
	private final ModelPart head3;
	private final ModelPart nose3;
	private final ModelPart arms3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart villager4;
	private final ModelPart body4;
	private final ModelPart head4;
	private final ModelPart nose4;
	private final ModelPart arms4;
	private final ModelPart leg6;
	private final ModelPart leg7;
	private final ModelPart villager5;
	private final ModelPart body5;
	private final ModelPart head5;
	private final ModelPart nose5;
	private final ModelPart arms5;
	private final ModelPart leg8;
	private final ModelPart leg9;
	private final ModelPart bone4;
	private final ModelPart villager16;
	private final ModelPart body16;
	private final ModelPart head16;
	private final ModelPart nose16;
	private final ModelPart arms16;
	private final ModelPart leg30;
	private final ModelPart leg31;
	private final ModelPart villager17;
	private final ModelPart body17;
	private final ModelPart head17;
	private final ModelPart nose17;
	private final ModelPart arms17;
	private final ModelPart leg32;
	private final ModelPart leg33;
	private final ModelPart villager18;
	private final ModelPart body18;
	private final ModelPart head18;
	private final ModelPart nose18;
	private final ModelPart arms18;
	private final ModelPart leg34;
	private final ModelPart leg35;
	private final ModelPart villager19;
	private final ModelPart body19;
	private final ModelPart head19;
	private final ModelPart nose19;
	private final ModelPart arms19;
	private final ModelPart leg36;
	private final ModelPart leg37;
	private final ModelPart villager20;
	private final ModelPart body20;
	private final ModelPart head20;
	private final ModelPart nose20;
	private final ModelPart arms20;
	private final ModelPart leg38;
	private final ModelPart leg39;
	private final ModelPart bone2;
	private final ModelPart villager6;
	private final ModelPart body6;
	private final ModelPart head6;
	private final ModelPart nose6;
	private final ModelPart arms6;
	private final ModelPart leg10;
	private final ModelPart leg11;
	private final ModelPart villager7;
	private final ModelPart body7;
	private final ModelPart head7;
	private final ModelPart nose7;
	private final ModelPart arms7;
	private final ModelPart leg12;
	private final ModelPart leg13;
	private final ModelPart villager8;
	private final ModelPart body8;
	private final ModelPart head8;
	private final ModelPart nose8;
	private final ModelPart arms8;
	private final ModelPart leg14;
	private final ModelPart leg15;
	private final ModelPart villager9;
	private final ModelPart body9;
	private final ModelPart head9;
	private final ModelPart nose9;
	private final ModelPart arms9;
	private final ModelPart leg16;
	private final ModelPart leg17;
	private final ModelPart villager10;
	private final ModelPart body10;
	private final ModelPart head10;
	private final ModelPart nose10;
	private final ModelPart arms10;
	private final ModelPart leg18;
	private final ModelPart leg19;
	private final ModelPart track_r;
	private final ModelPart wheel_r1;
	private final ModelPart wheel_r2;
	private final ModelPart wheel_r3;
	private final ModelPart wheel_r4;
	private final ModelPart tread_r_bot1;
	private final ModelPart tread_r_bot2;
	private final ModelPart tread_r_bot3;
	private final ModelPart tread_r_bot4;
	private final ModelPart tread_r_bot5;
	private final ModelPart tread_r_top1;
	private final ModelPart tread_r_top2;
	private final ModelPart tread_r_top3;
	private final ModelPart tread_r_top4;
	private final ModelPart tread_r_top5;
	private final ModelPart tread_r_f1;
	private final ModelPart tread_r_f2;
	private final ModelPart tread_r_f3;
	private final ModelPart wheel_r_front;
	private final ModelPart tread_r_b1;
	private final ModelPart tread_r_b2;
	private final ModelPart tread_r_b3;
	private final ModelPart wheel_r_back;
	private final ModelPart tread_r_strut1;
	private final ModelPart tread_r_strut2;
	private final ModelPart track_l;
	private final ModelPart wheel_l1;
	private final ModelPart wheel_l2;
	private final ModelPart wheel_l3;
	private final ModelPart wheel_l4;
	private final ModelPart tread_l_bot1;
	private final ModelPart tread_l_bot2;
	private final ModelPart tread_l_bot3;
	private final ModelPart tread_l_bot4;
	private final ModelPart tread_l_bot5;
	private final ModelPart tread_l_top1;
	private final ModelPart tread_l_top2;
	private final ModelPart tread_l_top3;
	private final ModelPart tread_l_top4;
	private final ModelPart tread_l_top5;
	private final ModelPart tread_l_f1;
	private final ModelPart tread_l_f2;
	private final ModelPart tread_l_f3;
	private final ModelPart wheel_l_front;
	private final ModelPart tread_l_b1;
	private final ModelPart tread_l_b2;
	private final ModelPart tread_l_b3;
	private final ModelPart wheel_l_back;
	private final ModelPart tread_l_strut1;
	private final ModelPart tread_l_strut2;
	private final ModelPart tank_head;
	private final ModelPart villager21;
	private final ModelPart body21;
	private final ModelPart head21;
	private final ModelPart nose21;
	private final ModelPart arms21;
	private final ModelPart leg40;
	private final ModelPart leg41;
	private final ModelPart villager22;
	private final ModelPart body22;
	private final ModelPart head22;
	private final ModelPart nose22;
	private final ModelPart arms22;
	private final ModelPart leg42;
	private final ModelPart leg43;
	private final ModelPart villager23;
	private final ModelPart body23;
	private final ModelPart head23;
	private final ModelPart nose23;
	private final ModelPart arms23;
	private final ModelPart leg44;
	private final ModelPart leg45;
	private final ModelPart villager24;
	private final ModelPart body24;
	private final ModelPart head24;
	private final ModelPart nose24;
	private final ModelPart arms24;
	private final ModelPart leg46;
	private final ModelPart leg47;
	private final ModelPart villager25;
	private final ModelPart body25;
	private final ModelPart head25;
	private final ModelPart nose25;
	private final ModelPart arms25;
	private final ModelPart leg48;
	private final ModelPart leg49;

	public renderphoenix.tank(ModelPart root) {
		this.platform = root.getChild("platform");
		this.bone3 = this.platform.getChild("bone3");
		this.villager11 = this.bone3.getChild("villager11");
		this.body11 = this.villager11.getChild("body11");
		this.head11 = this.body11.getChild("head11");
		this.nose11 = this.head11.getChild("nose11");
		this.arms11 = this.body11.getChild("arms11");
		this.leg20 = this.body11.getChild("leg20");
		this.leg21 = this.body11.getChild("leg21");
		this.villager12 = this.bone3.getChild("villager12");
		this.body12 = this.villager12.getChild("body12");
		this.head12 = this.body12.getChild("head12");
		this.nose12 = this.head12.getChild("nose12");
		this.arms12 = this.body12.getChild("arms12");
		this.leg22 = this.body12.getChild("leg22");
		this.leg23 = this.body12.getChild("leg23");
		this.villager13 = this.bone3.getChild("villager13");
		this.body13 = this.villager13.getChild("body13");
		this.head13 = this.body13.getChild("head13");
		this.nose13 = this.head13.getChild("nose13");
		this.arms13 = this.body13.getChild("arms13");
		this.leg24 = this.body13.getChild("leg24");
		this.leg25 = this.body13.getChild("leg25");
		this.villager14 = this.bone3.getChild("villager14");
		this.body14 = this.villager14.getChild("body14");
		this.head14 = this.body14.getChild("head14");
		this.nose14 = this.head14.getChild("nose14");
		this.arms14 = this.body14.getChild("arms14");
		this.leg26 = this.body14.getChild("leg26");
		this.leg27 = this.body14.getChild("leg27");
		this.villager15 = this.bone3.getChild("villager15");
		this.body15 = this.villager15.getChild("body15");
		this.head15 = this.body15.getChild("head15");
		this.nose15 = this.head15.getChild("nose15");
		this.arms15 = this.body15.getChild("arms15");
		this.leg28 = this.body15.getChild("leg28");
		this.leg29 = this.body15.getChild("leg29");
		this.bone = this.platform.getChild("bone");
		this.villager = this.bone.getChild("villager");
		this.body = this.villager.getChild("body");
		this.head = this.body.getChild("head");
		this.nose = this.head.getChild("nose");
		this.arms = this.body.getChild("arms");
		this.leg0 = this.body.getChild("leg0");
		this.leg1 = this.body.getChild("leg1");
		this.villager2 = this.bone.getChild("villager2");
		this.body2 = this.villager2.getChild("body2");
		this.head2 = this.body2.getChild("head2");
		this.nose2 = this.head2.getChild("nose2");
		this.arms2 = this.body2.getChild("arms2");
		this.leg2 = this.body2.getChild("leg2");
		this.leg3 = this.body2.getChild("leg3");
		this.villager3 = this.bone.getChild("villager3");
		this.body3 = this.villager3.getChild("body3");
		this.head3 = this.body3.getChild("head3");
		this.nose3 = this.head3.getChild("nose3");
		this.arms3 = this.body3.getChild("arms3");
		this.leg4 = this.body3.getChild("leg4");
		this.leg5 = this.body3.getChild("leg5");
		this.villager4 = this.bone.getChild("villager4");
		this.body4 = this.villager4.getChild("body4");
		this.head4 = this.body4.getChild("head4");
		this.nose4 = this.head4.getChild("nose4");
		this.arms4 = this.body4.getChild("arms4");
		this.leg6 = this.body4.getChild("leg6");
		this.leg7 = this.body4.getChild("leg7");
		this.villager5 = this.bone.getChild("villager5");
		this.body5 = this.villager5.getChild("body5");
		this.head5 = this.body5.getChild("head5");
		this.nose5 = this.head5.getChild("nose5");
		this.arms5 = this.body5.getChild("arms5");
		this.leg8 = this.body5.getChild("leg8");
		this.leg9 = this.body5.getChild("leg9");
		this.bone4 = this.platform.getChild("bone4");
		this.villager16 = this.bone4.getChild("villager16");
		this.body16 = this.villager16.getChild("body16");
		this.head16 = this.body16.getChild("head16");
		this.nose16 = this.head16.getChild("nose16");
		this.arms16 = this.body16.getChild("arms16");
		this.leg30 = this.body16.getChild("leg30");
		this.leg31 = this.body16.getChild("leg31");
		this.villager17 = this.bone4.getChild("villager17");
		this.body17 = this.villager17.getChild("body17");
		this.head17 = this.body17.getChild("head17");
		this.nose17 = this.head17.getChild("nose17");
		this.arms17 = this.body17.getChild("arms17");
		this.leg32 = this.body17.getChild("leg32");
		this.leg33 = this.body17.getChild("leg33");
		this.villager18 = this.bone4.getChild("villager18");
		this.body18 = this.villager18.getChild("body18");
		this.head18 = this.body18.getChild("head18");
		this.nose18 = this.head18.getChild("nose18");
		this.arms18 = this.body18.getChild("arms18");
		this.leg34 = this.body18.getChild("leg34");
		this.leg35 = this.body18.getChild("leg35");
		this.villager19 = this.bone4.getChild("villager19");
		this.body19 = this.villager19.getChild("body19");
		this.head19 = this.body19.getChild("head19");
		this.nose19 = this.head19.getChild("nose19");
		this.arms19 = this.body19.getChild("arms19");
		this.leg36 = this.body19.getChild("leg36");
		this.leg37 = this.body19.getChild("leg37");
		this.villager20 = this.bone4.getChild("villager20");
		this.body20 = this.villager20.getChild("body20");
		this.head20 = this.body20.getChild("head20");
		this.nose20 = this.head20.getChild("nose20");
		this.arms20 = this.body20.getChild("arms20");
		this.leg38 = this.body20.getChild("leg38");
		this.leg39 = this.body20.getChild("leg39");
		this.bone2 = this.platform.getChild("bone2");
		this.villager6 = this.bone2.getChild("villager6");
		this.body6 = this.villager6.getChild("body6");
		this.head6 = this.body6.getChild("head6");
		this.nose6 = this.head6.getChild("nose6");
		this.arms6 = this.body6.getChild("arms6");
		this.leg10 = this.body6.getChild("leg10");
		this.leg11 = this.body6.getChild("leg11");
		this.villager7 = this.bone2.getChild("villager7");
		this.body7 = this.villager7.getChild("body7");
		this.head7 = this.body7.getChild("head7");
		this.nose7 = this.head7.getChild("nose7");
		this.arms7 = this.body7.getChild("arms7");
		this.leg12 = this.body7.getChild("leg12");
		this.leg13 = this.body7.getChild("leg13");
		this.villager8 = this.bone2.getChild("villager8");
		this.body8 = this.villager8.getChild("body8");
		this.head8 = this.body8.getChild("head8");
		this.nose8 = this.head8.getChild("nose8");
		this.arms8 = this.body8.getChild("arms8");
		this.leg14 = this.body8.getChild("leg14");
		this.leg15 = this.body8.getChild("leg15");
		this.villager9 = this.bone2.getChild("villager9");
		this.body9 = this.villager9.getChild("body9");
		this.head9 = this.body9.getChild("head9");
		this.nose9 = this.head9.getChild("nose9");
		this.arms9 = this.body9.getChild("arms9");
		this.leg16 = this.body9.getChild("leg16");
		this.leg17 = this.body9.getChild("leg17");
		this.villager10 = this.bone2.getChild("villager10");
		this.body10 = this.villager10.getChild("body10");
		this.head10 = this.body10.getChild("head10");
		this.nose10 = this.head10.getChild("nose10");
		this.arms10 = this.body10.getChild("arms10");
		this.leg18 = this.body10.getChild("leg18");
		this.leg19 = this.body10.getChild("leg19");
		this.track_r = this.platform.getChild("track_r");
		this.wheel_r1 = this.track_r.getChild("wheel_r1");
		this.wheel_r2 = this.track_r.getChild("wheel_r2");
		this.wheel_r3 = this.track_r.getChild("wheel_r3");
		this.wheel_r4 = this.track_r.getChild("wheel_r4");
		this.tread_r_bot1 = this.track_r.getChild("tread_r_bot1");
		this.tread_r_bot2 = this.track_r.getChild("tread_r_bot2");
		this.tread_r_bot3 = this.track_r.getChild("tread_r_bot3");
		this.tread_r_bot4 = this.track_r.getChild("tread_r_bot4");
		this.tread_r_bot5 = this.track_r.getChild("tread_r_bot5");
		this.tread_r_top1 = this.track_r.getChild("tread_r_top1");
		this.tread_r_top2 = this.track_r.getChild("tread_r_top2");
		this.tread_r_top3 = this.track_r.getChild("tread_r_top3");
		this.tread_r_top4 = this.track_r.getChild("tread_r_top4");
		this.tread_r_top5 = this.track_r.getChild("tread_r_top5");
		this.tread_r_f1 = this.track_r.getChild("tread_r_f1");
		this.tread_r_f2 = this.track_r.getChild("tread_r_f2");
		this.tread_r_f3 = this.track_r.getChild("tread_r_f3");
		this.wheel_r_front = this.track_r.getChild("wheel_r_front");
		this.tread_r_b1 = this.track_r.getChild("tread_r_b1");
		this.tread_r_b2 = this.track_r.getChild("tread_r_b2");
		this.tread_r_b3 = this.track_r.getChild("tread_r_b3");
		this.wheel_r_back = this.track_r.getChild("wheel_r_back");
		this.tread_r_strut1 = this.track_r.getChild("tread_r_strut1");
		this.tread_r_strut2 = this.track_r.getChild("tread_r_strut2");
		this.track_l = this.platform.getChild("track_l");
		this.wheel_l1 = this.track_l.getChild("wheel_l1");
		this.wheel_l2 = this.track_l.getChild("wheel_l2");
		this.wheel_l3 = this.track_l.getChild("wheel_l3");
		this.wheel_l4 = this.track_l.getChild("wheel_l4");
		this.tread_l_bot1 = this.track_l.getChild("tread_l_bot1");
		this.tread_l_bot2 = this.track_l.getChild("tread_l_bot2");
		this.tread_l_bot3 = this.track_l.getChild("tread_l_bot3");
		this.tread_l_bot4 = this.track_l.getChild("tread_l_bot4");
		this.tread_l_bot5 = this.track_l.getChild("tread_l_bot5");
		this.tread_l_top1 = this.track_l.getChild("tread_l_top1");
		this.tread_l_top2 = this.track_l.getChild("tread_l_top2");
		this.tread_l_top3 = this.track_l.getChild("tread_l_top3");
		this.tread_l_top4 = this.track_l.getChild("tread_l_top4");
		this.tread_l_top5 = this.track_l.getChild("tread_l_top5");
		this.tread_l_f1 = this.track_l.getChild("tread_l_f1");
		this.tread_l_f2 = this.track_l.getChild("tread_l_f2");
		this.tread_l_f3 = this.track_l.getChild("tread_l_f3");
		this.wheel_l_front = this.track_l.getChild("wheel_l_front");
		this.tread_l_b1 = this.track_l.getChild("tread_l_b1");
		this.tread_l_b2 = this.track_l.getChild("tread_l_b2");
		this.tread_l_b3 = this.track_l.getChild("tread_l_b3");
		this.wheel_l_back = this.track_l.getChild("wheel_l_back");
		this.tread_l_strut1 = this.track_l.getChild("tread_l_strut1");
		this.tread_l_strut2 = this.track_l.getChild("tread_l_strut2");
		this.tank_head = root.getChild("tank_head");
		this.villager21 = this.tank_head.getChild("villager21");
		this.body21 = this.villager21.getChild("body21");
		this.head21 = this.body21.getChild("head21");
		this.nose21 = this.head21.getChild("nose21");
		this.arms21 = this.body21.getChild("arms21");
		this.leg40 = this.body21.getChild("leg40");
		this.leg41 = this.body21.getChild("leg41");
		this.villager22 = this.tank_head.getChild("villager22");
		this.body22 = this.villager22.getChild("body22");
		this.head22 = this.body22.getChild("head22");
		this.nose22 = this.head22.getChild("nose22");
		this.arms22 = this.body22.getChild("arms22");
		this.leg42 = this.body22.getChild("leg42");
		this.leg43 = this.body22.getChild("leg43");
		this.villager23 = this.tank_head.getChild("villager23");
		this.body23 = this.villager23.getChild("body23");
		this.head23 = this.body23.getChild("head23");
		this.nose23 = this.head23.getChild("nose23");
		this.arms23 = this.body23.getChild("arms23");
		this.leg44 = this.body23.getChild("leg44");
		this.leg45 = this.body23.getChild("leg45");
		this.villager24 = this.tank_head.getChild("villager24");
		this.body24 = this.villager24.getChild("body24");
		this.head24 = this.body24.getChild("head24");
		this.nose24 = this.head24.getChild("nose24");
		this.arms24 = this.body24.getChild("arms24");
		this.leg46 = this.body24.getChild("leg46");
		this.leg47 = this.body24.getChild("leg47");
		this.villager25 = this.tank_head.getChild("villager25");
		this.body25 = this.villager25.getChild("body25");
		this.head25 = this.body25.getChild("head25");
		this.nose25 = this.head25.getChild("nose25");
		this.arms25 = this.body25.getChild("arms25");
		this.leg48 = this.body25.getChild("leg48");
		this.leg49 = this.body25.getChild("leg49");
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

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		platform.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tank_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}