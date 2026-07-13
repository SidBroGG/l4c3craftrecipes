package com.example.l4c3craftrecipes.entity;

import com.example.l4c3craftrecipes.registry.ModEntities;
import com.example.l4c3craftrecipes.registry.ModItems;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public class BedrockBoat extends Boat {
    public BedrockBoat(EntityType<? extends Boat> type, Level level) {
        super(type, level);
    }

    public BedrockBoat(Level level, double x, double y, double z) {
        super(ModEntities.BEDROCK_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.BEDROCK_BOAT_ITEM.get();
    }

    @Override
    public boolean canBoatInFluid(FluidState state) {
        return state.is(FluidTags.LAVA) || state.is(FluidTags.WATER);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
}
