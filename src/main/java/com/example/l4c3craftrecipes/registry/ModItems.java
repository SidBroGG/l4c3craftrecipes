package com.example.l4c3craftrecipes.registry;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.item.VitamixItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(L4C3CraftRecipes.MODID);

    public static final DeferredHolder<Item, VitamixItem> VITAMIX_CHERRY =
            ITEMS.registerItem("vitamix_cherry", properties ->
                    new VitamixItem(
                            properties,
                            new MobEffectInstance(MobEffects.WITHER, 30 * 20),
                            new MobEffectInstance(MobEffects.CONFUSION, 30 * 20)
                    )
            );

    public static final DeferredHolder<Item, VitamixItem> VITAMIX_APPLE_GRAPE =
            ITEMS.registerItem("vitamix_apple_grape", properties ->
                    new VitamixItem(
                            properties,
                            new MobEffectInstance(MobEffects.REGENERATION, 5 * 20, 3)
                    )
            );

    public static final DeferredHolder<Item, VitamixItem> VITAMIX_MULTIFRUIT =
            ITEMS.registerItem("vitamix_multifruit", properties ->
                    new VitamixItem(
                            properties,
                            new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 30 * 20)
                    )
            );

    private ModItems() {
    }
}
