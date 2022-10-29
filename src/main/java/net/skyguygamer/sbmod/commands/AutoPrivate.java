package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.skyguygamer.sbmod.SbMod;

public class AutoPrivate {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("autoprivate").then(Commands.argument("line3", StringArgumentType.string()).then(Commands.argument("line4", StringArgumentType.string())
                .executes(AutoPrivate -> run(AutoPrivate.getSource(),
                        StringArgumentType.getString(AutoPrivate, "line3"),
                        StringArgumentType.getString(AutoPrivate, "line4")
                )))).executes(AutoPrivate -> run2(AutoPrivate.getSource())));

    }
    public static String text;
    private static int run(CommandSourceStack source, String line3, String line4) {
        //text = "[Private]\n" + source.getEntity().getName() + "\n" + line3 + "\n" + line4+"�";
        if(!SbMod.autoPrivate) {
            SbMod.autoPrivate = true;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "AutoPrivate is now enabled"), false);
        } else {
            SbMod.autoPrivate = false;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "AutoPrivate is now disabled"), false);
        }
        return Command.SINGLE_SUCCESS;


    }
    private static int run2(CommandSourceStack source) {
        //text = "[Private]\n"+source.getEntity().getName()+"�";
        text = "d";
        if(!SbMod.autoPrivate) {
            SbMod.autoPrivate = true;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "AutoPrivate is now enabled"), false);
        } else {
            SbMod.autoPrivate = false;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "AutoPrivate is now disabled"), false);
        }
        return Command.SINGLE_SUCCESS;
    }
}
