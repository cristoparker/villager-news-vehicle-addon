// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class renderphoenix.firefighter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "renderphoenix.firefighter"), "main");
	private final ModelPart root;
	private final ModelPart front_and_back;
	private final ModelPart villager12;
	private final ModelPart body12;
	private final ModelPart head12;
	private final ModelPart nose12;
	private final ModelPart arms12;
	private final ModelPart leg22;
	private final ModelPart leg23;
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
	private final ModelPart villager6;
	private final ModelPart body6;
	private final ModelPart head6;
	private final ModelPart nose6;
	private final ModelPart arms6;
	private final ModelPart leg10;
	private final ModelPart leg11;
	private final ModelPart villager25;
	private final ModelPart body25;
	private final ModelPart head25;
	private final ModelPart nose25;
	private final ModelPart arms25;
	private final ModelPart leg48;
	private final ModelPart leg49;
	private final ModelPart villager24;
	private final ModelPart body24;
	private final ModelPart head24;
	private final ModelPart nose24;
	private final ModelPart arms24;
	private final ModelPart leg46;
	private final ModelPart leg47;
	private final ModelPart line;
	private final ModelPart villager7;
	private final ModelPart body7;
	private final ModelPart head7;
	private final ModelPart nose7;
	private final ModelPart arms7;
	private final ModelPart leg12;
	private final ModelPart leg13;
	private final ModelPart villager10;
	private final ModelPart body10;
	private final ModelPart head10;
	private final ModelPart nose10;
	private final ModelPart arms10;
	private final ModelPart leg18;
	private final ModelPart leg19;
	private final ModelPart villager8;
	private final ModelPart body8;
	private final ModelPart head8;
	private final ModelPart nose8;
	private final ModelPart arms8;
	private final ModelPart leg14;
	private final ModelPart leg15;
	private final ModelPart villager11;
	private final ModelPart body11;
	private final ModelPart head11;
	private final ModelPart nose11;
	private final ModelPart arms11;
	private final ModelPart leg20;
	private final ModelPart leg21;
	private final ModelPart villager9;
	private final ModelPart body9;
	private final ModelPart head9;
	private final ModelPart nose9;
	private final ModelPart arms9;
	private final ModelPart leg16;
	private final ModelPart leg17;
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
	private final ModelPart villager13;
	private final ModelPart body13;
	private final ModelPart head13;
	private final ModelPart nose13;
	private final ModelPart arms13;
	private final ModelPart leg24;
	private final ModelPart leg25;
	private final ModelPart line2;
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
	private final ModelPart top;
	private final ModelPart villager26;
	private final ModelPart body26;
	private final ModelPart head26;
	private final ModelPart nose26;
	private final ModelPart arms26;
	private final ModelPart leg50;
	private final ModelPart leg51;
	private final ModelPart villager28;
	private final ModelPart body28;
	private final ModelPart head28;
	private final ModelPart nose28;
	private final ModelPart arms28;
	private final ModelPart leg54;
	private final ModelPart leg55;
	private final ModelPart villager30;
	private final ModelPart body30;
	private final ModelPart head30;
	private final ModelPart nose30;
	private final ModelPart arms30;
	private final ModelPart leg58;
	private final ModelPart leg59;
	private final ModelPart villager32;
	private final ModelPart body32;
	private final ModelPart head32;
	private final ModelPart nose32;
	private final ModelPart arms32;
	private final ModelPart leg62;
	private final ModelPart leg63;
	private final ModelPart villager27;
	private final ModelPart body27;
	private final ModelPart head27;
	private final ModelPart nose27;
	private final ModelPart arms27;
	private final ModelPart leg52;
	private final ModelPart leg53;
	private final ModelPart villager29;
	private final ModelPart body29;
	private final ModelPart head29;
	private final ModelPart nose29;
	private final ModelPart arms29;
	private final ModelPart leg56;
	private final ModelPart leg57;
	private final ModelPart villager31;
	private final ModelPart body31;
	private final ModelPart head31;
	private final ModelPart nose31;
	private final ModelPart arms31;
	private final ModelPart leg60;
	private final ModelPart leg61;
	private final ModelPart villager33;
	private final ModelPart body33;
	private final ModelPart head33;
	private final ModelPart nose33;
	private final ModelPart arms33;
	private final ModelPart leg64;
	private final ModelPart leg65;
	private final ModelPart bottom;
	private final ModelPart villager34;
	private final ModelPart body34;
	private final ModelPart head35;
	private final ModelPart nose35;
	private final ModelPart arms34;
	private final ModelPart leg66;
	private final ModelPart leg67;
	private final ModelPart villager35;
	private final ModelPart body35;
	private final ModelPart head36;
	private final ModelPart nose36;
	private final ModelPart arms35;
	private final ModelPart leg68;
	private final ModelPart leg69;
	private final ModelPart villager36;
	private final ModelPart body36;
	private final ModelPart head37;
	private final ModelPart nose37;
	private final ModelPart arms36;
	private final ModelPart leg70;
	private final ModelPart leg71;
	private final ModelPart villager37;
	private final ModelPart body37;
	private final ModelPart head38;
	private final ModelPart nose38;
	private final ModelPart arms37;
	private final ModelPart leg72;
	private final ModelPart leg73;
	private final ModelPart villager38;
	private final ModelPart body38;
	private final ModelPart head39;
	private final ModelPart nose39;
	private final ModelPart arms38;
	private final ModelPart leg74;
	private final ModelPart leg75;
	private final ModelPart villager39;
	private final ModelPart body39;
	private final ModelPart head40;
	private final ModelPart nose40;
	private final ModelPart arms39;
	private final ModelPart leg76;
	private final ModelPart leg77;
	private final ModelPart villager40;
	private final ModelPart body40;
	private final ModelPart head41;
	private final ModelPart nose41;
	private final ModelPart arms40;
	private final ModelPart leg78;
	private final ModelPart leg79;
	private final ModelPart villager41;
	private final ModelPart body41;
	private final ModelPart head42;
	private final ModelPart nose42;
	private final ModelPart arms41;
	private final ModelPart leg80;
	private final ModelPart leg81;
	private final ModelPart head;
	private final ModelPart head34;
	private final ModelPart nose34;
	private final ModelPart wheel1;
	private final ModelPart nose43;
	private final ModelPart wheel3;
	private final ModelPart nose45;
	private final ModelPart wheel2;
	private final ModelPart nose44;
	private final ModelPart wheel4;
	private final ModelPart nose46;
	private final ModelPart pipe;
	private final ModelPart villager42;
	private final ModelPart body42;
	private final ModelPart head43;
	private final ModelPart nose47;
	private final ModelPart arms42;
	private final ModelPart leg82;
	private final ModelPart leg83;
	private final ModelPart villager43;
	private final ModelPart body43;
	private final ModelPart head44;
	private final ModelPart nose48;
	private final ModelPart arms43;
	private final ModelPart leg84;
	private final ModelPart leg85;
	private final ModelPart villager44;
	private final ModelPart body44;
	private final ModelPart head45;
	private final ModelPart nose49;
	private final ModelPart arms44;
	private final ModelPart leg86;
	private final ModelPart leg87;
	private final ModelPart villager45;
	private final ModelPart body45;
	private final ModelPart head46;
	private final ModelPart nose50;
	private final ModelPart arms45;
	private final ModelPart leg88;
	private final ModelPart leg89;
	private final ModelPart villager47;
	private final ModelPart body47;
	private final ModelPart head48;
	private final ModelPart nose52;
	private final ModelPart arms47;
	private final ModelPart leg92;
	private final ModelPart leg93;
	private final ModelPart villager46;
	private final ModelPart body46;
	private final ModelPart head47;
	private final ModelPart nose51;
	private final ModelPart arms46;
	private final ModelPart leg90;
	private final ModelPart leg91;

	public renderphoenix.firefighter(ModelPart root) {
		this.root = root.getChild("root");
		this.front_and_back = this.root.getChild("front_and_back");
		this.villager12 = this.front_and_back.getChild("villager12");
		this.body12 = this.villager12.getChild("body12");
		this.head12 = this.body12.getChild("head12");
		this.nose12 = this.head12.getChild("nose12");
		this.arms12 = this.body12.getChild("arms12");
		this.leg22 = this.body12.getChild("leg22");
		this.leg23 = this.body12.getChild("leg23");
		this.villager2 = this.front_and_back.getChild("villager2");
		this.body2 = this.villager2.getChild("body2");
		this.head2 = this.body2.getChild("head2");
		this.nose2 = this.head2.getChild("nose2");
		this.arms2 = this.body2.getChild("arms2");
		this.leg2 = this.body2.getChild("leg2");
		this.leg3 = this.body2.getChild("leg3");
		this.villager3 = this.front_and_back.getChild("villager3");
		this.body3 = this.villager3.getChild("body3");
		this.head3 = this.body3.getChild("head3");
		this.nose3 = this.head3.getChild("nose3");
		this.arms3 = this.body3.getChild("arms3");
		this.leg4 = this.body3.getChild("leg4");
		this.leg5 = this.body3.getChild("leg5");
		this.villager4 = this.front_and_back.getChild("villager4");
		this.body4 = this.villager4.getChild("body4");
		this.head4 = this.body4.getChild("head4");
		this.nose4 = this.head4.getChild("nose4");
		this.arms4 = this.body4.getChild("arms4");
		this.leg6 = this.body4.getChild("leg6");
		this.leg7 = this.body4.getChild("leg7");
		this.villager5 = this.front_and_back.getChild("villager5");
		this.body5 = this.villager5.getChild("body5");
		this.head5 = this.body5.getChild("head5");
		this.nose5 = this.head5.getChild("nose5");
		this.arms5 = this.body5.getChild("arms5");
		this.leg8 = this.body5.getChild("leg8");
		this.leg9 = this.body5.getChild("leg9");
		this.villager6 = this.front_and_back.getChild("villager6");
		this.body6 = this.villager6.getChild("body6");
		this.head6 = this.body6.getChild("head6");
		this.nose6 = this.head6.getChild("nose6");
		this.arms6 = this.body6.getChild("arms6");
		this.leg10 = this.body6.getChild("leg10");
		this.leg11 = this.body6.getChild("leg11");
		this.villager25 = this.front_and_back.getChild("villager25");
		this.body25 = this.villager25.getChild("body25");
		this.head25 = this.body25.getChild("head25");
		this.nose25 = this.head25.getChild("nose25");
		this.arms25 = this.body25.getChild("arms25");
		this.leg48 = this.body25.getChild("leg48");
		this.leg49 = this.body25.getChild("leg49");
		this.villager24 = this.front_and_back.getChild("villager24");
		this.body24 = this.villager24.getChild("body24");
		this.head24 = this.body24.getChild("head24");
		this.nose24 = this.head24.getChild("nose24");
		this.arms24 = this.body24.getChild("arms24");
		this.leg46 = this.body24.getChild("leg46");
		this.leg47 = this.body24.getChild("leg47");
		this.line = this.root.getChild("line");
		this.villager7 = this.line.getChild("villager7");
		this.body7 = this.villager7.getChild("body7");
		this.head7 = this.body7.getChild("head7");
		this.nose7 = this.head7.getChild("nose7");
		this.arms7 = this.body7.getChild("arms7");
		this.leg12 = this.body7.getChild("leg12");
		this.leg13 = this.body7.getChild("leg13");
		this.villager10 = this.line.getChild("villager10");
		this.body10 = this.villager10.getChild("body10");
		this.head10 = this.body10.getChild("head10");
		this.nose10 = this.head10.getChild("nose10");
		this.arms10 = this.body10.getChild("arms10");
		this.leg18 = this.body10.getChild("leg18");
		this.leg19 = this.body10.getChild("leg19");
		this.villager8 = this.line.getChild("villager8");
		this.body8 = this.villager8.getChild("body8");
		this.head8 = this.body8.getChild("head8");
		this.nose8 = this.head8.getChild("nose8");
		this.arms8 = this.body8.getChild("arms8");
		this.leg14 = this.body8.getChild("leg14");
		this.leg15 = this.body8.getChild("leg15");
		this.villager11 = this.line.getChild("villager11");
		this.body11 = this.villager11.getChild("body11");
		this.head11 = this.body11.getChild("head11");
		this.nose11 = this.head11.getChild("nose11");
		this.arms11 = this.body11.getChild("arms11");
		this.leg20 = this.body11.getChild("leg20");
		this.leg21 = this.body11.getChild("leg21");
		this.villager9 = this.line.getChild("villager9");
		this.body9 = this.villager9.getChild("body9");
		this.head9 = this.body9.getChild("head9");
		this.nose9 = this.head9.getChild("nose9");
		this.arms9 = this.body9.getChild("arms9");
		this.leg16 = this.body9.getChild("leg16");
		this.leg17 = this.body9.getChild("leg17");
		this.villager14 = this.line.getChild("villager14");
		this.body14 = this.villager14.getChild("body14");
		this.head14 = this.body14.getChild("head14");
		this.nose14 = this.head14.getChild("nose14");
		this.arms14 = this.body14.getChild("arms14");
		this.leg26 = this.body14.getChild("leg26");
		this.leg27 = this.body14.getChild("leg27");
		this.villager15 = this.line.getChild("villager15");
		this.body15 = this.villager15.getChild("body15");
		this.head15 = this.body15.getChild("head15");
		this.nose15 = this.head15.getChild("nose15");
		this.arms15 = this.body15.getChild("arms15");
		this.leg28 = this.body15.getChild("leg28");
		this.leg29 = this.body15.getChild("leg29");
		this.villager13 = this.line.getChild("villager13");
		this.body13 = this.villager13.getChild("body13");
		this.head13 = this.body13.getChild("head13");
		this.nose13 = this.head13.getChild("nose13");
		this.arms13 = this.body13.getChild("arms13");
		this.leg24 = this.body13.getChild("leg24");
		this.leg25 = this.body13.getChild("leg25");
		this.line2 = this.root.getChild("line2");
		this.villager16 = this.line2.getChild("villager16");
		this.body16 = this.villager16.getChild("body16");
		this.head16 = this.body16.getChild("head16");
		this.nose16 = this.head16.getChild("nose16");
		this.arms16 = this.body16.getChild("arms16");
		this.leg30 = this.body16.getChild("leg30");
		this.leg31 = this.body16.getChild("leg31");
		this.villager17 = this.line2.getChild("villager17");
		this.body17 = this.villager17.getChild("body17");
		this.head17 = this.body17.getChild("head17");
		this.nose17 = this.head17.getChild("nose17");
		this.arms17 = this.body17.getChild("arms17");
		this.leg32 = this.body17.getChild("leg32");
		this.leg33 = this.body17.getChild("leg33");
		this.villager18 = this.line2.getChild("villager18");
		this.body18 = this.villager18.getChild("body18");
		this.head18 = this.body18.getChild("head18");
		this.nose18 = this.head18.getChild("nose18");
		this.arms18 = this.body18.getChild("arms18");
		this.leg34 = this.body18.getChild("leg34");
		this.leg35 = this.body18.getChild("leg35");
		this.villager19 = this.line2.getChild("villager19");
		this.body19 = this.villager19.getChild("body19");
		this.head19 = this.body19.getChild("head19");
		this.nose19 = this.head19.getChild("nose19");
		this.arms19 = this.body19.getChild("arms19");
		this.leg36 = this.body19.getChild("leg36");
		this.leg37 = this.body19.getChild("leg37");
		this.villager20 = this.line2.getChild("villager20");
		this.body20 = this.villager20.getChild("body20");
		this.head20 = this.body20.getChild("head20");
		this.nose20 = this.head20.getChild("nose20");
		this.arms20 = this.body20.getChild("arms20");
		this.leg38 = this.body20.getChild("leg38");
		this.leg39 = this.body20.getChild("leg39");
		this.villager21 = this.line2.getChild("villager21");
		this.body21 = this.villager21.getChild("body21");
		this.head21 = this.body21.getChild("head21");
		this.nose21 = this.head21.getChild("nose21");
		this.arms21 = this.body21.getChild("arms21");
		this.leg40 = this.body21.getChild("leg40");
		this.leg41 = this.body21.getChild("leg41");
		this.villager22 = this.line2.getChild("villager22");
		this.body22 = this.villager22.getChild("body22");
		this.head22 = this.body22.getChild("head22");
		this.nose22 = this.head22.getChild("nose22");
		this.arms22 = this.body22.getChild("arms22");
		this.leg42 = this.body22.getChild("leg42");
		this.leg43 = this.body22.getChild("leg43");
		this.villager23 = this.line2.getChild("villager23");
		this.body23 = this.villager23.getChild("body23");
		this.head23 = this.body23.getChild("head23");
		this.nose23 = this.head23.getChild("nose23");
		this.arms23 = this.body23.getChild("arms23");
		this.leg44 = this.body23.getChild("leg44");
		this.leg45 = this.body23.getChild("leg45");
		this.top = this.root.getChild("top");
		this.villager26 = this.top.getChild("villager26");
		this.body26 = this.villager26.getChild("body26");
		this.head26 = this.body26.getChild("head26");
		this.nose26 = this.head26.getChild("nose26");
		this.arms26 = this.body26.getChild("arms26");
		this.leg50 = this.body26.getChild("leg50");
		this.leg51 = this.body26.getChild("leg51");
		this.villager28 = this.top.getChild("villager28");
		this.body28 = this.villager28.getChild("body28");
		this.head28 = this.body28.getChild("head28");
		this.nose28 = this.head28.getChild("nose28");
		this.arms28 = this.body28.getChild("arms28");
		this.leg54 = this.body28.getChild("leg54");
		this.leg55 = this.body28.getChild("leg55");
		this.villager30 = this.top.getChild("villager30");
		this.body30 = this.villager30.getChild("body30");
		this.head30 = this.body30.getChild("head30");
		this.nose30 = this.head30.getChild("nose30");
		this.arms30 = this.body30.getChild("arms30");
		this.leg58 = this.body30.getChild("leg58");
		this.leg59 = this.body30.getChild("leg59");
		this.villager32 = this.top.getChild("villager32");
		this.body32 = this.villager32.getChild("body32");
		this.head32 = this.body32.getChild("head32");
		this.nose32 = this.head32.getChild("nose32");
		this.arms32 = this.body32.getChild("arms32");
		this.leg62 = this.body32.getChild("leg62");
		this.leg63 = this.body32.getChild("leg63");
		this.villager27 = this.top.getChild("villager27");
		this.body27 = this.villager27.getChild("body27");
		this.head27 = this.body27.getChild("head27");
		this.nose27 = this.head27.getChild("nose27");
		this.arms27 = this.body27.getChild("arms27");
		this.leg52 = this.body27.getChild("leg52");
		this.leg53 = this.body27.getChild("leg53");
		this.villager29 = this.top.getChild("villager29");
		this.body29 = this.villager29.getChild("body29");
		this.head29 = this.body29.getChild("head29");
		this.nose29 = this.head29.getChild("nose29");
		this.arms29 = this.body29.getChild("arms29");
		this.leg56 = this.body29.getChild("leg56");
		this.leg57 = this.body29.getChild("leg57");
		this.villager31 = this.top.getChild("villager31");
		this.body31 = this.villager31.getChild("body31");
		this.head31 = this.body31.getChild("head31");
		this.nose31 = this.head31.getChild("nose31");
		this.arms31 = this.body31.getChild("arms31");
		this.leg60 = this.body31.getChild("leg60");
		this.leg61 = this.body31.getChild("leg61");
		this.villager33 = this.top.getChild("villager33");
		this.body33 = this.villager33.getChild("body33");
		this.head33 = this.body33.getChild("head33");
		this.nose33 = this.head33.getChild("nose33");
		this.arms33 = this.body33.getChild("arms33");
		this.leg64 = this.body33.getChild("leg64");
		this.leg65 = this.body33.getChild("leg65");
		this.bottom = this.root.getChild("bottom");
		this.villager34 = this.bottom.getChild("villager34");
		this.body34 = this.villager34.getChild("body34");
		this.head35 = this.body34.getChild("head35");
		this.nose35 = this.head35.getChild("nose35");
		this.arms34 = this.body34.getChild("arms34");
		this.leg66 = this.body34.getChild("leg66");
		this.leg67 = this.body34.getChild("leg67");
		this.villager35 = this.bottom.getChild("villager35");
		this.body35 = this.villager35.getChild("body35");
		this.head36 = this.body35.getChild("head36");
		this.nose36 = this.head36.getChild("nose36");
		this.arms35 = this.body35.getChild("arms35");
		this.leg68 = this.body35.getChild("leg68");
		this.leg69 = this.body35.getChild("leg69");
		this.villager36 = this.bottom.getChild("villager36");
		this.body36 = this.villager36.getChild("body36");
		this.head37 = this.body36.getChild("head37");
		this.nose37 = this.head37.getChild("nose37");
		this.arms36 = this.body36.getChild("arms36");
		this.leg70 = this.body36.getChild("leg70");
		this.leg71 = this.body36.getChild("leg71");
		this.villager37 = this.bottom.getChild("villager37");
		this.body37 = this.villager37.getChild("body37");
		this.head38 = this.body37.getChild("head38");
		this.nose38 = this.head38.getChild("nose38");
		this.arms37 = this.body37.getChild("arms37");
		this.leg72 = this.body37.getChild("leg72");
		this.leg73 = this.body37.getChild("leg73");
		this.villager38 = this.bottom.getChild("villager38");
		this.body38 = this.villager38.getChild("body38");
		this.head39 = this.body38.getChild("head39");
		this.nose39 = this.head39.getChild("nose39");
		this.arms38 = this.body38.getChild("arms38");
		this.leg74 = this.body38.getChild("leg74");
		this.leg75 = this.body38.getChild("leg75");
		this.villager39 = this.bottom.getChild("villager39");
		this.body39 = this.villager39.getChild("body39");
		this.head40 = this.body39.getChild("head40");
		this.nose40 = this.head40.getChild("nose40");
		this.arms39 = this.body39.getChild("arms39");
		this.leg76 = this.body39.getChild("leg76");
		this.leg77 = this.body39.getChild("leg77");
		this.villager40 = this.bottom.getChild("villager40");
		this.body40 = this.villager40.getChild("body40");
		this.head41 = this.body40.getChild("head41");
		this.nose41 = this.head41.getChild("nose41");
		this.arms40 = this.body40.getChild("arms40");
		this.leg78 = this.body40.getChild("leg78");
		this.leg79 = this.body40.getChild("leg79");
		this.villager41 = this.bottom.getChild("villager41");
		this.body41 = this.villager41.getChild("body41");
		this.head42 = this.body41.getChild("head42");
		this.nose42 = this.head42.getChild("nose42");
		this.arms41 = this.body41.getChild("arms41");
		this.leg80 = this.body41.getChild("leg80");
		this.leg81 = this.body41.getChild("leg81");
		this.head = this.root.getChild("head");
		this.head34 = this.head.getChild("head34");
		this.nose34 = this.head34.getChild("nose34");
		this.wheel1 = this.root.getChild("wheel1");
		this.nose43 = this.wheel1.getChild("nose43");
		this.wheel3 = this.root.getChild("wheel3");
		this.nose45 = this.wheel3.getChild("nose45");
		this.wheel2 = this.root.getChild("wheel2");
		this.nose44 = this.wheel2.getChild("nose44");
		this.wheel4 = this.root.getChild("wheel4");
		this.nose46 = this.wheel4.getChild("nose46");
		this.pipe = this.root.getChild("pipe");
		this.villager42 = this.pipe.getChild("villager42");
		this.body42 = this.villager42.getChild("body42");
		this.head43 = this.body42.getChild("head43");
		this.nose47 = this.head43.getChild("nose47");
		this.arms42 = this.body42.getChild("arms42");
		this.leg82 = this.body42.getChild("leg82");
		this.leg83 = this.body42.getChild("leg83");
		this.villager43 = this.pipe.getChild("villager43");
		this.body43 = this.villager43.getChild("body43");
		this.head44 = this.body43.getChild("head44");
		this.nose48 = this.head44.getChild("nose48");
		this.arms43 = this.body43.getChild("arms43");
		this.leg84 = this.body43.getChild("leg84");
		this.leg85 = this.body43.getChild("leg85");
		this.villager44 = this.pipe.getChild("villager44");
		this.body44 = this.villager44.getChild("body44");
		this.head45 = this.body44.getChild("head45");
		this.nose49 = this.head45.getChild("nose49");
		this.arms44 = this.body44.getChild("arms44");
		this.leg86 = this.body44.getChild("leg86");
		this.leg87 = this.body44.getChild("leg87");
		this.villager45 = this.pipe.getChild("villager45");
		this.body45 = this.villager45.getChild("body45");
		this.head46 = this.body45.getChild("head46");
		this.nose50 = this.head46.getChild("nose50");
		this.arms45 = this.body45.getChild("arms45");
		this.leg88 = this.body45.getChild("leg88");
		this.leg89 = this.body45.getChild("leg89");
		this.villager47 = this.pipe.getChild("villager47");
		this.body47 = this.villager47.getChild("body47");
		this.head48 = this.body47.getChild("head48");
		this.nose52 = this.head48.getChild("nose52");
		this.arms47 = this.body47.getChild("arms47");
		this.leg92 = this.body47.getChild("leg92");
		this.leg93 = this.body47.getChild("leg93");
		this.villager46 = this.pipe.getChild("villager46");
		this.body46 = this.villager46.getChild("body46");
		this.head47 = this.body46.getChild("head47");
		this.nose51 = this.head47.getChild("nose51");
		this.arms46 = this.body46.getChild("arms46");
		this.leg90 = this.body46.getChild("leg90");
		this.leg91 = this.body46.getChild("leg91");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 80.0F));

		PartDefinition front_and_back = root.addOrReplaceChild("front_and_back", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -134.0F));

		PartDefinition villager12 = front_and_back.addOrReplaceChild("villager12", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body12 = villager12.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head12 = body12.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose12 = head12.addOrReplaceChild("nose12", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms12 = body12.addOrReplaceChild("arms12", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg22 = body12.addOrReplaceChild("leg22", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg23 = body12.addOrReplaceChild("leg23", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager2 = front_and_back.addOrReplaceChild("villager2", CubeListBuilder.create(), PartPose.offset(16.0F, 0.0F, 0.0F));

		PartDefinition body2 = villager2.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head2 = body2.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose2 = head2.addOrReplaceChild("nose2", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms2 = body2.addOrReplaceChild("arms2", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg2 = body2.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg3 = body2.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager3 = front_and_back.addOrReplaceChild("villager3", CubeListBuilder.create(), PartPose.offset(-16.0F, 0.0F, 0.0F));

		PartDefinition body3 = villager3.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head3 = body3.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose3 = head3.addOrReplaceChild("nose3", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms3 = body3.addOrReplaceChild("arms3", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg4 = body3.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg5 = body3.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager4 = front_and_back.addOrReplaceChild("villager4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 136.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body4 = villager4.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head4 = body4.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose4 = head4.addOrReplaceChild("nose4", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms4 = body4.addOrReplaceChild("arms4", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg6 = body4.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg7 = body4.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager5 = front_and_back.addOrReplaceChild("villager5", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 0.0F, 136.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body5 = villager5.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head5 = body5.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose5 = head5.addOrReplaceChild("nose5", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms5 = body5.addOrReplaceChild("arms5", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg8 = body5.addOrReplaceChild("leg8", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg9 = body5.addOrReplaceChild("leg9", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager6 = front_and_back.addOrReplaceChild("villager6", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 136.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body6 = villager6.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head6 = body6.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose6 = head6.addOrReplaceChild("nose6", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms6 = body6.addOrReplaceChild("arms6", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg10 = body6.addOrReplaceChild("leg10", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg11 = body6.addOrReplaceChild("leg11", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager25 = front_and_back.addOrReplaceChild("villager25", CubeListBuilder.create(), PartPose.offset(16.0F, 0.0F, 0.0F));

		PartDefinition body25 = villager25.addOrReplaceChild("body25", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head25 = body25.addOrReplaceChild("head25", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose25 = head25.addOrReplaceChild("nose25", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms25 = body25.addOrReplaceChild("arms25", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg48 = body25.addOrReplaceChild("leg48", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg49 = body25.addOrReplaceChild("leg49", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager24 = front_and_back.addOrReplaceChild("villager24", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body24 = villager24.addOrReplaceChild("body24", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head24 = body24.addOrReplaceChild("head24", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose24 = head24.addOrReplaceChild("nose24", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms24 = body24.addOrReplaceChild("arms24", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg46 = body24.addOrReplaceChild("leg46", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg47 = body24.addOrReplaceChild("leg47", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition line = root.addOrReplaceChild("line", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -11.0F, -74.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition villager7 = line.addOrReplaceChild("villager7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body7 = villager7.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head7 = body7.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose7 = head7.addOrReplaceChild("nose7", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms7 = body7.addOrReplaceChild("arms7", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg12 = body7.addOrReplaceChild("leg12", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg13 = body7.addOrReplaceChild("leg13", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager10 = line.addOrReplaceChild("villager10", CubeListBuilder.create(), PartPose.offsetAndRotation(48.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body10 = villager10.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head10 = body10.addOrReplaceChild("head10", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose10 = head10.addOrReplaceChild("nose10", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms10 = body10.addOrReplaceChild("arms10", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg18 = body10.addOrReplaceChild("leg18", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg19 = body10.addOrReplaceChild("leg19", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager8 = line.addOrReplaceChild("villager8", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body8 = villager8.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head8 = body8.addOrReplaceChild("head8", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose8 = head8.addOrReplaceChild("nose8", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms8 = body8.addOrReplaceChild("arms8", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg14 = body8.addOrReplaceChild("leg14", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg15 = body8.addOrReplaceChild("leg15", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager11 = line.addOrReplaceChild("villager11", CubeListBuilder.create(), PartPose.offsetAndRotation(64.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body11 = villager11.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head11 = body11.addOrReplaceChild("head11", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose11 = head11.addOrReplaceChild("nose11", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms11 = body11.addOrReplaceChild("arms11", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg20 = body11.addOrReplaceChild("leg20", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg21 = body11.addOrReplaceChild("leg21", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager9 = line.addOrReplaceChild("villager9", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body9 = villager9.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head9 = body9.addOrReplaceChild("head9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose9 = head9.addOrReplaceChild("nose9", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms9 = body9.addOrReplaceChild("arms9", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg16 = body9.addOrReplaceChild("leg16", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg17 = body9.addOrReplaceChild("leg17", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager14 = line.addOrReplaceChild("villager14", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body14 = villager14.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head14 = body14.addOrReplaceChild("head14", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose14 = head14.addOrReplaceChild("nose14", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms14 = body14.addOrReplaceChild("arms14", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg26 = body14.addOrReplaceChild("leg26", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg27 = body14.addOrReplaceChild("leg27", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager15 = line.addOrReplaceChild("villager15", CubeListBuilder.create(), PartPose.offsetAndRotation(-48.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body15 = villager15.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head15 = body15.addOrReplaceChild("head15", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose15 = head15.addOrReplaceChild("nose15", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms15 = body15.addOrReplaceChild("arms15", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg28 = body15.addOrReplaceChild("leg28", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg29 = body15.addOrReplaceChild("leg29", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager13 = line.addOrReplaceChild("villager13", CubeListBuilder.create(), PartPose.offsetAndRotation(32.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body13 = villager13.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head13 = body13.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose13 = head13.addOrReplaceChild("nose13", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms13 = body13.addOrReplaceChild("arms13", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg24 = body13.addOrReplaceChild("leg24", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg25 = body13.addOrReplaceChild("leg25", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition line2 = root.addOrReplaceChild("line2", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, -11.0F, -74.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition villager16 = line2.addOrReplaceChild("villager16", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body16 = villager16.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head16 = body16.addOrReplaceChild("head16", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose16 = head16.addOrReplaceChild("nose16", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms16 = body16.addOrReplaceChild("arms16", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg30 = body16.addOrReplaceChild("leg30", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg31 = body16.addOrReplaceChild("leg31", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager17 = line2.addOrReplaceChild("villager17", CubeListBuilder.create(), PartPose.offsetAndRotation(-48.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body17 = villager17.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head17 = body17.addOrReplaceChild("head17", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose17 = head17.addOrReplaceChild("nose17", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms17 = body17.addOrReplaceChild("arms17", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg32 = body17.addOrReplaceChild("leg32", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg33 = body17.addOrReplaceChild("leg33", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager18 = line2.addOrReplaceChild("villager18", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body18 = villager18.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head18 = body18.addOrReplaceChild("head18", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose18 = head18.addOrReplaceChild("nose18", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms18 = body18.addOrReplaceChild("arms18", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg34 = body18.addOrReplaceChild("leg34", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg35 = body18.addOrReplaceChild("leg35", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager19 = line2.addOrReplaceChild("villager19", CubeListBuilder.create(), PartPose.offsetAndRotation(-64.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body19 = villager19.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head19 = body19.addOrReplaceChild("head19", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose19 = head19.addOrReplaceChild("nose19", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms19 = body19.addOrReplaceChild("arms19", CubeListBuilder.create().texOffs(40, 38).mirror().addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 22).mirror().addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg36 = body19.addOrReplaceChild("leg36", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg37 = body19.addOrReplaceChild("leg37", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition villager20 = line2.addOrReplaceChild("villager20", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body20 = villager20.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head20 = body20.addOrReplaceChild("head20", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose20 = head20.addOrReplaceChild("nose20", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms20 = body20.addOrReplaceChild("arms20", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg38 = body20.addOrReplaceChild("leg38", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg39 = body20.addOrReplaceChild("leg39", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager21 = line2.addOrReplaceChild("villager21", CubeListBuilder.create(), PartPose.offsetAndRotation(32.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body21 = villager21.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head21 = body21.addOrReplaceChild("head21", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose21 = head21.addOrReplaceChild("nose21", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms21 = body21.addOrReplaceChild("arms21", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg40 = body21.addOrReplaceChild("leg40", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg41 = body21.addOrReplaceChild("leg41", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager22 = line2.addOrReplaceChild("villager22", CubeListBuilder.create(), PartPose.offsetAndRotation(48.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body22 = villager22.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head22 = body22.addOrReplaceChild("head22", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose22 = head22.addOrReplaceChild("nose22", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms22 = body22.addOrReplaceChild("arms22", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg42 = body22.addOrReplaceChild("leg42", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg43 = body22.addOrReplaceChild("leg43", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager23 = line2.addOrReplaceChild("villager23", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition body23 = villager23.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head23 = body23.addOrReplaceChild("head23", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose23 = head23.addOrReplaceChild("nose23", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms23 = body23.addOrReplaceChild("arms23", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg44 = body23.addOrReplaceChild("leg44", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg45 = body23.addOrReplaceChild("leg45", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition top = root.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(-8.0F, -11.0F, -60.0F));

		PartDefinition villager26 = top.addOrReplaceChild("villager26", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, 33.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body26 = villager26.addOrReplaceChild("body26", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head26 = body26.addOrReplaceChild("head26", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose26 = head26.addOrReplaceChild("nose26", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms26 = body26.addOrReplaceChild("arms26", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg50 = body26.addOrReplaceChild("leg50", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg51 = body26.addOrReplaceChild("leg51", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager28 = top.addOrReplaceChild("villager28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body28 = villager28.addOrReplaceChild("body28", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head28 = body28.addOrReplaceChild("head28", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose28 = head28.addOrReplaceChild("nose28", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms28 = body28.addOrReplaceChild("arms28", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg54 = body28.addOrReplaceChild("leg54", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg55 = body28.addOrReplaceChild("leg55", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager30 = top.addOrReplaceChild("villager30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -36.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body30 = villager30.addOrReplaceChild("body30", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head30 = body30.addOrReplaceChild("head30", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose30 = head30.addOrReplaceChild("nose30", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms30 = body30.addOrReplaceChild("arms30", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg58 = body30.addOrReplaceChild("leg58", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg59 = body30.addOrReplaceChild("leg59", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager32 = top.addOrReplaceChild("villager32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -70.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body32 = villager32.addOrReplaceChild("body32", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head32 = body32.addOrReplaceChild("head32", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose32 = head32.addOrReplaceChild("nose32", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms32 = body32.addOrReplaceChild("arms32", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg62 = body32.addOrReplaceChild("leg62", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg63 = body32.addOrReplaceChild("leg63", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager27 = top.addOrReplaceChild("villager27", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, 33.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body27 = villager27.addOrReplaceChild("body27", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head27 = body27.addOrReplaceChild("head27", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose27 = head27.addOrReplaceChild("nose27", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms27 = body27.addOrReplaceChild("arms27", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg52 = body27.addOrReplaceChild("leg52", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg53 = body27.addOrReplaceChild("leg53", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager29 = top.addOrReplaceChild("villager29", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body29 = villager29.addOrReplaceChild("body29", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head29 = body29.addOrReplaceChild("head29", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose29 = head29.addOrReplaceChild("nose29", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms29 = body29.addOrReplaceChild("arms29", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg56 = body29.addOrReplaceChild("leg56", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg57 = body29.addOrReplaceChild("leg57", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager31 = top.addOrReplaceChild("villager31", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -36.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body31 = villager31.addOrReplaceChild("body31", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head31 = body31.addOrReplaceChild("head31", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose31 = head31.addOrReplaceChild("nose31", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms31 = body31.addOrReplaceChild("arms31", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg60 = body31.addOrReplaceChild("leg60", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg61 = body31.addOrReplaceChild("leg61", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager33 = top.addOrReplaceChild("villager33", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -70.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body33 = villager33.addOrReplaceChild("body33", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head33 = body33.addOrReplaceChild("head33", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose33 = head33.addOrReplaceChild("nose33", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms33 = body33.addOrReplaceChild("arms33", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg64 = body33.addOrReplaceChild("leg64", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg65 = body33.addOrReplaceChild("leg65", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition bottom = root.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -35.0F, -71.0F, 0.0F, 3.1416F, -3.1416F));

		PartDefinition villager34 = bottom.addOrReplaceChild("villager34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, 33.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body34 = villager34.addOrReplaceChild("body34", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head35 = body34.addOrReplaceChild("head35", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose35 = head35.addOrReplaceChild("nose35", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms34 = body34.addOrReplaceChild("arms34", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg66 = body34.addOrReplaceChild("leg66", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg67 = body34.addOrReplaceChild("leg67", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager35 = bottom.addOrReplaceChild("villager35", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body35 = villager35.addOrReplaceChild("body35", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head36 = body35.addOrReplaceChild("head36", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose36 = head36.addOrReplaceChild("nose36", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms35 = body35.addOrReplaceChild("arms35", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg68 = body35.addOrReplaceChild("leg68", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg69 = body35.addOrReplaceChild("leg69", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager36 = bottom.addOrReplaceChild("villager36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -36.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body36 = villager36.addOrReplaceChild("body36", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head37 = body36.addOrReplaceChild("head37", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose37 = head37.addOrReplaceChild("nose37", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms36 = body36.addOrReplaceChild("arms36", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg70 = body36.addOrReplaceChild("leg70", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg71 = body36.addOrReplaceChild("leg71", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager37 = bottom.addOrReplaceChild("villager37", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -70.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body37 = villager37.addOrReplaceChild("body37", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head38 = body37.addOrReplaceChild("head38", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose38 = head38.addOrReplaceChild("nose38", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms37 = body37.addOrReplaceChild("arms37", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg72 = body37.addOrReplaceChild("leg72", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg73 = body37.addOrReplaceChild("leg73", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager38 = bottom.addOrReplaceChild("villager38", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, 33.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body38 = villager38.addOrReplaceChild("body38", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head39 = body38.addOrReplaceChild("head39", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose39 = head39.addOrReplaceChild("nose39", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms38 = body38.addOrReplaceChild("arms38", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg74 = body38.addOrReplaceChild("leg74", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg75 = body38.addOrReplaceChild("leg75", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager39 = bottom.addOrReplaceChild("villager39", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body39 = villager39.addOrReplaceChild("body39", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head40 = body39.addOrReplaceChild("head40", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose40 = head40.addOrReplaceChild("nose40", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms39 = body39.addOrReplaceChild("arms39", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg76 = body39.addOrReplaceChild("leg76", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg77 = body39.addOrReplaceChild("leg77", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager40 = bottom.addOrReplaceChild("villager40", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -36.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body40 = villager40.addOrReplaceChild("body40", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head41 = body40.addOrReplaceChild("head41", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose41 = head41.addOrReplaceChild("nose41", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms40 = body40.addOrReplaceChild("arms40", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg78 = body40.addOrReplaceChild("leg78", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg79 = body40.addOrReplaceChild("leg79", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager41 = bottom.addOrReplaceChild("villager41", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -28.0F, -70.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition body41 = villager41.addOrReplaceChild("body41", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head42 = body41.addOrReplaceChild("head42", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose42 = head42.addOrReplaceChild("nose42", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms41 = body41.addOrReplaceChild("arms41", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg80 = body41.addOrReplaceChild("leg80", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg81 = body41.addOrReplaceChild("leg81", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -18.0F, -144.0F));

		PartDefinition head34 = head.addOrReplaceChild("head34", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 0.0F));

		PartDefinition nose34 = head34.addOrReplaceChild("nose34", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition wheel1 = root.addOrReplaceChild("wheel1", CubeListBuilder.create().texOffs(8, 0).addBox(-4.0F, -5.5F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0F, 0.5F, -112.0F));

		PartDefinition nose43 = wheel1.addOrReplaceChild("nose43", CubeListBuilder.create().texOffs(26, 0).addBox(4.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 0.0F));

		PartDefinition wheel3 = root.addOrReplaceChild("wheel3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-4.0F, -5.5F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-19.0F, 0.5F, -112.0F));

		PartDefinition nose45 = wheel3.addOrReplaceChild("nose45", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-6.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.5F, 0.0F));

		PartDefinition wheel2 = root.addOrReplaceChild("wheel2", CubeListBuilder.create().texOffs(8, 0).addBox(-4.0F, -5.5F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0F, 0.5F, -17.0F));

		PartDefinition nose44 = wheel2.addOrReplaceChild("nose44", CubeListBuilder.create().texOffs(26, 0).addBox(4.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 0.0F));

		PartDefinition wheel4 = root.addOrReplaceChild("wheel4", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-4.0F, -5.5F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-19.0F, 0.5F, -17.0F));

		PartDefinition nose46 = wheel4.addOrReplaceChild("nose46", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-6.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.5F, 0.0F));

		PartDefinition pipe = root.addOrReplaceChild("pipe", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -45.0F, -14.0F, 1.4835F, 0.0F, 0.0F));

		PartDefinition villager42 = pipe.addOrReplaceChild("villager42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body42 = villager42.addOrReplaceChild("body42", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head43 = body42.addOrReplaceChild("head43", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose47 = head43.addOrReplaceChild("nose47", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms42 = body42.addOrReplaceChild("arms42", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg82 = body42.addOrReplaceChild("leg82", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg83 = body42.addOrReplaceChild("leg83", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager43 = pipe.addOrReplaceChild("villager43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -34.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body43 = villager43.addOrReplaceChild("body43", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head44 = body43.addOrReplaceChild("head44", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose48 = head44.addOrReplaceChild("nose48", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms43 = body43.addOrReplaceChild("arms43", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg84 = body43.addOrReplaceChild("leg84", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg85 = body43.addOrReplaceChild("leg85", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager44 = pipe.addOrReplaceChild("villager44", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -68.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body44 = villager44.addOrReplaceChild("body44", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head45 = body44.addOrReplaceChild("head45", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose49 = head45.addOrReplaceChild("nose49", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms44 = body44.addOrReplaceChild("arms44", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg86 = body44.addOrReplaceChild("leg86", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg87 = body44.addOrReplaceChild("leg87", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager45 = pipe.addOrReplaceChild("villager45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -102.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body45 = villager45.addOrReplaceChild("body45", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head46 = body45.addOrReplaceChild("head46", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose50 = head46.addOrReplaceChild("nose50", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms45 = body45.addOrReplaceChild("arms45", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg88 = body45.addOrReplaceChild("leg88", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg89 = body45.addOrReplaceChild("leg89", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager47 = pipe.addOrReplaceChild("villager47", CubeListBuilder.create(), PartPose.offset(0.0F, -150.0F, 8.0F));

		PartDefinition body47 = villager47.addOrReplaceChild("body47", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head48 = body47.addOrReplaceChild("head48", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition nose52 = head48.addOrReplaceChild("nose52", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms47 = body47.addOrReplaceChild("arms47", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leg92 = body47.addOrReplaceChild("leg92", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg93 = body47.addOrReplaceChild("leg93", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition villager46 = pipe.addOrReplaceChild("villager46", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -136.0F, 0.0F, 3.0107F, 0.0F, 3.1416F));

		PartDefinition body46 = villager46.addOrReplaceChild("body46", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition head47 = body46.addOrReplaceChild("head47", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition nose51 = head47.addOrReplaceChild("nose51", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition arms46 = body46.addOrReplaceChild("arms46", CubeListBuilder.create().texOffs(40, 38).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition leg90 = body46.addOrReplaceChild("leg90", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leg91 = body46.addOrReplaceChild("leg91", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}