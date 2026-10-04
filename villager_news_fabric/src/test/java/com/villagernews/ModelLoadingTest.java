package com.villagernews;

import com.villagernews.client.model.*;
import net.minecraft.client.model.geom.ModelPart;

public class ModelLoadingTest {
    public static void main(String[] args) {
        System.out.println("Testing baking new Java models...");

        ModelPart plane = DaladasPlaneJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Daladas Plane baked successfully (isEmpty=" + plane.isEmpty() + ")");

        ModelPart heli = VillagerHelicopterJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Villager Helicopter baked successfully (isEmpty=" + heli.isEmpty() + ")");

        ModelPart tank = VillagerTankJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Villager Tank baked successfully (isEmpty=" + tank.isEmpty() + ")");

        ModelPart boat = VillagerBoatJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Villager Boat baked successfully (isEmpty=" + boat.isEmpty() + ")");

        ModelPart firefighter = VillagerFirefighterJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Villager Firefighter baked successfully (isEmpty=" + firefighter.isEmpty() + ")");

        ModelPart missile = VillagerMissileJavaModel.createBodyLayer().bakeRoot();
        System.out.println("-> Villager Missile baked successfully (isEmpty=" + missile.isEmpty() + ")");

        Class<?> boatSuper = net.minecraft.world.entity.vehicle.boat.Boat.class.getSuperclass();
        System.out.println("Boat superclass: " + boatSuper.getName());
        for (java.lang.reflect.Method m : boatSuper.getDeclaredMethods()) {
            System.out.println("BoatSuper." + m.getName() + "(" + java.util.Arrays.toString(m.getParameterTypes()) + ") : " + m.getReturnType().getSimpleName());
        }
    }
}
