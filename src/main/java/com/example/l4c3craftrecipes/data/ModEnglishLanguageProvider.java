package com.example.l4c3craftrecipes.data;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModBlocks;
import com.example.l4c3craftrecipes.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnglishLanguageProvider extends LanguageProvider {
    public ModEnglishLanguageProvider(PackOutput output) {
        super(output, L4C3CraftRecipes.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.VITAMIX_CHERRY.value(), "Vitamix Cherry");
        add(ModItems.VITAMIX_APPLE_GRAPE.value(), "Vitamix Apple Grape");
        add(ModItems.VITAMIX_MULTIFRUIT.value(), "Vitamix Multifruit");

        add(ModBlocks.ROTTEN_FLESH_BLOCK.value(), "Rotten Flesh Block");
        add(ModBlocks.MATVEY_BLOCK.value(), "Matvey Block");
    }
}
