package com.example.l4c3craftrecipes.data;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModBlocks;
import com.example.l4c3craftrecipes.registry.ModItems;
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

    private static void recipe_vitamix_multifruit(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VITAMIX_MULTIFRUIT.value())
                .pattern("R R")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_FLESH_BLOCK_ITEM.value())
                .unlockedBy("has_rotten_flesh_block", has(ModItems.ROTTEN_FLESH_BLOCK_ITEM.value()))
                .save(output);
    }

    private static void recipe_vitamix_apple_grape(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VITAMIX_APPLE_GRAPE.value())
                .pattern("RVR")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_FLESH_BLOCK_ITEM.value())
                .define('V', ModItems.VITAMIX_MULTIFRUIT.value())
                .unlockedBy("has_vitamix_multifruit", has(ModItems.VITAMIX_MULTIFRUIT.value()))
                .save(output);
    }

    private static void recipe_vitamix_cherry(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VITAMIX_CHERRY.value())
                .pattern("R R")
                .pattern("RVR")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_FLESH_BLOCK_ITEM.value())
                .define('V', ModItems.VITAMIX_APPLE_GRAPE.value())
                .unlockedBy("has_vitamix_apple_grape", has(ModItems.VITAMIX_APPLE_GRAPE.value()))
                .save(output);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        recipe_rotten_flesh(output);
        recipe_rotten_flesh_block(output);

        recipe_vitamix_multifruit(output);
        recipe_vitamix_apple_grape(output);
        recipe_vitamix_cherry(output);
    }
}
