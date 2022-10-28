package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.skyguygamer.sbmod.SbMod;

public class AutoFix {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("autofix").executes(EnchantAllCommand -> run(EnchantAllCommand.getSource())));
        dispatcher.register(Commands.literal("autorepair").executes(EnchantAllCommand -> run(EnchantAllCommand.getSource())));
    }
    public static int run(CommandSourceStack source) {
        if (SbMod.autoFix) {
            SbMod.autoFix = false;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto Fix Disabled"), false);
        } else if (!SbMod.autoFix) {
            SbMod.autoFix = true;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "Auto Fix Enabled"), false);

        }
        
        return Command.SINGLE_SUCCESS;
    }
}

