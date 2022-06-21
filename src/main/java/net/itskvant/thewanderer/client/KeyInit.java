package net.itskvant.thewanderer.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.itskvant.thewanderer.TheWanderer;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
    private KeyInit() {

    }

    public static KeyMapping exampleKeyMapping;

    public static void init() {
        exampleKeyMapping = registerKey("wanderer_rune", KeyMapping.CATEGORY_GAMEPLAY, InputConstants.KEY_B);
    }

    private static KeyMapping registerKey(String name, String category, int keycode) {
        final KeyMapping key = new KeyMapping("key." + TheWanderer.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
