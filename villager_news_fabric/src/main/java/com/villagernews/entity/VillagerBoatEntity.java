package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
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
    protected Item getDropItem() {
        return ModItems.BOAT_ITEM;
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().size() < 2;
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity driver = this.getControllingPassenger();
        Level level = this.level();

        if (!level.isClientSide()) {
            boolean inWater = this.isInWater();
            double gravity = inWater ? 0.0 : -0.04;

            if (driver instanceof ServerPlayer player) {
                Input input = player.getLastClientInput();

                if (input.left()) {
                    this.setYRot(this.getYRot() - 3.0f);
                } else if (input.right()) {
                    this.setYRot(this.getYRot() + 3.0f);
                }

                float targetSpeed = 0.0f;
                if (input.forward()) {
                    targetSpeed = inWater ? 0.38f : 0.12f;
                } else if (input.backward()) {
                    targetSpeed = inWater ? -0.18f : -0.06f;
                }

                this.rowingSpeed = Mth.lerp(0.15f, this.rowingSpeed, targetSpeed);

                float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
                double vx = Mth.sin(radYaw) * this.rowingSpeed;
                double vz = Mth.cos(radYaw) * this.rowingSpeed;

                Vec3 motion = new Vec3(vx, gravity, vz);
                this.setDeltaMovement(motion);
                this.move(MoverType.SELF, motion);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.85, 0.0, 0.85).add(0, gravity, 0));
                this.move(MoverType.SELF, this.getDeltaMovement());
            }
        }
    }

    @Override
    protected void positionRider(Entity passenger, Entity.MoveFunction callback) {
        if (!this.hasPassenger(passenger)) return;

        int index = this.getPassengers().indexOf(passenger);
        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;

        double forward = index == 0 ? 0.4 : -0.5;
        double offsetX = Mth.sin(radYaw) * forward;
        double offsetZ = Mth.cos(radYaw) * forward;

        callback.accept(passenger, this.getX() + offsetX, this.getY() + 0.4, this.getZ() + offsetZ);
    }
}
