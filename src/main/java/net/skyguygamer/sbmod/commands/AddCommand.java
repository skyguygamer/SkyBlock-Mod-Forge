package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;


public final class AddCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("add").then(Commands.argument("amount", IntegerArgumentType.integer()).then(Commands.argument("amount2", IntegerArgumentType.integer())
                .executes(AddCommand -> run(AddCommand.getSource(),
                        IntegerArgumentType.getInteger(AddCommand, "amount"),
                        IntegerArgumentType.getInteger(AddCommand, "amount2"))
                ))));
    }

    private static int run(CommandSourceStack source, int amount, int amount2) {
        int total = amount+amount2;
        source.sendSuccess(Component.translatable(amount + " + " + amount2 + " = " + total), false);
        return Command.SINGLE_SUCCESS;

    }

    /*private static int run(CommandContext<CommandSourceStack> context) {
        int output = arg1 + arg2;
        return Command.SINGLE_SUCCESS;
    }

     */
}
/*
.then((Commands.argument("amount", IntegerArgumentType.integer())
        .executes(command -> addFavor(command.getSource(), EntityArgument.getPlayers(command, "targets"), ResourceLocationArgument.getId(command, "deity"), IntegerArgumentType.getInteger(command, "amount"), Type.LEVELS))
*/