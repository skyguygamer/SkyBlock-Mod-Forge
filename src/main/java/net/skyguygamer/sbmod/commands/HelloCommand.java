package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;


public final class HelloCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("hello").executes(HelloCommand::run));
    }

    private static int run(CommandContext<CommandSourceStack> context)
    {
        Player player = (Player) context.getSource().getEntity();

        context.getSource().sendSuccess(Component.translatable("hellocommand", player.getName()).withStyle(ChatFormatting.RED), false);
        return Command.SINGLE_SUCCESS;
    }
}

