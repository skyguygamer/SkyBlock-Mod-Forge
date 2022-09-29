package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public final class HelloCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("hello").executes(HelloCommand::run));
    }

    private static int run(CommandContext<CommandSourceStack> context)
    {


        Object player = null;
        context.getSource().sendSuccess(Component.translatable("hello", Minecraft.getInstance().player.getDisplayName()), false);
        return Command.SINGLE_SUCCESS;
    }
}

