package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.skyguygamer.sbmod.SbMod;

import static net.skyguygamer.sbmod.SbMod.ticketAmount;

public final class AutoBuyTemp {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("autobuy").executes(AutoBuyTemp::run)
                .then(Commands.argument("tickets", IntegerArgumentType.integer(1, 5)).executes(AutoBuyTemp -> customAmount(AutoBuyTemp.getSource(),
                        IntegerArgumentType.getInteger(AutoBuyTemp, "tickets")))));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        if(SbMod.autoBuy) {
            SbMod.autoBuy = false;
            context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto lottery buy has been disabled!"), false);
        } else {
            SbMod.autoBuy = true;
            SbMod.autoBuyTime = 0;
            ticketAmount = 2;
            context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto lottery buy has been enabled!"), false);
            Minecraft.getInstance().player.chatSigned("/lottery buy 2", Component.literal(""));
        }
        return Command.SINGLE_SUCCESS;
    }
    private static int customAmount(CommandSourceStack source, int tickets) {
        SbMod.autoBuy = true;
        SbMod.autoBuyTime = 0;
        ticketAmount = tickets;
        source.sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto lottery buy has been enabled!"), false);
        Minecraft.getInstance().player.chatSigned("/lottery buy " + ticketAmount, Component.literal(""));
        return Command.SINGLE_SUCCESS;
    }

}
