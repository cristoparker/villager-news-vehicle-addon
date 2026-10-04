package com.villagernews.entity;

import com.villagernews.init.ModEntities;
import com.villagernews.init.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

public class DaladasPlaneEntity extends VehicleBaseEntity {

    public static final int STATE_STATIONARY = 0;
    public static final int STATE_TAKEOFF = 1;
    public static final int STATE_FLYING = 2;
    public static final int STATE_CRASHING = 3;

    private static final EntityDataAccessor<Integer> DATA_STATE =
            SynchedEntityData.defineId(DaladasPlaneEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_SPEED =
            SynchedEntityData.defineId(DaladasPlaneEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_ROLL =
            SynchedEntityData.defineId(DaladasPlaneEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_MISSILE_CD =
            SynchedEntityData.defineId(DaladasPlaneEntity.class, EntityDataSerializers.INT);

    // Aerodynamic Configuration - Calibrated to 2x Vanilla Vehicles Addon
    public static final float CRUISE_SPEED = 2.2f;      // 158 km/h
    public static final float BOOST_SPEED = 2.7f;       // 194 km/h
    public static final float BRAKE_SPEED = 1.1f;       // 79 km/h
    public static final float MAX_GROUND_SPEED = 0.66f;  // 47 km/h
    public static final float GROUND_ACCEL = 0.014f;
    public static final float ROTATION_SPEED_MIN = 0.35f;

    private int takeoffTicks = 40;
    private int flightImmunityTicks = 0;
    private int trickCooldown = 0;
    private int barrelRollTicks = 0;
    private int barrelRollDir = 0; // -1 = left, 1 = right
    private int missileCooldown = 0;

    private float currentGroundSpeed = 0.0f;
    private float targetRollAngle = 0.0f;
    private float currentRollAngle = 0.0f;

    public DaladasPlaneEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public DaladasPlaneEntity(Level level, double x, double y, double z) {
        super(ModEntities.DALADAS, level);
        this.setPos(x, y, z);
    }

    @Override
    public float maxUpStep() {
        return 1.0f;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_STATE, STATE_STATIONARY);
        builder.define(DATA_SPEED, 0.0f);
        builder.define(DATA_ROLL, 0.0f);
        builder.define(DATA_MISSILE_CD, 0);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.DALADAS_ITEM;
    }

    public int getPlaneState() {
        return this.entityData.get(DATA_STATE);
    }

    public void setPlaneState(int state) {
        this.entityData.set(DATA_STATE, state);
    }

    public float getVisualRoll() {
        return this.entityData.get(DATA_ROLL);
    }

    public float getFlightSpeed() {
        return this.entityData.get(DATA_SPEED);
    }

    @Override
    public void tick() {
        super.tick();

        Level level = this.level();
        LivingEntity driver = this.getControllingPassenger();

        if (this.trickCooldown > 0) this.trickCooldown--;
        if (this.missileCooldown > 0) {
            this.missileCooldown--;
            this.entityData.set(DATA_MISSILE_CD, this.missileCooldown);
        }

        if (!level.isClientSide()) {
            if (driver instanceof ServerPlayer player) {
                Input input = player.getLastClientInput();
                handleFlightPhysics(player, input);
                updateTelemetryHud(player);
            } else {
                handleUnattended();
            }
        }

        // Visual roll interpolation
        this.currentRollAngle = Mth.lerp(0.2f, this.currentRollAngle, this.targetRollAngle);
        this.entityData.set(DATA_ROLL, this.currentRollAngle);
    }

    private void handleFlightPhysics(ServerPlayer player, Input input) {
        int state = getPlaneState();
        Vec3 view = player.getViewVector(1.0f);
        float playerYaw = player.getYRot();
        float playerPitch = player.getXRot();

        if (this.flightImmunityTicks > 0) {
            this.flightImmunityTicks--;
        }

        switch (state) {
            case STATE_STATIONARY -> {
                this.targetRollAngle = 0.0f;
                this.setXRot(0.0f);
                if (input.forward() || input.jump()) {
                    enterTakeoff();
                } else {
                    // Braking to halt
                    this.currentGroundSpeed = Math.max(0.0f, this.currentGroundSpeed - 0.03f);
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
                    this.move(MoverType.SELF, this.getDeltaMovement());
                }
            }
            case STATE_TAKEOFF -> {
                this.targetRollAngle = 0.0f;
                this.setXRot(0.0f);
                if (input.forward() || input.jump()) {
                    this.currentGroundSpeed = Math.min(this.currentGroundSpeed + GROUND_ACCEL, MAX_GROUND_SPEED);

                    // Yaw steering during ground taxi
                    float yawDiff = Mth.wrapDegrees(playerYaw - this.getYRot());
                    this.setYRot(this.getYRot() + yawDiff * 0.15f);

                    float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
                    Vec3 groundMotion = new Vec3(Mth.sin(radYaw) * this.currentGroundSpeed, -0.04, Mth.cos(radYaw) * this.currentGroundSpeed);
                    this.setDeltaMovement(groundMotion);
                    this.move(MoverType.SELF, groundMotion);
                    this.applyRammingCollision(this.currentGroundSpeed, 10.0f, 1.0);

                    this.takeoffTicks--;
                    boolean pullingUp = playerPitch < -6.0f || input.jump();
                    boolean canRotate = this.currentGroundSpeed >= ROTATION_SPEED_MIN && pullingUp;

                    if (this.takeoffTicks <= 0 || canRotate) {
                        enterFlight();
                    }
                } else {
                    setPlaneState(STATE_STATIONARY);
                    this.currentGroundSpeed = 0.0f;
                }
            }
            case STATE_FLYING -> {
                // Airspeed target
                float targetSpeed = CRUISE_SPEED;
                if (input.jump() || input.sprint()) {
                    targetSpeed = BOOST_SPEED; // 194 km/h boost
                } else if (input.backward()) {
                    targetSpeed = BRAKE_SPEED; // 79 km/h airbrake
                }

                // Smooth aerodynamic turning following pilot look
                float yawDiff = Mth.wrapDegrees(playerYaw - this.getYRot());
                float newYaw = this.getYRot() + yawDiff * 0.12f;
                this.setYRot(newYaw);

                // Smooth pitch following pilot look
                float targetPitch = playerPitch * 0.90f;
                float newPitch = Mth.lerp(0.15f, this.getXRot(), targetPitch);
                this.setXRot(newPitch);

                // Aerodynamic Bank Angle (roll follows yaw turn rate)
                if (this.barrelRollTicks > 0) {
                    this.barrelRollTicks--;
                    float progress = 1.0f - ((float) this.barrelRollTicks / 16.0f);
                    this.targetRollAngle = this.barrelRollDir * progress * 360.0f;
                } else {
                    this.targetRollAngle = Mth.clamp(-yawDiff * 1.8f, -45.0f, 45.0f);
                }

                // 3D Aerodynamic Velocity Vector
                float pitchFactor = Math.abs(Mth.sin(this.getXRot() * Mth.DEG_TO_RAD)) * 0.80f;
                float forwardThrust = targetSpeed * (1.0f - pitchFactor * 0.35f);
                float verticalSpeed = -Mth.sin(this.getXRot() * Mth.DEG_TO_RAD) * targetSpeed * 0.60f;

                float radY = -this.getYRot() * Mth.DEG_TO_RAD;
                double vx = Mth.sin(radY) * forwardThrust;
                double vy = verticalSpeed;
                double vz = Mth.cos(radY) * forwardThrust;

                // Lateral barrel roll impulse burst
                if (this.barrelRollTicks > 0) {
                    double lateralVx = Mth.cos(radY) * this.barrelRollDir * 0.5;
                    double lateralVz = -Mth.sin(radY) * this.barrelRollDir * 0.5;
                    vx += lateralVx;
                    vz += lateralVz;
                }

                Vec3 targetFlightMotion = new Vec3(vx, vy, vz);
                this.setDeltaMovement(targetFlightMotion);
                this.move(MoverType.SELF, targetFlightMotion);

                this.entityData.set(DATA_SPEED, (float) targetFlightMotion.horizontalDistance());

                // Ramming collision with airborne mobs / players
                this.applyRammingCollision(targetSpeed, 14.0f, 1.4);

                // High-speed wall/mountain and rough touchdown crash detection
                if (this.flightImmunityTicks <= 0) {
                    if (this.horizontalCollision) {
                        enterCrash();
                        return;
                    }
                    if (this.onGround() || this.isInWater() || this.verticalCollision) {
                        if (playerPitch > 20.0f && this.getDeltaMovement().length() > 0.6) {
                            enterCrash();
                            return;
                        } else if (playerPitch <= 12.0f) {
                            setPlaneState(STATE_STATIONARY);
                            this.currentGroundSpeed = 0.0f;
                            return;
                        }
                    }
                }
            }
            case STATE_CRASHING -> {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.85, 0.95, 0.85).add(0, -0.05, 0));
                this.move(MoverType.SELF, this.getDeltaMovement());
                if (this.level() instanceof ServerLevel sl) {
                    sl.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 4, 0.3, 0.3, 0.3, 0.02);
                }
                if (this.onGround() || this.isInWater()) {
                    setPlaneState(STATE_STATIONARY);
                    this.currentGroundSpeed = 0.0f;
                }
            }
        }
    }

    private void handleUnattended() {
        if (getPlaneState() == STATE_FLYING) {
            // Gently glide down when abandoned midair
            Vec3 vel = this.getDeltaMovement().multiply(0.92, 0.92, 0.92).add(0, -0.04, 0);
            this.setDeltaMovement(vel);
            this.move(MoverType.SELF, vel);
            if (this.onGround() || this.isInWater()) {
                setPlaneState(STATE_STATIONARY);
            }
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
    }

    private void enterTakeoff() {
        setPlaneState(STATE_TAKEOFF);
        this.currentGroundSpeed = 0.08f;
        this.takeoffTicks = 40;
    }

    private void enterFlight() {
        setPlaneState(STATE_FLYING);
        this.flightImmunityTicks = 25;

        // Clean liftoff pop impulse to clear runway
        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        Vec3 liftoffMotion = new Vec3(Mth.sin(radYaw) * 0.6, 0.38, Mth.cos(radYaw) * 0.6);
        this.setDeltaMovement(liftoffMotion);
        this.move(MoverType.SELF, liftoffMotion);

        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.PLAYERS, 1.5f, 0.8f);
    }

    private void enterCrash() {
        setPlaneState(STATE_CRASHING);
        if (this.level() instanceof ServerLevel serverLevel) {
            serverLevel.explode(this, this.getX(), this.getY(), this.getZ(), 2.5f, false, Level.ExplosionInteraction.NONE);
            serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY(), this.getZ(), 30, 0.8, 0.8, 0.8, 0.08);
            serverLevel.sendParticles(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), 20, 0.5, 0.5, 0.5, 0.05);
            serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 2.0f, 0.7f);
        }
        this.ejectPassengers();
    }

    /**
     * Executes barrel roll trick (left or right)
     */
    public void performBarrelRoll(int dir) {
        if (this.trickCooldown > 0 || getPlaneState() != STATE_FLYING) return;
        this.barrelRollDir = dir != 0 ? dir : 1;
        this.barrelRollTicks = 16;
        this.trickCooldown = 30;

        this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.ELYTRA_FLYING, SoundSource.PLAYERS, 1.8f, 1.2f);
    }

    /**
     * Launches Villager Missile from nose cannon
     */
    public void shootMissile() {
        if (this.missileCooldown > 0 || !(this.level() instanceof ServerLevel serverLevel)) return;
        this.missileCooldown = 6;
        this.entityData.set(DATA_MISSILE_CD, this.missileCooldown);

        LivingEntity driver = this.getControllingPassenger();
        Vec3 view = driver != null ? driver.getViewVector(1.0f) : this.getViewVector(1.0f);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        // Nose muzzle position: 8.2 blocks forward, Y + 1.8 blocks
        double spawnX = this.getX() + Mth.sin(radYaw) * 8.2;
        double spawnY = this.getY() + 1.8;
        double spawnZ = this.getZ() + Mth.cos(radYaw) * 8.2;

        VillagerMissileEntity missile = new VillagerMissileEntity(serverLevel, driver, spawnX, spawnY, spawnZ);
        missile.shoot(view.x, view.y, view.z, 4.2f, 0.0f);
        serverLevel.addFreshEntity(missile);

        serverLevel.playSound(null, spawnX, spawnY, spawnZ, SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 2.0f, 0.5f);
        serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, spawnX, spawnY, spawnZ, 12, 0.2, 0.2, 0.2, 0.05);
        serverLevel.sendParticles(ParticleTypes.EXPLOSION, spawnX, spawnY, spawnZ, 1, 0, 0, 0, 0);
    }

    private void updateTelemetryHud(ServerPlayer player) {
        int state = getPlaneState();
        int kmh = Math.round(this.entityData.get(DATA_SPEED) * 72.0f);
        int alt = (int) Math.round(this.getY());
        String rollStatus = this.trickCooldown <= 0 ? "§aREADY" : "§7CD";
        String missileStatus = this.missileCooldown <= 0 ? "§aREADY" : "§7CD";

        Component msg;
        if (state == STATE_FLYING) {
            msg = Component.literal(String.format(
                    "§b✈ DALADAS §f| §7Alt: §f%dm §f| §7Spd: §f%d km/h §f| §6Roll: %s §7(R/Punch) §f| §cMissile: %s §7(Space/Click)",
                    alt, kmh, rollStatus, missileStatus
            ));
        } else if (state == STATE_TAKEOFF) {
            float secsRemaining = Math.max(0.0f, this.takeoffTicks / 20.0f);
            msg = Component.literal(String.format(
                    "§6✈ DALADAS TAXIING §f| §eSpeed: §f%d km/h §f| §aLiftoff in §f%.1fs §7(Hold W or Space)",
                    Math.round(this.currentGroundSpeed * 72.0f), secsRemaining
            ));
        } else {
            msg = Component.literal("§7✈ DALADAS GROUNDED §f| §aHold W or Space to Take Off!");
        }
        player.sendSystemMessage(msg, true); // true = action bar display
    }

    @Override
    public int getMaxPassengers() {
        return 1;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scale) {
        // Bedrock seat position: [0, 0.3, 5]
        Vec3 localPos = new Vec3(0.0, 0.3, 5.0);
        return localPos.xRot(-this.getXRot() * Mth.DEG_TO_RAD).yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }
}
