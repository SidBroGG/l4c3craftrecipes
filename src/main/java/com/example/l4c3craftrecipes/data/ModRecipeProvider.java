package com.example.l4c3craftrecipes.data;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    private static void recipe_rotten_flesh(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ROTTEN_FLESH)
                .pattern("I I")
                .pattern(" I ")
                .define('I', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);
    }

    private static void recipe_rotten_flesh_block(RecipeOutput output) {
        nineBlockStorageRecipes(
                output,
                RecipeCategory.MISC,
                Items.ROTTEN_FLESH,
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ROTTEN_FLESH_BLOCK.value(),
                L4C3CraftRecipes.MODID + ":rotten_flesh_block",
                null,
                L4C3CraftRecipes.MODID + ":rotten_flesh_from_block",
                null
        );
    }


    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        recipe_rotten_flesh(output);
        recipe_rotten_flesh_block(output);
    }
}
