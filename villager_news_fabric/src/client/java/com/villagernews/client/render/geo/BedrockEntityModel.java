package com.villagernews.client.render.geo;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;

import java.util.function.Function;

public class BedrockEntityModel<S extends EntityRenderState> extends EntityModel<S> {

    protected final Function<String, ModelPart> partLookup;

    public BedrockEntityModel(ModelPart root) {
        super(root, RenderTypes::entityCutout);
        this.partLookup = root.createPartLookup();
    }

    public ModelPart getPart(String name) {
        return this.partLookup.apply(name);
    }
}
