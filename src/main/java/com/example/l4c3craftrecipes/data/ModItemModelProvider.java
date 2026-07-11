package com.example.l4c3craftrecipes.data;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, L4C3CraftRecipes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.VITAMIX_CHERRY.value());
        basicItem(ModItems.VITAMIX_APPLE_GRAPE.value());
        basicItem(ModItems.VITAMIX_MULTIFRUIT.value());
    }
}
