package net.itskvant.thewanderer;

import net.itskvant.thewanderer.network.PacketUseWandererRune;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {return packetId++;}

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(TheWanderer.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PacketUseWandererRune.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketUseWandererRune::new)
                .encoder(PacketUseWandererRune::toBytes)
                .consumer(PacketUseWandererRune::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

}
