package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public final class AutoAdvert
{
    public static int interval = 7;
    public static Boolean sendingmessages = false;
    public static String message = "";
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {

        dispatcher.register(Commands.literal("autoadvert")
                .then(Commands.literal("message").then(Commands.argument("messagetosend", StringArgumentType.string()).executes(AutoAdvert -> advert(AutoAdvert.getSource(),
                        StringArgumentType.getString(AutoAdvert, "messagetosend")))))
                .then(Commands.literal("time").then(Commands.argument("amountofminutes", IntegerArgumentType.integer(0)).executes(AutoAdvert -> time(AutoAdvert.getSource(),
                        IntegerArgumentType.getInteger(AutoAdvert, "amountofminutes"))
                )))
                .then(Commands.literal("info").executes(AutoAdvert -> info(AutoAdvert.getSource())))
                .executes(AutoAdvert -> stop(AutoAdvert.getSource())));

    }
    private static int stop(CommandSourceStack source) {
        sendingmessages = false;
        source.sendSuccess(Component.literal("§aYou have stopped sending adverts!"), false);

        return Command.SINGLE_SUCCESS;
    }
    private static int info(CommandSourceStack source) {
        if(sendingmessages) {
            source.sendSuccess(Component.literal("§aYou are currently sending §f" + message), false);
            source.sendSuccess(Component.literal("§aYou are sending messages every §f" + interval + " §aminutes"), false);
        } else {
            source.sendSuccess(Component.literal("§cYou are not sending any messages right now!"), false);
        }
        return Command.SINGLE_SUCCESS;
    }
    private static int advert(CommandSourceStack source, String messagetosend) {
        message = messagetosend;
        sendingmessages = true;

        source.sendSuccess(Component.literal( "§f" + messagetosend + " §awill now be sent every §f" + interval + " §aminutes!"), false);

        return Command.SINGLE_SUCCESS;
    }
    private static int time(CommandSourceStack source, int amountofminutes) {
        interval = amountofminutes;

        source.sendSuccess(Component.literal("§aYour message will now be sent every §f" + amountofminutes + " §aminutes!"), false);

        return Command.SINGLE_SUCCESS;
    }
}