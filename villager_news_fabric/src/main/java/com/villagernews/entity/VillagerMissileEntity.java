package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class VillagerMissileEntity extends ThrowableProjectile {

    private int ticksAlive = 0;

    public VillagerMissileEntity(EntityType<? extends ThrowableProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public VillagerMissileEntity(Level level, LivingEntity owner, double x, double y, double z) {
        super(ModEntities.MISSILE, level);
        if (owner != null) {
            this.setOwner(owner);
        }
        this.setPos(x, y, z);
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        if (this.getOwner() != null) {
            if (entity == this.getOwner() || this.getOwner().isPassengerOfSameVehicle(entity)) {
                return false;
            }
            if (entity == this.getOwner().getVehicle()) {
                return false;
            }
        }
        return super.canHitEntity(entity);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // Missile has no additional synced data
    }

    @Override
    protected double getDefaultGravity() {
        return 0.0; // Rocket propelled: flies completely straight
    }

    @Override
    protected float getAirDrag() {
        return 1.0f; // No deceleration in flight
    }

    @Override
    public void tick() {
        super.tick();
        this.ticksAlive++;

        Level level = this.level();
        Vec3 pos = this.position();
        Vec3 vel = this.getDeltaMovement();

        // Smoke and rocket flame particle trail
        if (level.isClientSide()) {
            double backX = pos.x - vel.x * 0.4;
            double backY = pos.y - vel.y * 0.4;
            double backZ = pos.z - vel.z * 0.4;
            level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, backX, backY, backZ, -vel.x * 0.1, 0.02, -vel.z * 0.1);
            level.addParticle(ParticleTypes.SMOKE, backX, backY, backZ, 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, backX, backY, backZ, 0, 0, 0);
        }

        // Max 7 seconds flight time (140 ticks)
        if (!level.isClientSide() && this.ticksAlive > 140) {
            explode();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide()) {
            explode();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            explode();
        }
    }

    private void explode() {
        Level level = this.level();
        Vec3 pos = this.position();
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.explode(
                    this.getOwner(),
                    pos.x, pos.y, pos.z,
                    2.5f,
                    false,
                    Level.ExplosionInteraction.MOB
            );
            serverLevel.playSound(null, pos.x, pos.y, pos.z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 2.0f, 1.0f);
        }
        this.discard();
    }
}
