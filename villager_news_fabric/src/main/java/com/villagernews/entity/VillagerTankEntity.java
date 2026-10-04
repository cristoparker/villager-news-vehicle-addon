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
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.EntityDimensions;
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
        return 1.25f;
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
            if (driver != null) {
                handleDriving(driver);

                // Turret aims where player looks
                this.entityData.set(DATA_TURRET_YAW, getDriverYaw(driver));
                this.entityData.set(DATA_TURRET_PITCH, getDriverPitch(driver));
            } else {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.8, 0.0, 0.8));
                this.move(MoverType.SELF, this.getDeltaMovement());
            }
        }
    }

    private void handleDriving(LivingEntity driver) {
        boolean left = isInputLeft(driver);
        boolean right = isInputRight(driver);
        boolean forward = isInputForward(driver);
        boolean backward = isInputBackward(driver);

        // Turning
        if (left) {
            this.setYRot(this.getYRot() - 3.0f);
        } else if (right) {
            this.setYRot(this.getYRot() + 3.0f);
        }

        // Throttle
        float targetSpeed = 0.0f;
        if (forward) {
            targetSpeed = 0.42f;
        } else if (backward) {
            targetSpeed = -0.25f;
        }

        this.driveSpeed = Mth.lerp(0.2f, this.driveSpeed, targetSpeed);

        float radYaw = -this.getYRot() * Mth.DEG_TO_RAD;
        double vx = Mth.sin(radYaw) * this.driveSpeed;
        double vz = Mth.cos(radYaw) * this.driveSpeed;

        Vec3 motion = new Vec3(vx, this.onGround() ? 0.0 : -0.15, vz);
        this.setDeltaMovement(motion);
        this.move(MoverType.SELF, motion);

        // Ramming and crushing obstacles
        if (Math.abs(this.driveSpeed) > 0.08) {
            this.applyRammingCollision(this.driveSpeed, 24.0f, 1.6);
            if (this.level() instanceof ServerLevel serverLevel) {
                crushFoliageInPath(serverLevel, vx, vz);
            }
        }
    }

    /**
     * Heavy caterpillar tracks crush soft vegetation and obstacles
     */
    private void crushFoliageInPath(ServerLevel serverLevel, double vx, double vz) {
        AABB trackBox = this.getBoundingBox().inflate(0.2, 0.1, 0.2).expandTowards(vx * 1.2, 0.0, vz * 1.2);
        BlockPos minPos = BlockPos.containing(trackBox.minX, trackBox.minY, trackBox.minZ);
        BlockPos maxPos = BlockPos.containing(trackBox.maxX, trackBox.minY + 1.2, trackBox.maxZ);

        for (BlockPos pos : BlockPos.betweenClosed(minPos, maxPos)) {
            BlockState state = serverLevel.getBlockState(pos);
            if (isCrushable(state)) {
                serverLevel.destroyBlock(pos, true, this);
            }
        }
    }

    private static boolean isCrushable(BlockState state) {
        if (state.isAir()) return false;
        return state.is(BlockTags.LEAVES)
                || state.is(BlockTags.CROPS)
                || state.is(BlockTags.FLOWERS)
                || state.is(BlockTags.SAPLINGS)
                || state.is(BlockTags.BAMBOO_BLOCKS)
                || state.is(Blocks.SHORT_GRASS)
                || state.is(Blocks.TALL_GRASS)
                || state.is(Blocks.FERN)
                || state.is(Blocks.LARGE_FERN)
                || state.is(Blocks.BAMBOO)
                || state.is(Blocks.COBWEB)
                || state.is(Blocks.VINE)
                || state.is(Blocks.SUGAR_CANE)
                || state.is(Blocks.SWEET_BERRY_BUSH);
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
    public int getMaxPassengers() {
        return 1;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity passenger, EntityDimensions dimensions, float scale) {
        // Bedrock seat position: [0, 3.7, 3.3]
        return new Vec3(0.0, 3.7, 3.3).yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }
}
