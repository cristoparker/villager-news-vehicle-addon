package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class VillagerFirefighterEntity extends VehicleBaseEntity {

    // Synced so the client renderer can animate the wheels
    private static final EntityDataAccessor<Float> DATA_DRIVE_SPEED =
            SynchedEntityData.defineId(VillagerFirefighterEntity.class, EntityDataSerializers.FLOAT);

    private float driveSpeed = 0.0f;
    private int sprayCooldown = 0;

    public VillagerFirefighterEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public VillagerFirefighterEntity(Level level, double x, double y, double z) {
        super(ModEntities.FIREFIGHTER, level);
        this.setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_DRIVE_SPEED, 0.0f);
    }

    /** Client-readable drive speed for wheel animation. */
    public float getDriveSpeed() {
        return this.entityData.get(DATA_DRIVE_SPEED);
    }

    @Override
    public float maxUpStep() {
        return 1.25f;
    }

    @Override
    protected Item getDropItem() {
        return ModItems.FIREFIGHTER_ITEM;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.sprayCooldown > 0) this.sprayCooldown--;

        LivingEntity driver = this.getControllingPassenger();
        Level level = this.level();

        if (!level.isClientSide()) {
            if (driver != null) {
                handleDriving(driver);
            } else {
                this.driveSpeed = Mth.lerp(0.2f, this.driveSpeed, 0.0f);
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
                this.move(MoverType.SELF, this.getDeltaMovement());
            }
            // Keep client in sync for wheel animation
            this.entityData.set(DATA_DRIVE_SPEED, this.driveSpeed);
        }
    }

    private void handleDriving(LivingEntity driver) {
        boolean left = isInputLeft(driver);
        boolean right = isInputRight(driver);
        boolean forward = isInputForward(driver);
        boolean backward = isInputBackward(driver);

        if (left) {
            this.setYRot(this.getYRot() - 3.5f);
        } else if (right) {
            this.setYRot(this.getYRot() + 3.5f);
        } else {
            // Also steer towards player look direction if turning head significantly
            float playerYaw = getDriverYaw(driver);
            float diff = Mth.wrapDegrees(playerYaw - this.getYRot());
            if (Math.abs(diff) > 35.0f && Math.abs(this.driveSpeed) > 0.05f) {
                this.setYRot(this.getYRot() + Math.signum(diff) * 2.2f);
            }
        }

        float targetSpeed = 0.0f;
        if (forward) {
            targetSpeed = 0.52f; // Fast emergency truck speed
        } else if (backward) {
            targetSpeed = -0.25f;
        }

        this.driveSpeed = Mth.lerp(0.25f, this.driveSpeed, targetSpeed);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        double vx = Mth.sin(radYaw) * this.driveSpeed;
        double vz = Mth.cos(radYaw) * this.driveSpeed;

        Vec3 motion = new Vec3(vx, this.onGround() ? 0.0 : -0.15, vz);
        this.setDeltaMovement(motion);
        this.move(MoverType.SELF, motion);

        // Emergency truck ramming collision
        if (Math.abs(this.driveSpeed) > 0.08) {
            this.applyRammingCollision(this.driveSpeed, 18.0f, 1.4);
        }
    }

    /**
     * Sprays water cannon forward, extinguishing fires and cooling lava
     */
    public void sprayWater() {
        if (this.sprayCooldown > 0 || !(this.level() instanceof ServerLevel serverLevel)) return;
        this.sprayCooldown = 2; // Continuous stream

        LivingEntity driver = this.getControllingPassenger();
        Vec3 view = driver != null ? driver.getViewVector(1.0f) : this.getViewVector(1.0f);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        double sprayX = this.getX() + Mth.sin(radYaw) * 2.5;
        double sprayY = this.getY() + 1.6;
        double sprayZ = this.getZ() + Mth.cos(radYaw) * 2.5;

        // Particle stream
        for (int i = 0; i < 15; i++) {
            double spreadX = (this.random.nextDouble() - 0.5) * 0.4;
            double spreadY = (this.random.nextDouble() - 0.5) * 0.4;
            double spreadZ = (this.random.nextDouble() - 0.5) * 0.4;
            double velX = view.x * 1.5 + spreadX;
            double velY = view.y * 1.5 + spreadY + 0.1;
            double velZ = view.z * 1.5 + spreadZ;

            serverLevel.sendParticles(ParticleTypes.SPLASH, sprayX, sprayY, sprayZ, 1, velX, velY, velZ, 0.2);
            serverLevel.sendParticles(ParticleTypes.FALLING_WATER, sprayX, sprayY, sprayZ, 1, velX, velY, velZ, 0.2);
        }

        serverLevel.playSound(null, sprayX, sprayY, sprayZ, SoundEvents.GENERIC_SPLASH, SoundSource.PLAYERS, 1.2f, 1.4f);

        // Extinguish fires, cool blocks, and hydraulic blast push in line of fire
        for (int dist = 1; dist <= 9; dist++) {
            BlockPos targetPos = BlockPos.containing(sprayX + view.x * dist, sprayY + view.y * dist, sprayZ + view.z * dist);
            if (serverLevel.getBlockState(targetPos).is(Blocks.FIRE) || serverLevel.getBlockState(targetPos).is(Blocks.SOUL_FIRE)) {
                serverLevel.removeBlock(targetPos, false);
            }
            AABB area = new AABB(targetPos).inflate(1.2);
            List<Entity> nearby = serverLevel.getEntities(this, area, e ->
                    !this.isPassengerOfSameVehicle(e) && e.isAlive() && !e.isSpectator());
            for (Entity e : nearby) {
                // Hydraulic push
                e.push(view.x * 0.35, 0.12, view.z * 0.35);

                if (e.isOnFire()) {
                    e.clearFire();
                }
                if (e instanceof LivingEntity living && (living.getType().getDescriptionId().contains("blaze") || living.getType().getDescriptionId().contains("magma"))) {
                    living.hurtServer(serverLevel, serverLevel.damageSources().drown(), 5.0f);
                }
            }
        }
    }

    @Override
    public int getMaxPassengers() {
        return 1;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scale) {
        // Bedrock seat position: [0, 4.1, 4.5]
        return new Vec3(0.0, 4.1, 4.5).yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }
}
