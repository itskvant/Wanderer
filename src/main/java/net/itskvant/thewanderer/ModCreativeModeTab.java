package net.itskvant.thewanderer;

import net.itskvant.thewanderer.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab THE_WANDERER_TAB = new CreativeModeTab("thewanderer") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WANDERERRUNE.get());
        }
    };
}
