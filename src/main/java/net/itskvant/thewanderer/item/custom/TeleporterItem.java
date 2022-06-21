package net.itskvant.thewanderer.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class TeleporterItem extends Item {
    public TeleporterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(!pLevel.isClientSide()) {
            ResourceKey<Level> dimension = pPlayer.level.dimension();
            if(dimension == Level.OVERWORLD){
                ServerLevel nether = pLevel.getServer().getLevel(ServerLevel.NETHER);
                if (nether != null) {
                    pPlayer.changeDimension(nether);
                    pPlayer.teleportTo(0, 70, 0);
                }
            }
            else if(dimension == Level.NETHER) {
                ServerLevel overworld = pPlayer.getServer().getLevel(Level.OVERWORLD);
                if (overworld != null) {
                    pPlayer.changeDimension(overworld);
                    pPlayer.teleportTo(0, 70, 0);
                }
            }
            pPlayer.sendMessage(new TranslatableComponent("notification.thewanderer.to_overworld"), pPlayer.getUUID());
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.thewanderer.teleporter.tooltip"));
    }
}