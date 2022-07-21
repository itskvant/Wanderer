package net.itskvant.thewanderer.item;

import net.itskvant.thewanderer.ModCreativeModeTab;
import net.itskvant.thewanderer.TheWanderer;
import net.itskvant.thewanderer.item.curio.rune.*;
import net.itskvant.thewanderer.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheWanderer.MOD_ID);

    public static final RegistryObject<Item> SPEEDRUNE = ITEMS.register("speed_rune", () -> new SpeedRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> HEALTHRUNE = ITEMS.register("health_rune", () -> new HealthRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> LUCKRUNE = ITEMS.register("luck_rune", () -> new LuckRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> RESISTANCERUNE = ITEMS.register("resistance_rune", () -> new ResistanceRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> STRENGTHRUNE = ITEMS.register("strength_rune", () -> new StrengthRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));
    public static final RegistryObject<Item> WANDERERRUNE = ITEMS.register("wanderer_rune", () -> new WandererRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> RICKROLL_MUSIC_DICS = ITEMS.register("rickroll_music_disc", () -> new RecordItem(4, ModSounds.RICKROLL, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
