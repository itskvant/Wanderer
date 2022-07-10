package net.itskvant.thewanderer.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBindings {

    public static final String KEY_ACTIVATE_WANDERER_RUNE = "key.thewanderer.wanderer_rune";

    public static KeyMapping useWandererRuneKeyMapping;

    public static void init() {
        useWandererRuneKeyMapping = new KeyMapping(KEY_ACTIVATE_WANDERER_RUNE, KeyConflictContext.IN_GAME, InputConstants.getKey("key.keyboard.period"), KeyMapping.CATEGORY_GAMEPLAY);
        ClientRegistry.registerKeyBinding(useWandererRuneKeyMapping);
    }
}
