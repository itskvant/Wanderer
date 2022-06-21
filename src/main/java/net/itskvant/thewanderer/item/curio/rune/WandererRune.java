package net.itskvant.thewanderer.item.curio.rune;

import com.google.common.collect.Multimap;
import net.itskvant.thewanderer.client.KeyInit;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import org.apache.logging.log4j.core.jmx.Server;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


public class WandererRune extends Item implements  ICurioItem {

    public WandererRune(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
        return List.of(
                new TextComponent(""),
                new TranslatableComponent("curios.modifiers.rune"),
                new TranslatableComponent("tooltip.thewanderer.wanderer_rune.modifiers_1"),
                new TranslatableComponent("tooltip.thewanderer.wanderer_rune.modifiers_2")
        );
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        if (!(livingEntity instanceof Player player)) return;
        if (!player.level.isClientSide()){
            if (KeyInit.exampleKeyMapping.consumeClick()) {
                if (player.level.dimension() == Level.OVERWORLD) {
                    Vec3 pos = player.position();
                    player.changeDimension(player.level.getServer().getLevel(ServerLevel.NETHER), new VoidTeleporter((ServerLevel) player.getLevel()));
                    player.teleportTo(pos.x/8, pos.y, pos.z/8);
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 200, false, false));
                }
                else if (player.level.dimension() == Level.NETHER) {
                    Vec3 pos = player.position();
                    player.changeDimension(player.level.getServer().getLevel(ServerLevel.OVERWORLD), new VoidTeleporter((ServerLevel) player.getLevel()));
                    player.teleportTo(pos.x*8, pos.y, pos.z*8);
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 200, false, false));
                }
            }
        }

        ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
    }

    @NotNull
    @Override
    public ICurio.DropRule getDropRule(SlotContext slotContext, DamageSource source, int lootingLevel, boolean recentlyHit, ItemStack stack) {
        return ICurio.DropRule.ALWAYS_KEEP;
    }

    @Override
    public boolean canRightClickEquip(ItemStack stack) {
        return true;
    }
}
