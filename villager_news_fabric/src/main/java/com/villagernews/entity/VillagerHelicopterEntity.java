package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

public class VillagerHelicopterEntity extends VehicleBaseEntity {

    private static final EntityDataAccessor<Boolean> DATA_FLYING =
            SynchedEntityData.defineId(VillagerHelicopterEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DATA_PITCH_TILT =
            SynchedEntityData.defineId(VillagerHelicopterEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_ROLL_TILT =
            SynchedEntityData.defineId(VillagerHelicopterEntity.class, EntityDataSerializers.FLOAT);

    public static final float MAX_HORIZONTAL_SPEED = 0.82f;
    public static final float MAX_STRAFE_SPEED = 0.62f;
    public static final float MAX_ASCEND_SPEED = 0.52f;
    public static final float MAX_DESCEND_SPEED = -0.38f;

    private float currentVx = 0.0f;
    private float currentVz = 0.0f;
    private float currentVy = 0.0f;
    private float targetPitchTilt = 0.0f;
    private float targetRollTilt = 0.0f;
    private int tickCounter = 0;

    public VillagerHelicopterEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public VillagerHelicopterEntity(Level level, double x, double y, double z) {
        super(ModEntities.HELICOPTER, level);
        this.setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLYING, false);
        builder.define(DATA_PITCH_TILT, 0.0f);
        builder.define(DATA_ROLL_TILT, 0.0f);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.HELICOPTER_ITEM;
    }

    public boolean isFlying() {
        return this.entityData.get(DATA_FLYING);
    }

    public float getPitchTilt() {
        return this.entityData.get(DATA_PITCH_TILT);
    }

    public float getRollTilt() {
        return this.entityData.get(DATA_ROLL_TILT);
    }

    @Override
    public int getMaxPassengers() {
        return 1;
    }

    @Override
    public void tick() {
        super.tick();
        this.tickCounter++;

        LivingEntity driver = this.getControllingPassenger();
        Level level = this.level();

        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            detectRotorCollisions(serverLevel);
            if (driver instanceof ServerPlayer player) {
                Input input = player.getLastClientInput();
                handleFlight(player, input);
            } else {
                handleUnattended();
            }
        }
    }

    private void handleFlight(ServerPlayer player, Input input) {
        boolean onGround = this.onGround() || this.isInWater();
        float playerYaw = player.getYRot();
        float yawDiff = Mth.wrapDegrees(playerYaw - this.getYRot());
        this.setYRot(this.getYRot() + yawDiff * 0.18f);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        float fx = Mth.sin(radYaw);
        float fz = Mth.cos(radYaw);
        float rx = Mth.cos(radYaw);
        float rz = -Mth.sin(radYaw);

        boolean wantsAscend = input.jump();
        boolean wantsDescend = input.shift() || player.getXRot() > 35.0f;
        boolean wantsTakeoff = wantsAscend || input.forward();

        if (!isFlying()) {
            this.targetPitchTilt = 0.0f;
            this.targetRollTilt = 0.0f;
            if (wantsTakeoff) {
                this.entityData.set(DATA_FLYING, true);
                this.currentVy = 0.32f;
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
                this.move(MoverType.SELF, this.getDeltaMovement());
                syncTilt();
                return;
            }
        }

        // 1. Vertical Collective (Ascend / Descend / Hover)
        if (wantsAscend) {
            this.currentVy = Math.min(this.currentVy + 0.06f, MAX_ASCEND_SPEED);
        } else if (wantsDescend) {
            this.currentVy = Math.max(this.currentVy - 0.06f, MAX_DESCEND_SPEED);
        } else {
            this.currentVy *= 0.88f;
            if (Math.abs(this.currentVy) < 0.02f) {
                // Subtle hover micro-bobbing
                this.currentVy = Mth.sin(this.tickCounter * 0.15f) * 0.02f;
            }
        }

        // 2. Cyclic Horizontal Flight (WASD)
        float forwardInput = (input.forward() ? 1.0f : 0.0f) - (input.backward() ? 1.0f : 0.0f);
        float strafeInput = (input.right() ? 1.0f : 0.0f) - (input.left() ? 1.0f : 0.0f);

        double targetVx = (fx * forwardInput * MAX_HORIZONTAL_SPEED) + (rx * strafeInput * MAX_STRAFE_SPEED);
        double targetVz = (fz * forwardInput * MAX_HORIZONTAL_SPEED) + (rz * strafeInput * MAX_STRAFE_SPEED);

        this.currentVx = (float) Mth.lerp(0.22, this.currentVx, targetVx);
        this.currentVz = (float) Mth.lerp(0.22, this.currentVz, targetVz);

        // 3. Tilts
        if (forwardInput > 0.1f) {
            this.targetPitchTilt = 20.0f; // Nose down
        } else if (forwardInput < -0.1f) {
            this.targetPitchTilt = -16.0f; // Nose up
        } else {
            this.targetPitchTilt = 0.0f;
        }

        if (strafeInput > 0.1f) {
            this.targetRollTilt = 16.0f; // Bank right
        } else if (strafeInput < -0.1f) {
            this.targetRollTilt = -16.0f; // Bank left
        } else {
            this.targetRollTilt = 0.0f;
        }

        syncTilt();

        // 4. Apply flight movement
        Vec3 motion = new Vec3(this.currentVx, this.currentVy, this.currentVz);
        this.setDeltaMovement(motion);
        this.move(MoverType.SELF, motion);

        // Collision ramming
        double hSpeed = Math.sqrt(this.currentVx * this.currentVx + this.currentVz * this.currentVz);
        if (hSpeed > 0.18) {
            this.applyRammingCollision(hSpeed, 12.0f, 1.2);
        }

        // Wall collision response (recoil & shield block sound)
        if (isFlying() && this.horizontalCollision) {
            this.currentVx *= -0.3f;
            this.currentVz *= -0.3f;
            if (this.level() instanceof ServerLevel sl) {
                sl.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.8f);
            }
        }

