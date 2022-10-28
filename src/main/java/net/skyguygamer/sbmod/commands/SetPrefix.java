package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import java.util.Set;


public final class SetPrefix {
    public static String prefix1 = "";

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("setchatprefix").then(Commands.argument("prefix", StringArgumentType.string())
                .executes(SetPrefix -> run(SetPrefix.getSource(),
                        StringArgumentType.getString(SetPrefix, "prefix"))
                )));
    }
    public static int run(CommandSourceStack source, String prefix) {
        prefix1 = prefix;
        return Command.SINGLE_SUCCESS;
    }

}
