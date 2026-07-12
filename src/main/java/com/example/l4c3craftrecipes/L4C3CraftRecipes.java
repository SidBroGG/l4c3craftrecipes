package com.example.l4c3craftrecipes;

import com.example.l4c3craftrecipes.data.ModDataGenerators;
import com.example.l4c3craftrecipes.registry.ModBlocks;
import com.example.l4c3craftrecipes.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(L4C3CraftRecipes.MODID)
public class L4C3CraftRecipes {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "l4c3craftrecipes";

    public L4C3CraftRecipes(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::addCreativeTabItems);
        modEventBus.addListener(ModDataGenerators::gatherData);
    }

    private void addCreativeTabItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS)) {
            event.accept(ModItems.VITAMIX_CHERRY.value());
            event.accept(ModItems.VITAMIX_APPLE_GRAPE.value());
            event.accept(ModItems.VITAMIX_MULTIFRUIT.value());
        }
        if (event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(ModItems.ROTTEN_FLESH_BLOCK_ITEM.value());
            event.accept(ModItems.MATVEY_BLOCK_ITEM.value());
        }
        if (event.getTabKey().equals(CreativeModeTabs.REDSTONE_BLOCKS)) {
            event.accept(ModItems.BEDROCK_BOAT_ITEM.value());
        }
    }
}
