package com.villagernews.init;

import com.villagernews.item.VehicleSpawnItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final Item DALADAS_ITEM = register("daladas", props -> new VehicleSpawnItem(ModEntities.DALADAS, props.stacksTo(1)));
    public static final Item HELICOPTER_ITEM = register("helicopter", props -> new VehicleSpawnItem(ModEntities.HELICOPTER, props.stacksTo(1)));
    public static final Item TANK_ITEM = register("tank", props -> new VehicleSpawnItem(ModEntities.TANK, props.stacksTo(1)));
    public static final Item BOAT_ITEM = register("boat", props -> new VehicleSpawnItem(ModEntities.BOAT, props.stacksTo(1)));
    public static final Item FIREFIGHTER_ITEM = register("firefighter", props -> new VehicleSpawnItem(ModEntities.FIREFIGHTER, props.stacksTo(1)));
    public static final Item MISSILE_ITEM = register("missile", props -> new Item(props.stacksTo(16)));

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("villagernews", name));
        Item item = factory.apply(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void initialize() {
        // Called to trigger classloading & registry
    }
}
