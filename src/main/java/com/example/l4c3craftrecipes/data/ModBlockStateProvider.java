package com.example.l4c3craftrecipes.data;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public final class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, L4C3CraftRecipes.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.ROTTEN_FLESH_BLOCK.value(), cubeAll(ModBlocks.ROTTEN_FLESH_BLOCK.value()));
        simpleBlockWithItem(ModBlocks.MATVEY_BLOCK.value(), cubeAll(ModBlocks.MATVEY_BLOCK.value()));
    }
}