        // Hard landing impact detection
        if ((onGround || this.verticalCollision) && this.currentVy < -0.28f && this.level() instanceof ServerLevel sl) {
            sl.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.2f, 0.85f);
            sl.sendParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 20, 1.0, 0.1, 1.0, 0.05);
        }

        // 5. Landing detection
        if (onGround && this.currentVy <= 0.05f && !wantsAscend && forwardInput == 0 && strafeInput == 0) {
            this.entityData.set(DATA_FLYING, false);
            this.currentVx = 0.0f;
            this.currentVz = 0.0f;
            this.currentVy = 0.0f;
        }
    }

    /**
     * Slices any entities touching the high-speed overhead rotor blades
     */
    private void detectRotorCollisions(ServerLevel serverLevel) {
        if (!isFlying()) return;

        AABB rotorBox = new AABB(
                this.getX() - 3.2, this.getY() + 3.0, this.getZ() - 3.2,
                this.getX() + 3.2, this.getY() + 4.4, this.getZ() + 3.2
        );

        java.util.List<LivingEntity> inRotor = serverLevel.getEntitiesOfClass(
                LivingEntity.class,
                rotorBox,
                e -> !this.isPassengerOfSameVehicle(e) && e.isAlive() && !e.isSpectator()
        );

        for (LivingEntity victim : inRotor) {
            double dx = victim.getX() - this.getX();
            double dz = victim.getZ() - this.getZ();
            double dist = Math.sqrt(dx * dx + dz * dz);
            if (dist < 3.2) {
                DamageSource source = this.getControllingPassenger() != null
                        ? serverLevel.damageSources().mobAttack(this.getControllingPassenger())
                        : serverLevel.damageSources().generic();
                victim.hurtServer(serverLevel, source, 12.0f);
                double pushX = dist > 0.01 ? (dx / dist) * 1.2 : 0.6;
                double pushZ = dist > 0.01 ? (dz / dist) * 1.2 : 0.6;
                victim.push(pushX, 0.35, pushZ);
                serverLevel.sendParticles(ParticleTypes.SWEEP_ATTACK, victim.getX(), victim.getY() + 0.5, victim.getZ(), 3, 0.2, 0.2, 0.2, 0.0);
                serverLevel.playSound(null, victim.getX(), victim.getY(), victim.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.5f, 1.2f);
            }
        }
    }

    private void syncTilt() {
        float curP = this.entityData.get(DATA_PITCH_TILT);
        float curR = this.entityData.get(DATA_ROLL_TILT);
        this.entityData.set(DATA_PITCH_TILT, Mth.lerp(0.18f, curP, this.targetPitchTilt));
        this.entityData.set(DATA_ROLL_TILT, Mth.lerp(0.18f, curR, this.targetRollTilt));
    }

    private void handleUnattended() {
        if (isFlying()) {
            this.currentVx *= 0.9f;
            this.currentVz *= 0.9f;
            this.currentVy = Math.max(this.currentVy - 0.04f, -0.3f);
            Vec3 motion = new Vec3(this.currentVx, this.currentVy, this.currentVz);
            this.setDeltaMovement(motion);
            this.move(MoverType.SELF, motion);
            if (this.onGround() || this.isInWater()) {
                this.entityData.set(DATA_FLYING, false);
            }
        }
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scale) {
        // Bedrock seat position: [0, 0.5, -0.6]
        return new Vec3(0.0, 0.5, -0.6).yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }
}
