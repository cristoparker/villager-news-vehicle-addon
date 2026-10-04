package com.villagernews.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class VehicleSpawnItem extends Item {

    private final EntityType<?> entityType;

    public VehicleSpawnItem(EntityType<?> entityType, Item.Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());

        if (!level.isClientSide()) {
            spawnVehicle(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, context.getPlayer());
            if (context.getPlayer() != null && !context.getPlayer().getAbilities().instabuild) {
                context.getItemInHand().shrink(1);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        BlockHitResult hit = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockPos pos = hit.getBlockPos().relative(hit.getDirection());
            if (!level.isClientSide()) {
                spawnVehicle(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, player);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private void spawnVehicle(Level level, double x, double y, double z, Player player) {
        Entity entity = this.entityType.create(level, EntitySpawnReason.SPAWN_ITEM_USE);
        if (entity != null) {
            float yaw = player != null ? player.getYRot() : 0.0f;
            entity.setPos(x, y, z);
            entity.setYRot(yaw);
            entity.setXRot(0.0f);
            level.addFreshEntity(entity);
        }
    }
}
