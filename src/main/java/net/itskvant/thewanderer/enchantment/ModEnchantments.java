package net.itskvant.thewanderer.enchantment;

import net.itskvant.thewanderer.TheWanderer;
import net.itskvant.thewanderer.enchantment.FragileCurseEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheWanderer.MOD_ID);

    public static RegistryObject<Enchantment> FRAGILE_CURSE =
            ENCHANTMENTS.register("fragile_curse",
                    () -> new FragileCurseEnchantment(Enchantment.Rarity.UNCOMMON,
                            EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
