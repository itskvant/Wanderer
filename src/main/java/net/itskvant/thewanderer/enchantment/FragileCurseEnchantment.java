package net.itskvant.thewanderer.enchantment;

import net.itskvant.thewanderer.TheWanderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

public class FragileCurseEnchantment extends Enchantment {

    public FragileCurseEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Mod.EventBusSubscriber(modid = TheWanderer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class FragileCurseEquipped {

        @SubscribeEvent
        public static void doStuff(final BlockEvent.BreakEvent event) {
            ItemStack itemInHand = event.getPlayer().getItemInHand(InteractionHand.MAIN_HAND);
            Random r = new Random();
            int randInt = r.nextInt(100);
            if (randInt == 0) {
                itemInHand.hurtAndBreak(itemInHand.getDamageValue(), event.getPlayer(), player -> {});
            }
        }
    }
}
