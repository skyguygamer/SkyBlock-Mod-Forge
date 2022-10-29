package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.skyguygamer.sbmod.SbMod;

public class AutoSpawnMob {
    public static String command = "";
    public static boolean spawningMobs = false;
    public static int amountSpawning = 0;
    public static String playerSpawnedOn = "N/A";
    public static String mobSpawned = "";

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("autospawnmob").then(Commands.argument("mob", StringArgumentType.string())
                .then(Commands.argument("amount", IntegerArgumentType.integer(1, 2)).then(Commands.argument("player", StringArgumentType.string()).executes(AutoSpawnMob -> all(AutoSpawnMob.getSource(),
                        StringArgumentType.getString(AutoSpawnMob, "mob"),
                        IntegerArgumentType.getInteger(AutoSpawnMob, "amount"),
                        StringArgumentType.getString(AutoSpawnMob, "player"))))
                        .executes(AutoSpawnMob -> noPlayer(AutoSpawnMob.getSource(),
                                StringArgumentType.getString(AutoSpawnMob, "mob"),
                                IntegerArgumentType.getInteger(AutoSpawnMob, "amount")))))
                        .then(Commands.literal("info").executes(AutoSpawnMob -> info(AutoSpawnMob.getSource())))
                .executes(AutoSpawnMob -> stop(AutoSpawnMob.getSource())));
        dispatcher.register(Commands.literal("asm").then(Commands.argument("mob", StringArgumentType.string())
                        .then(Commands.argument("amount", IntegerArgumentType.integer(1, 2)).then(Commands.argument("player", StringArgumentType.string()).executes(AutoSpawnMob -> all(AutoSpawnMob.getSource(),
                                        StringArgumentType.getString(AutoSpawnMob, "mob"),
                                        IntegerArgumentType.getInteger(AutoSpawnMob, "amount"),
                                        StringArgumentType.getString(AutoSpawnMob, "player"))))
                                .executes(AutoSpawnMob -> noPlayer(AutoSpawnMob.getSource(),
                                        StringArgumentType.getString(AutoSpawnMob, "mob"),
                                        IntegerArgumentType.getInteger(AutoSpawnMob, "amount")))))
                .then(Commands.literal("info").executes(AutoSpawnMob -> info(AutoSpawnMob.getSource())))
                .executes(AutoSpawnMob -> stop(AutoSpawnMob.getSource())));
    }
    //To spawn mobs with 3rd argument
    public static int all(CommandSourceStack source, String mob, int amount, String player) {
        command = ("/spawnmob " + mob + " " + amount + " " + player);
        SbMod.spawnMobs = true;
        SbMod.spawnTime = 3000;
        amountSpawning = amount;
        playerSpawnedOn = player;
        mobSpawned = mob;
        source.sendSuccess(Component.literal(ChatFormatting.GREEN + "Now spawning mobs!"), false);
        return Command.SINGLE_SUCCESS;
    }
    //To spawn mobs without 3rd argument
    public static int noPlayer(CommandSourceStack source, String mob, int amount) {
        command = ("/spawnmob " + mob + " " + amount);
        SbMod.spawnMobs = true;
        SbMod.spawnTime = 3000;
        amountSpawning = amount;
        mobSpawned = mob;
        source.sendSuccess(Component.literal(ChatFormatting.GREEN + "Now spawning mobs!"), false);
        return Command.SINGLE_SUCCESS;
    }
    public static int info(CommandSourceStack source) {
        if(SbMod.spawnMobs) {
            source.sendSuccess(Component.literal("§aYou currently are spawning §f" + amountSpawning + " " + mobSpawned + " §aon §f" + playerSpawnedOn), false);
        } else {
            source.sendSuccess(Component.literal(ChatFormatting.RED + "You are not spawning mobs right now!"), false);
        }
        return Command.SINGLE_SUCCESS;
    }
    //Stops spawning mobs
    public static int stop(CommandSourceStack source) {
        if(SbMod.spawnMobs) {
            SbMod.spawnMobs = false;
            spawningMobs = false;
            source.sendSuccess(Component.literal(ChatFormatting.GREEN + "You have stopped spawning mobs"), false);
        } else {
            source.sendSuccess(Component.literal(ChatFormatting.RED + "You currently are not spawning any mobs"), false);
        }
        return Command.SINGLE_SUCCESS;
    }

}
