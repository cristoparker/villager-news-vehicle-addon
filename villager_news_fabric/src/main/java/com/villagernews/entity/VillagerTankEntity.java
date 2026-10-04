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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VillagerTankEntity extends VehicleBaseEntity {

    private static final EntityDataAccessor<Float> DATA_TURRET_YAW =
            SynchedEntityData.defineId(VillagerTankEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_TURRET_PITCH =
            SynchedEntityData.defineId(VillagerTankEntity.class, EntityDataSerializers.FLOAT);

    private int cannonCooldown = 0;
    private float driveSpeed = 0.0f;

    public VillagerTankEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public VillagerTankEntity(Level level, double x, double y, double z) {
        super(ModEntities.TANK, level);
        this.setPos(x, y, z);
    }

    @Override
    public float maxUpStep() {
        return 1.0f;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_TURRET_YAW, 0.0f);
        builder.define(DATA_TURRET_PITCH, 0.0f);
    }

    @Override
    protected Item getDropItem() {
        return ModItems.TANK_ITEM;
    }

    public float getTurretYaw() {
        return this.entityData.get(DATA_TURRET_YAW);
    }

    public float getTurretPitch() {
        return this.entityData.get(DATA_TURRET_PITCH);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.cannonCooldown > 0) this.cannonCooldown--;

        LivingEntity driver = this.getControllingPassenger();
        Level level = this.level();

        if (!level.isClientSide()) {
            if (driver instanceof ServerPlayer player) {
                Input input = player.getLastClientInput();
                handleDriving(player, input);

                // Turret aims where player looks
                this.entityData.set(DATA_TURRET_YAW, player.getYRot());
                this.entityData.set(DATA_TURRET_PITCH, player.getXRot());
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
                this.move(MoverType.SELF, this.getDeltaMovement());
            }
        }
    }

    private void handleDriving(ServerPlayer player, Input input) {
        // Turning
        if (input.left()) {
            this.setYRot(this.getYRot() - 2.8f);
        } else if (input.right()) {
            this.setYRot(this.getYRot() + 2.8f);
        }

        // Throttle
        float targetSpeed = 0.0f;
        if (input.forward()) {
            targetSpeed = 0.36f;
        } else if (input.backward()) {
            targetSpeed = -0.22f;
        }

        this.driveSpeed = Mth.lerp(0.2f, this.driveSpeed, targetSpeed);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        double vx = Mth.sin(radYaw) * this.driveSpeed;
        double vz = Mth.cos(radYaw) * this.driveSpeed;

        Vec3 motion = new Vec3(vx, this.onGround() ? 0.0 : -0.08, vz);
        this.setDeltaMovement(motion);
        this.move(MoverType.SELF, motion);
    }

    /**
     * Fires missile from head21 cannon tip with sound, recoil, and smoke blast
     */
    public void shootCannon() {
        if (this.cannonCooldown > 0 || !(this.level() instanceof ServerLevel serverLevel)) return;
        this.cannonCooldown = 15; // 0.75s reload cooldown

        LivingEntity driver = this.getControllingPassenger();
        Vec3 view = driver != null ? driver.getViewVector(1.0f) : this.getViewVector(1.0f);

        // Muzzle position at head21 bone: forward 4.15 blocks, Y + 3.88 blocks
        float radTurretYaw = -(driver != null ? driver.getYRot() : this.getYRot()) * Mth.DEG_TO_RAD;
        double muzzleX = this.getX() + Mth.sin(radTurretYaw) * 4.15;
        double muzzleY = this.getY() + 3.2;
        double muzzleZ = this.getZ() + Mth.cos(radTurretYaw) * 4.15;

        VillagerMissileEntity missile = new VillagerMissileEntity(serverLevel, driver, muzzleX, muzzleY, muzzleZ);
        missile.shoot(view.x, view.y, view.z, 3.8f, 0.0f);
        serverLevel.addFreshEntity(missile);

        // Recoil push
        double recoilStrength = -0.25;
        this.setDeltaMovement(this.getDeltaMovement().add(Mth.sin(radTurretYaw) * recoilStrength, 0, Mth.cos(radTurretYaw) * recoilStrength));

        serverLevel.playSound(null, muzzleX, muzzleY, muzzleZ, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 2.0f, 0.8f);
        serverLevel.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, muzzleX, muzzleY, muzzleZ, 20, 0.3, 0.3, 0.3, 0.08);
        serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, muzzleX, muzzleY, muzzleZ, 1, 0, 0, 0, 0);
    }

    @Override
    protected void positionRider(Entity passenger, Entity.MoveFunction callback) {
        if (!this.hasPassenger(passenger)) return;

        // Pilot hatch position on top of the hull
        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        double offsetX = -Mth.sin(radYaw) * 0.4;
        double offsetZ = -Mth.cos(radYaw) * 0.4;

        callback.accept(passenger, this.getX() + offsetX, this.getY() + 2.2, this.getZ() + offsetZ);
    }
}
