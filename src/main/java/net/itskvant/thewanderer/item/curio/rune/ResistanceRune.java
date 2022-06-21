package net.itskvant.thewanderer.item.curio.rune;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;
import java.util.UUID;

public class ResistanceRune extends Item implements ICurioItem{
    public ResistanceRune(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {

        Player player = (Player) livingEntity;
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 0,
                false, false));

        ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
        return List.of(
                new TextComponent(""),
                new TranslatableComponent("curios.modifiers.rune"),
                new TranslatableComponent("tooltip.thewanderer.resistance_rune.modifiers")
        );
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }

}
