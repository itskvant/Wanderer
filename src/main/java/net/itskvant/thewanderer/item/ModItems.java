package net.itskvant.thewanderer.item;

import net.itskvant.thewanderer.ModCreativeModeTab;
import net.itskvant.thewanderer.TheWanderer;
import net.itskvant.thewanderer.item.curio.rune.*;
import net.itskvant.thewanderer.item.custom.TeleporterItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheWanderer.MOD_ID);

//    public static final RegistryObject<Item> TELEPORTER = ITEMS.register("teleporter",
//            () -> new TeleporterItem(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB)));

    public static final RegistryObject<Item> SPEEDRUNE = ITEMS.register("speed_rune",
            () -> new SpeedRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> HEALTHRUNE = ITEMS.register("health_rune",
            () -> new HealthRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> LUCKRUNE = ITEMS.register("luck_rune",
            () -> new LuckRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> RESISTANCERUNE = ITEMS.register("resistance_rune",
            () -> new ResistanceRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> STRENGTHRUNE = ITEMS.register("strength_rune",
            () -> new StrengthRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).stacksTo(1)));

    public static final RegistryObject<Item> WANDERERRUNE = ITEMS.register("wanderer_rune",
            () -> new WandererRune(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).rarity(Rarity.EPIC).stacksTo(1)));

//    public static final RegistryObject<Item> RAWVOLUB = ITEMS.register("raw_volub",
//            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).food(ModFoods.RAW_VOLUB)));
//
//    public static final RegistryObject<Item> COOKEDVOLUB = ITEMS.register("cooked_volub",
//            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.THE_WANDERER_TAB).food(ModFoods.COOKED_VOLUB)));
//

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
