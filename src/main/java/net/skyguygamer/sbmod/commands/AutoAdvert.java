package net.skyguygamer.sbmod.commands;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.ExecuteCommand;


public final class AutoAdvert
{
    //public static LocalPlayer lp = null;
    public static int interval = 8400;
    public static Boolean sendingmessages = false;
    public static String message = "";
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {

        dispatcher.register(Commands.literal("autoadvert")
                .then(Commands.literal("message").then(Commands.argument("messagetosend", StringArgumentType.string()).executes(AutoAdvert -> advert(AutoAdvert.getSource(),
                        StringArgumentType.getString(AutoAdvert, "messagetosend")))))
                .then(Commands.literal("time").then(Commands.argument("amountofminutes", IntegerArgumentType.integer(5)).executes(AutoAdvert -> time(AutoAdvert.getSource(),
                        IntegerArgumentType.getInteger(AutoAdvert, "amountofminutes"))
                )))
                .then(Commands.literal("info").executes(AutoAdvert -> info(AutoAdvert.getSource())))
                .executes(AutoAdvert -> stop(AutoAdvert.getSource())));
        dispatcher.register(Commands.literal("advert")
                .then(Commands.literal("message").then(Commands.argument("messagetosend", StringArgumentType.string()).executes(AutoAdvert -> advert(AutoAdvert.getSource(),
                        StringArgumentType.getString(AutoAdvert, "messagetosend")))))
                .then(Commands.literal("time").then(Commands.argument("amountofminutes", IntegerArgumentType.integer(5)).executes(AutoAdvert -> time(AutoAdvert.getSource(),
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
            source.sendSuccess(Component.literal("§aYou are sending messages every §f" + interval/1200 + " §aminutes"), false);
        } else {
            source.sendSuccess(Component.literal("§cYou are not sending any messages right now!"), false);
        }
        return Command.SINGLE_SUCCESS;
    }
    public static int advert(CommandSourceStack source, String messagetosend) {
        message = messagetosend;
        sendingmessages = true;
        LocalPlayer lp = (LocalPlayer) source.getEntity();
        //lp.chatSigned("d", Component.literal("dd"));

        //Timer timer = new Timer();
        //timer.scheduleAtFixedRate(sendmsg(messagetosend, source), 1000, 1000);
        source.sendSuccess(Component.literal( "§f" + messagetosend + " §awill now be sent every §f" + interval/1200+ " §aminutes!"), false);



        lp.chatSigned(message, Component.literal(""));
        return Command.SINGLE_SUCCESS;
    }

    /*private static TimerTask sendmsg(String messagetosend, CommandSourceStack source) {
        LocalPlayer lp = (LocalPlayer) source.getEntity();
        lp.chatSigned(messagetosend, Component.literal(""));
        return null;
    }

     */

    private static int time(CommandSourceStack source, int amountofminutes) {
        interval = amountofminutes*1200;

        source.sendSuccess(Component.literal("§aYour message will now be sent every §f" + amountofminutes + " §aminutes!"), false);

        return Command.SINGLE_SUCCESS;
    }
}