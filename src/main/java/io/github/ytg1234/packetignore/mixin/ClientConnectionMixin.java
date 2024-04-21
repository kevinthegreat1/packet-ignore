package io.github.ytg1234.packetignore.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.CustomPayloadC2SPacket;
import net.minecraft.network.packet.c2s.config.ReadyC2SPacket;
import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;
import net.minecraft.network.packet.c2s.login.EnterConfigurationC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginHelloC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginKeyC2SPacket;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
    @Shadow
    @Final
    private NetworkSide side;

    @Unique
    private final Random random = new Random();

    @WrapWithCondition(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/packet/Packet;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/ClientConnection;handlePacket(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/listener/PacketListener;)V"))
    private boolean packetignore_ignorePackets(Packet<?> packet, PacketListener listener) {
        return side == NetworkSide.CLIENTBOUND || packet instanceof HandshakeC2SPacket || packet instanceof LoginHelloC2SPacket || packet instanceof LoginKeyC2SPacket || packet instanceof LoginQueryResponseC2SPacket || packet instanceof EnterConfigurationC2SPacket || packet instanceof CustomPayloadC2SPacket || packet instanceof ReadyC2SPacket || random.nextBoolean();
    }
}
