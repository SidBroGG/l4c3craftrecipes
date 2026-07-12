package com.example.l4c3craftrecipes.registry;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.entity.BedrockBoat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, L4C3CraftRecipes.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<BedrockBoat>> BEDROCK_BOAT = ENTITIES.register(
            "bedrock_boat",
            () -> EntityType.Builder.<BedrockBoat>of(BedrockBoat::new, MobCategory.MISC)
                    .sized(1.375F, 0.5625F)
                    .clientTrackingRange(10)
                    .fireImmune()
                    .build("bedrock_boat")
    );

}
