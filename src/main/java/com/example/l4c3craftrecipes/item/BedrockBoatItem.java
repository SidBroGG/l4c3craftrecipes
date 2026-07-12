package com.example.l4c3craftrecipes.item;

import com.example.l4c3craftrecipes.entity.BedrockBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class BedrockBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

    public BedrockBoatItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        HitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

        if (hitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack);
        }

        Vec3 vec3 = player.getViewVector(1.0F);
        List<Entity> entityList = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);

        if (!entityList.isEmpty()) {
            Vec3 eyePos = player.getEyePosition();
            for (var entity : entityList) {
                AABB aabb = entity.getBoundingBox().inflate((double) entity.getPickRadius());
                if (aabb.contains(eyePos)) {
                    return InteractionResultHolder.pass(itemStack);
                }
            }
        }

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BedrockBoat boat = new BedrockBoat(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
            boat.setYRot(player.getYRot());

            if (!level.isClientSide) {
                level.addFreshEntity(boat);
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hitResult.getLocation());
                itemStack.consume(1, player);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
        }

        return InteractionResultHolder.pass(itemStack);
    }
}
