package net.itskvant.thewanderer.sound;

import net.itskvant.thewanderer.TheWanderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheWanderer.MOD_ID);

    public static RegistryObject<SoundEvent> RICKROLL = registerSoundEvent("rickroll");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TheWanderer.MOD_ID, name)));
    }
}
