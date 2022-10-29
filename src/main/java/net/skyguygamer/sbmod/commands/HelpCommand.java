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
        context.getSource().sendSuccess(Component.literal("§a/autoadvert §7[info,message,time]§f: Allows you to send a message every interval (Leave empty to stop adverts)"), false);
        context.getSource().sendSuccess(Component.literal("§a/64 §7[number]§f: Divides a number by 64 to find how many stacks it is"), false);
        context.getSource().sendSuccess(Component.literal("§a/calc §7[add,subtract,multiply,divide]§f: Allows you to use simple math methods"), false);
        context.getSource().sendSuccess(Component.literal("§a/enchantall§f: Will enchant your item with all the possible enchants for that item "), false);
        context.getSource().sendSuccess(Component.literal("§a/autofix§f: Will autofix your tool every 20 minutes when your tool is below 25%"), false);
        context.getSource().sendSuccess(Component.literal("§a/autospawnmob §7[info]§f: Will auto spawn a mob of your choosing that you have access to"), false);
        context.getSource().sendSuccess(Component.literal("§a/hello§f: Sends you a nice message :)"), false);
        //context.getSource().sendSuccess(Component.literal(""), false);
        context.getSource().sendSuccess(Component.literal(boarder), false);
        return Command.SINGLE_SUCCESS;
    }
}
