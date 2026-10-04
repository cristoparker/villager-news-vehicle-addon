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
    public boolean isPickable() {
        return !this.isRemoved();
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand, Vec3 location) {
        InteractionResult superResult = super.interact(player, hand, location);
        if (superResult != InteractionResult.PASS) {
            return superResult;
        }
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        }
        if (!this.level().isClientSide()) {
            return player.startRiding(this) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        } else {
            return this.canAddPassenger(player) ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().size() < this.getMaxPassengers();
    }

    public abstract int getMaxPassengers();

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
        return canVehicleCollide(this, other);
    }

    @Override
    public boolean isPushable() {
        return true;
    }

    /**
     * Detects entities in front of the vehicle and applies kinetic impact, damage, and knockback
     */
    protected void applyRammingCollision(double forwardSpeed, float damageMultiplier, double knockbackStrength) {
        if (this.level().isClientSide() || !(this.level() instanceof ServerLevel serverLevel)) return;
        if (Math.abs(forwardSpeed) < 0.15) return;

        float radYaw = -this.getYRot() * net.minecraft.util.Mth.DEG_TO_RAD;
        double dirX = net.minecraft.util.Mth.sin(radYaw) * Math.signum(forwardSpeed);
        double dirZ = net.minecraft.util.Mth.cos(radYaw) * Math.signum(forwardSpeed);

        net.minecraft.world.phys.AABB ramBox = this.getBoundingBox().inflate(0.5, 0.2, 0.5)
                .expandTowards(dirX * 1.5, 0.0, dirZ * 1.5);

        java.util.List<Entity> targets = serverLevel.getEntities(this, ramBox, e ->
                !this.isPassengerOfSameVehicle(e) && e.isAlive() && !e.isSpectator());

        for (Entity target : targets) {
            float damage = (float) (Math.abs(forwardSpeed) * damageMultiplier);
            DamageSource source = this.getControllingPassenger() != null
                    ? serverLevel.damageSources().mobAttack(this.getControllingPassenger())
                    : serverLevel.damageSources().generic();
            if (target instanceof LivingEntity living) {
                living.hurtServer(serverLevel, source, damage);
            }
            target.push(dirX * knockbackStrength, 0.25, dirZ * knockbackStrength);
        }
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
        return new Vec3(this.getX(), this.getBoundingBox().maxY, this.getZ());
    }
}
