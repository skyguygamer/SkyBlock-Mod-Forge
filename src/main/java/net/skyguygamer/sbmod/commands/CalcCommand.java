package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;


public final class CalcCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("calc")
                .then(Commands.literal("add").then(Commands.argument("amount", IntegerArgumentType.integer()).then(Commands.argument("amount2", IntegerArgumentType.integer())
                .executes(CalcCommand -> runAdd(CalcCommand.getSource(),
                        IntegerArgumentType.getInteger(CalcCommand, "amount"),
                        IntegerArgumentType.getInteger(CalcCommand, "amount2"))
                ))))
                .then(Commands.literal("subtract").then(Commands.argument("amount", IntegerArgumentType.integer()).then(Commands.argument("amount2", IntegerArgumentType.integer())
                        .executes(CalcCommand -> runSubtract(CalcCommand.getSource(),
                                IntegerArgumentType.getInteger(CalcCommand, "amount"),
                                IntegerArgumentType.getInteger(CalcCommand, "amount2"))
                        ))))
                .then(Commands.literal("multiply").then(Commands.argument("amount", IntegerArgumentType.integer()).then(Commands.argument("amount2", IntegerArgumentType.integer())
                        .executes(CalcCommand -> runMultiply(CalcCommand.getSource(),
                                IntegerArgumentType.getInteger(CalcCommand, "amount"),
                                IntegerArgumentType.getInteger(CalcCommand, "amount2"))
                        ))))
                .then(Commands.literal("divide").then(Commands.argument("amount", IntegerArgumentType.integer()).then(Commands.argument("amount2", IntegerArgumentType.integer())
                        .executes(CalcCommand -> runDivide(CalcCommand.getSource(),
                                IntegerArgumentType.getInteger(CalcCommand, "amount"),
                                IntegerArgumentType.getInteger(CalcCommand, "amount2"))
                        )))));
    }
    //Addition
    private static int runAdd(CommandSourceStack source, int amount, int amount2) {
        int total = amount+amount2;
        source.sendSuccess(Component.translatable(amount + " + " + amount2 + " = " + total), false);
        return Command.SINGLE_SUCCESS;

    }
    //Subtract
    private static int runSubtract(CommandSourceStack source, int amount, int amount2) {
        int total = amount-amount2;
        source.sendSuccess(Component.translatable(amount + " - " + amount2 + " = " + total), false);
        return Command.SINGLE_SUCCESS;
    }
    //Multiply
    private static int runMultiply(CommandSourceStack source, int amount, int amount2) {
        int total = amount*amount2;
        source.sendSuccess(Component.translatable(amount + " * " + amount2 + " = " + total), false);
        return Command.SINGLE_SUCCESS;
    }
    //Divide
    private static int runDivide(CommandSourceStack source, int amount, int amount2) {
        int total = amount/amount2;
        source.sendSuccess(Component.translatable(amount + " / " + amount2 + " = " + total), false);
        return Command.SINGLE_SUCCESS;
    }
}