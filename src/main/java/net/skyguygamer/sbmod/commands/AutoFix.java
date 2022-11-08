package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.skyguygamer.sbmod.SbMod;

import static net.skyguygamer.sbmod.SbMod.autoFix;
import static net.skyguygamer.sbmod.SbMod.coolDownCounter;

public class AutoFix {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("autofix").executes(AutoFix -> run(AutoFix.getSource()))
                .then(Commands.literal("time").executes(AutoFix -> time(AutoFix.getSource()))));
        dispatcher.register(Commands.literal("autorepair").executes(AutoFix -> run(AutoFix.getSource()))
                .then(Commands.literal("time").executes(AutoFix -> time(AutoFix.getSource()))));
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
    public static int time(CommandSourceStack source) {
        int time = 24000-coolDownCounter;
        int timeRemaining = (time/20)/60;
        int seconds = (time/20)%60;
        if (autoFix) {
            source.sendSuccess(Component.literal("§aTime remaining before next fix try§f: " + timeRemaining + " §aminutes, §f" + seconds + " §aseconds"), false);
        } else {
            source.sendSuccess(Component.literal("§cAuto fix is not enabled!"), false);
        }
        return Command.SINGLE_SUCCESS;
    }
}

