package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class Divide64 {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("64").then(Commands.argument("amount", IntegerArgumentType.integer())
                .executes(Divide64 -> run(Divide64.getSource(),
                        IntegerArgumentType.getInteger(Divide64, "amount")
                ))));
    }

    private static int run(CommandSourceStack source, double amount) {
         double total = amount/64;
         double remainder = amount%64;
         source.sendSuccess(((Component.translatable(ChatFormatting.RED + " - " + ChatFormatting.GREEN + String.format("%.0f", amount) + " / 64"  + " = " + ChatFormatting.WHITE + String.format("%.2f", total) + ChatFormatting.GREEN + " or " + ChatFormatting.WHITE + String.format("%.0f", Math.floor(total)) + ChatFormatting.GREEN + " stacks and " + ChatFormatting.WHITE + String.format("%.0f", remainder) + ChatFormatting.GREEN + " grass"))), false);

        return Command.SINGLE_SUCCESS;

    }
}
