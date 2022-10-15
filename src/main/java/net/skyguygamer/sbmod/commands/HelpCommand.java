package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

public final class HelpCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("shelp").executes(HelpCommand::run));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        Player player = (Player) context.getSource().getEntity();

        String boarder = "";
        for (int i = 0; i < 20; i++) {
            boarder += "§a*";
            boarder += "§f*";
        }
        context.getSource().sendSuccess(Component.literal(boarder), false);
        context.getSource().sendSuccess(Component.literal("§a/shelp§f: Lists the Skyblock Mods Commands"), false);
        context.getSource().sendSuccess(Component.literal("§a/joincommand §7[add,delete,list,help]§f: Allows you to set commands/messages that are sent when you join the game"), false);
        context.getSource().sendSuccess(Component.literal("§a/64 §7[number]§f: Divides a number by 64 to find how many stacks it is"), false);
        context.getSource().sendSuccess(Component.literal("§a/add §7[int1,int2]§f: Allows you to add two numbers together"), false);
        context.getSource().sendSuccess(Component.literal("§a/hello§f: Sends you a nice message :)"), false);
        context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(boarder), false);
        return Command.SINGLE_SUCCESS;
    }
}
