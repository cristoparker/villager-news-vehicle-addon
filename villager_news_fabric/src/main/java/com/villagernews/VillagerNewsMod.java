package com.villagernews;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import com.villagernews.network.ModMessages;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VillagerNewsMod implements ModInitializer {

    public static final String MOD_ID = "villagernews";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final CreativeModeTab VEHICLES_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MOD_ID, "vehicles"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.DALADAS_ITEM))
                    .title(Component.translatable("itemGroup.villagernews.vehicles"))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.DALADAS_ITEM);
                        output.accept(ModItems.HELICOPTER_ITEM);
                        output.accept(ModItems.TANK_ITEM);
                        output.accept(ModItems.BOAT_ITEM);
                        output.accept(ModItems.FIREFIGHTER_ITEM);
                        output.accept(ModItems.MISSILE_ITEM);
                    })
                    .build()
    );

    @Override
    public void onInitialize() {
        LOGGER.info("[Villager News] Initializing Villager News Vehicles mod for Fabric 26.3...");

        ModEntities.initialize();
        ModItems.initialize();
        ModMessages.initialize();

        LOGGER.info("[Villager News] All entities, items, and flight systems initialized!");
    }
}
