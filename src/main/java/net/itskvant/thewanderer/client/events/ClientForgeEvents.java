package net.itskvant.thewanderer.client.events;

import net.itskvant.thewanderer.TheWanderer;
import net.itskvant.thewanderer.client.KeyInit;
import net.itskvant.thewanderer.item.ModItems;
import net.itskvant.thewanderer.item.curio.rune.VoidTeleporter;
import net.itskvant.thewanderer.item.curio.rune.WandererRune;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = TheWanderer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientForgeEvents {

    private ClientForgeEvents() {
    }

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {


//        LazyOptional<IItemHandlerModifiable> curios = CuriosApi.getCuriosHelper().getEquippedCurios(player);
//        boolean isWandererRuneEquipped = curios.filter()
//        if (KeyInit.exampleKeyMapping.isDown()) {
//            Minecraft.getInstance().player.displayClientMessage(new TextComponent("hello"), true);
//        }
    }
}
