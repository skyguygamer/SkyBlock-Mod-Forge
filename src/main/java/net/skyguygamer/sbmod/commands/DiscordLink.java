package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;


public final class DiscordLink
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("sdiscord").executes(DiscordLink::run));
    }

    private static int run(CommandContext<CommandSourceStack> context)
    {
        Player player = (Player) context.getSource().getEntity();

        context.getSource().sendSuccess(Component.literal(ChatFormatting.GREEN + "Join the support and update discord here for this mod here!" + ChatFormatting.BLUE + " https://discord.gg/WAw6xC29E8"), false);
        return Command.SINGLE_SUCCESS;
    }
}