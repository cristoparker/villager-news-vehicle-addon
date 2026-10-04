package com.villagernews.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

public abstract class VehicleBaseEntity extends VehicleEntity {

    public VehicleBaseEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        // Vehicle state persistence
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        // Vehicle state loading
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand, Vec3 location) {
        if (!this.level().isClientSide()) {
            if (player.isSecondaryUseActive()) {
                return InteractionResult.PASS;
            }
            if (this.canAddPassenger(player)) {
                player.startRiding(this);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public LivingEntity getControllingPassenger() {
        Entity first = this.getFirstPassenger();
        return first instanceof LivingEntity living ? living : null;
    }

    @Override
    public boolean canCollideWith(Entity other) {
        return canVehicleCollide(this, other);
    }

    public static boolean canVehicleCollide(Entity vehicle, Entity other) {
        return (other.canBeCollidedWith(vehicle) || other.isPushable()) && !vehicle.isPassengerOfSameVehicle(other);
    }

    @Override
    public boolean canBeCollidedWith(Entity other) {
        return true;
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (this.isInvulnerableToBase(source)) {
            return false;
        }
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() + amount * 10.0f);
        this.markHurt();

        boolean isCreativePlayer = source.getEntity() instanceof Player player && player.getAbilities().instabuild;
        if (isCreativePlayer || this.getDamage() > 40.0f) {
            this.destroy(level, source);
        }
        return true;
    }

    @Override
    protected void destroy(ServerLevel level, DamageSource source) {
        this.destroy(level, this.getDropItem());
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity passenger) {
        Direction dir = this.getDirection();
        if (dir.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(passenger);
        }
        double offsetX = dir.getStepX() * 1.5;
        double offsetZ = dir.getStepZ() * 1.5;
        BlockPos checkPos = this.blockPosition().offset((int) offsetX, 0, (int) offsetZ);
        if (this.level().getBlockState(checkPos).isAir()) {
            return new Vec3(checkPos.getX() + 0.5, this.getY(), checkPos.getZ() + 0.5);
        }
        return new Vec3(this.getX(), this.getY() + 1.0, this.getZ());
    }
}
