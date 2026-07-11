package com.example.l4c3craftrecipes.registry;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(L4C3CraftRecipes.MODID);

    public static final DeferredHolder<Block, Block> ROTTEN_FLESH_BLOCK =
            BLOCKS.registerSimpleBlock("rotten_flesh_block", BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK));

    public static final DeferredHolder<Block, Block> MATVEY_BLOCK =
            BLOCKS.registerSimpleBlock("matvey_block", BlockBehaviour.Properties.ofFullCopy(Blocks.CARVED_PUMPKIN));

    private ModBlocks() {
    }
}
