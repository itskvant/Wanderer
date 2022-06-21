package net.itskvant.thewanderer.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_VOLUB =
            (new FoodProperties.Builder())
                    .nutrition(3).saturationMod(0.3F)
                    .meat()
                    .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.5F)
                    .build();
    public static final FoodProperties COOKED_VOLUB =
            (new FoodProperties.Builder())
                    .nutrition(5)
                    .saturationMod(0.3F)
                    .meat()
                    .build();

}
