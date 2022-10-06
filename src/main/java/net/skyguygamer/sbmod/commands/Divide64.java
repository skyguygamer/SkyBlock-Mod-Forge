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
         double total = amount/64.0;
         String.format("%.2f", total);
        source.sendSuccess(((Component.translatable(" - ").withStyle(ChatFormatting.RED)).append(Component.literal(amount + " / " + " 64 " + " = " + String.format("%.2f", total)).withStyle(ChatFormatting.GREEN))), false);

        return Command.SINGLE_SUCCESS;

    }
}
