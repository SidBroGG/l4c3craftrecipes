package com.example.l4c3craftrecipes.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public final class VitamixItem extends PotionItem {
    public VitamixItem(Item.Properties properties, MobEffectInstance... effects) {
        super(properties.stacksTo(64)
                .component(DataComponents.POTION_CONTENTS, new PotionContents(Optional.empty(), Optional.empty(), List.of(effects)))
                .component(DataComponents.HIDE_ADDITIONAL_TOOLTIP, Unit.INSTANCE)
        );
    }

    @Override
    public @NotNull String getDescriptionId(@NotNull ItemStack stack) {
        return getDescriptionId();
    }

    @Override
    public @NotNull ItemStack getDefaultInstance() {
        return new ItemStack(this);
    }
}
