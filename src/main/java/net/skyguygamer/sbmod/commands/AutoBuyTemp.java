package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.skyguygamer.sbmod.SbMod;

public final class AutoBuyTemp {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("autobuy").executes(AutoBuyTemp::run));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        if(SbMod.autoBuy) {
            SbMod.autoBuy = false;
            context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto lottery buy has been disabled!"), false);
        } else {
            SbMod.autoBuy = true;
            SbMod.autoBuyTime = 0;
            context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto lottery buy has been enabled!"), false);
            Minecraft.getInstance().player.chatSigned("/lottery buy 2", Component.literal(""));
        }
        return Command.SINGLE_SUCCESS;
    }

}
