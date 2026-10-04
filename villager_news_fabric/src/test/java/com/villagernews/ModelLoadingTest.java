package com.villagernews;

import com.villagernews.client.render.geo.BedrockModelLoader;
import net.minecraft.client.model.geom.ModelPart;

public class ModelLoadingTest {
    public static void main(String[] args) {
        String[] models = {
                "/assets/villagernews/geo/daladas_plane.geo.json",
                "/assets/villagernews/geo/villager_helicopter.geo.json",
                "/assets/villagernews/geo/villager_tank.geo.json",
                "/assets/villagernews/geo/villager_boat.geo.json",
                "/assets/villagernews/geo/villager_firefighters.geo.json",
                "/assets/villagernews/geo/villager_missile.geo.json"
        };

        for (String m : models) {
            System.out.println("Testing model load: " + m);
            ModelPart part = BedrockModelLoader.load(m);
            System.out.println("-> SUCCESS: " + m + " (isEmpty=" + part.isEmpty() + ")");
        }
        System.out.println("ALL 6 BEDROCK MODELS LOADED AND BAKED SUCCESSFULLY!");
    }
}
