package com.example.l4c3craftrecipes.client;

import com.example.l4c3craftrecipes.L4C3CraftRecipes;
import com.example.l4c3craftrecipes.registry.ModEntities;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = L4C3CraftRecipes.MODID, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.BEDROCK_BOAT.get(), context -> new BoatRenderer(context, false) {
            @Override
            public @NotNull ResourceLocation getTextureLocation(@NotNull Boat entity) {
                return ResourceLocation.fromNamespaceAndPath(L4C3CraftRecipes.MODID, "texutes/entity/boat/bedrock_boat.png");
            }
        });
    }
}
