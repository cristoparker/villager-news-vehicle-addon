package com.villagernews.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record VehicleInputPayload(
        boolean forward,
        boolean backward,
        boolean left,
        boolean right,
        boolean jump,
        boolean shift,
        boolean sprint,
        float playerYaw,
        float playerPitch
) implements CustomPacketPayload {

    public static final Type<VehicleInputPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath("renderphoenix", "vehicle_input"));

    public static final StreamCodec<RegistryFriendlyByteBuf, VehicleInputPayload> CODEC = StreamCodec.of(
            (buf, val) -> {
                buf.writeBoolean(val.forward());
                buf.writeBoolean(val.backward());
                buf.writeBoolean(val.left());
                buf.writeBoolean(val.right());
                buf.writeBoolean(val.jump());
                buf.writeBoolean(val.shift());
                buf.writeBoolean(val.sprint());
                buf.writeFloat(val.playerYaw());
                buf.writeFloat(val.playerPitch());
            },
            buf -> new VehicleInputPayload(
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readBoolean(),
                    buf.readFloat(),
                    buf.readFloat()
            )
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
