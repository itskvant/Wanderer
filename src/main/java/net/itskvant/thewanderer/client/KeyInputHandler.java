package net.itskvant.thewanderer.client;

import net.itskvant.thewanderer.Messages;
import net.itskvant.thewanderer.network.PacketUseWandererRune;
import net.minecraftforge.client.event.InputEvent;

public class KeyInputHandler {

    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.useWandererRuneKeyMapping.consumeClick()) {
            Messages.sendToServer(new PacketUseWandererRune());
        }
    }
}
