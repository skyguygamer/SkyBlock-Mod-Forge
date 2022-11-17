package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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
        Style style = Style.EMPTY;
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/shelp"));
        context.getSource().sendSuccess(Component.literal(boarder), false);
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/shelp:" + ChatFormatting.WHITE + " Lists the Skyblock Mods Commands").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/saliases"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/saliases" + ChatFormatting.WHITE + ": Lists the available shortcuts to commands in this mod").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/joincommand"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/joincommand " + ChatFormatting.GRAY + "[add,delete,list,help]" + ChatFormatting.WHITE + ": Allows you to set commands/messages that are sent when you join the game").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/autoadvert"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/autoadvert " + ChatFormatting.GRAY + "[info,message,time]" + ChatFormatting.WHITE + ": Allows you to send a message every interval (Leave empty to stop adverts)").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/64"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/64 " + ChatFormatting.GRAY + "[number]" + ChatFormatting.WHITE + ": Divides a number by 64 to find how many stacks it is").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/calc"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/calc " + ChatFormatting.GRAY + "[add,subtract,multiply,divide]" + ChatFormatting.WHITE + ": Allows you to use simple math methods").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/enchantall"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/enchantall" + ChatFormatting.WHITE + ": Will enchant your item with all the possible enchants for that item ").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/autofix"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/autofix" + ChatFormatting.WHITE + ": Will autofix your tool every 20 minutes when your tool is below 25%").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/autospawnmob"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/autospawnmob " + ChatFormatting.GRAY + "[info]" + ChatFormatting.WHITE + ": Will auto spawn a mob of your choosing that you have access to").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/hello"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/hello" + ChatFormatting.WHITE + ": Sends you a nice message :)").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/sdiscord"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/sdiscord" + ChatFormatting.WHITE + ": Sends you the link to the support discord!").setStyle(style), false);
        style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/autobuy"));
        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/autobuy" + ChatFormatting.WHITE + ": Will try to buy 2 lottery tickets every 30 minutes").setStyle(style), false);
        //style = style.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/"));
        //context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "/" + ChatFormatting.WHITE + ": ").setStyle(style), false);
        context.getSource().sendSuccess(Component.literal(boarder), false);
        return Command.SINGLE_SUCCESS;
    }
}
