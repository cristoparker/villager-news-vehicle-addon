package com.villagernews.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record VehicleActionPayload(int action, int param) implements CustomPacketPayload {

    public static final int ACTION_BARREL_ROLL = 1;
    public static final int ACTION_SHOOT_MISSILE = 2;
    public static final int ACTION_SPRAY_WATER = 3;

    public static final Type<VehicleActionPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath("renderphoenix", "vehicle_action"));

    public static final StreamCodec<RegistryFriendlyByteBuf, VehicleActionPayload> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, VehicleActionPayload::action,
            ByteBufCodecs.VAR_INT, VehicleActionPayload::param,
            VehicleActionPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
