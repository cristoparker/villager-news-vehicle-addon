package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

public class VillagerBoatEntity extends VehicleBaseEntity {

    private float rowingSpeed = 0.0f;

    public VillagerBoatEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public VillagerBoatEntity(Level level, double x, double y, double z) {
        super(ModEntities.BOAT, level);
        this.setPos(x, y, z);
    }

    @Override
    public float maxUpStep() {
        return 0.6f;
    }

    @Override
    protected Item getDropItem() {
        return ModItems.BOAT_ITEM;
    }

    @Override
    public int getMaxPassengers() {
        return 4;
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity driver = this.getControllingPassenger();
        Level level = this.level();

        if (!level.isClientSide()) {
            double targetVy = calculateWaterYAdjustment();

            if (driver instanceof ServerPlayer player) {
                Input input = player.getLastClientInput();

                if (input.left()) {
                    this.setYRot(this.getYRot() - 3.0f);
                } else if (input.right()) {
                    this.setYRot(this.getYRot() + 3.0f);
                }

                float targetSpeed = 0.0f;
                boolean inWater = this.isInWater();
                if (input.forward()) {
                    targetSpeed = inWater ? 0.38f : 0.12f;
                } else if (input.backward()) {
                    targetSpeed = inWater ? -0.18f : -0.06f;
                }

                this.rowingSpeed = Mth.lerp(0.15f, this.rowingSpeed, targetSpeed);

                float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
                double vx = Mth.sin(radYaw) * this.rowingSpeed;
                double vz = Mth.cos(radYaw) * this.rowingSpeed;

                Vec3 motion = new Vec3(vx, targetVy, vz);
                this.setDeltaMovement(motion);
                this.move(MoverType.SELF, motion);

                // Wake ramming and clearing water vegetation
                if (Math.abs(this.rowingSpeed) > 0.08) {
                    this.applyRammingCollision(this.rowingSpeed, 6.0f, 0.9);
                    if (level instanceof ServerLevel serverLevel) {
                        clearWaterObstacles(serverLevel);
                    }
                }
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.85, 0.0, 0.85).add(0, targetVy, 0));
                this.move(MoverType.SELF, this.getDeltaMovement());
            }
        }
    }

    private double calculateWaterYAdjustment() {
        Level level = this.level();
        BlockPos pos = this.blockPosition();
        for (int y = pos.getY() + 1; y >= pos.getY() - 1; y--) {
            BlockPos checkPos = new BlockPos(pos.getX(), y, pos.getZ());
            FluidState fluid = level.getFluidState(checkPos);
            if (fluid.is(FluidTags.WATER)) {
                double surface = y + fluid.getHeight(level, checkPos);
                double diff = (surface - 0.40) - this.getY();
                return Mth.clamp(diff * 0.35, -0.15, 0.25);
            }
        }
        return this.onGround() ? 0.0 : -0.06;
    }

    private void clearWaterObstacles(ServerLevel serverLevel) {
        AABB box = this.getBoundingBox().inflate(0.1, 0.2, 0.1);
        BlockPos minPos = BlockPos.containing(box.minX, box.minY, box.minZ);
        BlockPos maxPos = BlockPos.containing(box.maxX, box.maxY, box.maxZ);

        for (BlockPos pos : BlockPos.betweenClosed(minPos, maxPos)) {
            BlockState state = serverLevel.getBlockState(pos);
            if (state.is(Blocks.LILY_PAD) || state.is(BlockTags.REPLACEABLE_BY_TREES)) {
                serverLevel.destroyBlock(pos, true, this);
            }
        }
    }

    private static final Vec3[] BOAT_SEATS = new Vec3[] {
        new Vec3(0.0, 0.5, 1.7),
        new Vec3(0.0, 0.5, -0.5),
        new Vec3(0.0, 0.5, -2.0),
        new Vec3(0.0, 0.5, -3.0)
    };

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scale) {
        int index = Math.max(0, Math.min(this.getPassengers().indexOf(passenger), BOAT_SEATS.length - 1));
        return BOAT_SEATS[index].yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }
}
