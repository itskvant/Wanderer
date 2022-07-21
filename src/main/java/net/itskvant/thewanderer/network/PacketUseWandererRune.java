package net.itskvant.thewanderer.network;

import net.itskvant.thewanderer.item.ModItems;
import net.itskvant.thewanderer.item.curio.rune.VoidTeleporter;
import net.itskvant.thewanderer.item.curio.rune.WandererRune;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.Optional;
import java.util.function.Supplier;

public class PacketUseWandererRune {

    public PacketUseWandererRune() {
    }

    public PacketUseWandererRune(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    private int getFreeY(ServerPlayer player) {
        Vec3 pos = player.position();
        boolean f = false;
        for (int i = 0; i < 255; i++) {
            BlockState block = player.getLevel().getBlockState(new BlockPos(pos.x, i, pos.z));
            if (block.isAir()) {
                if (f) {
                    return i;
                }
                f = true;
            } else {
                f = false;
            }
        }
        return (int) pos.y;
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() -> {
            // Here we are server side
            ServerPlayer player = ctx.getSender();
            if (!player.level.isClientSide()) {
                Optional<SlotResult> curio = CuriosApi.getCuriosHelper().findFirstCurio(player, ModItems.WANDERERRUNE.get());
                if (curio.isPresent()) {
                    if (player.level.dimension() == Level.OVERWORLD) {
                        Vec3 pos = player.position();
                        player.changeDimension(player.level.getServer().getLevel(ServerLevel.NETHER), new VoidTeleporter((ServerLevel) player.getLevel()));
                        player.teleportTo(pos.x * 8, pos.y, pos.z * 8);
                    }
                    else if (player.level.dimension() == Level.NETHER) {
                        Vec3 pos = player.position();
                        player.changeDimension(player.level.getServer().getLevel(ServerLevel.OVERWORLD), new VoidTeleporter((ServerLevel) player.getLevel()));
                        player.teleportTo(pos.x * 8, pos.y, pos.z * 8);
                    }
                } else {
                    player.displayClientMessage(new TranslatableComponent("exception.thewanderer.wanderer_rune_not_present"), true);
                }
            }
        });
        return true;
    }
}
