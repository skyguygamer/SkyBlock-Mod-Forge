package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.Component;



public class CommandAliases {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("saliases").executes(CommandAliases::run));
    }
    private static int run(CommandContext<CommandSourceStack> context) {

        String boarder = "";
        for (int i = 0; i < 20; i++) {
            boarder += "§a*";
            boarder += "§f*";
        }
        Style test = Style.EMPTY;
        test = test.withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/hello"))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal("What? You found a secret message?").withStyle(ChatFormatting.GREEN)));


        context.getSource().sendSuccess(Component.literal(boarder), false);
        context.getSource().sendSuccess(Component.literal("§a/enchantall§f: /ea").setStyle(test), false);
        context.getSource().sendSuccess(Component.literal("§a/joincommand§f: /jc"), false);
        context.getSource().sendSuccess(Component.literal("§a/autoadvert§f: /advert"), false);
        context.getSource().sendSuccess(Component.literal("§a/autofix§f: /autorepair"), false);
        context.getSource().sendSuccess(Component.literal(boarder), false);
        return Command.SINGLE_SUCCESS;
    }
}
