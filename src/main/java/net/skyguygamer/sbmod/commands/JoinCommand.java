package net.skyguygamer.sbmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public final class JoinCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {

        List<String> aliases = new ArrayList<String>();
        aliases.add("jc");
        aliases.add("joincommand");

        boolean success = false;
        ArrayList<String> commands = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("joincommands.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                commands.add(line);
            }
            in.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
        dispatcher.register(Commands.literal("joincommand")
                .then(Commands.literal("add").then(Commands.argument("command", StringArgumentType.greedyString()).executes(JoinCommand -> add(JoinCommand.getSource(),
                                StringArgumentType.getString(JoinCommand, "command"), commands, success

                        )))
                ).then(Commands.literal("delete").then(Commands.argument("numinlist", IntegerArgumentType.integer(0)).executes(JoinCommand -> delete(JoinCommand.getSource(),
                        IntegerArgumentType.getInteger(JoinCommand, "numinlist"), commands, success))))
                .then(Commands.literal("list").executes(JoinCommand -> listJc(JoinCommand.getSource(), commands))));




        dispatcher.register(Commands.literal("jc")
                .then(Commands.literal("add").then(Commands.argument("command", StringArgumentType.greedyString()).executes(JoinCommand -> add(JoinCommand.getSource(),
                                StringArgumentType.getString(JoinCommand, "command"), commands, success

                        )))
                ).then(Commands.literal("delete").then(Commands.argument("numinlist", IntegerArgumentType.integer(0)).executes(JoinCommand -> delete(JoinCommand.getSource(),
                        IntegerArgumentType.getInteger(JoinCommand, "numinlist"), commands, success))))
                .then(Commands.literal("list").executes(JoinCommand -> listJc(JoinCommand.getSource(), commands))));



    }

    private static int add(CommandSourceStack source, String command, ArrayList<String> commands, Boolean success) {
        if (command.startsWith("/")) {
            command = command.substring(1);
        }
        if (command.equals("")) {
            source.sendSuccess(Component.literal("Please enter a command").withStyle(ChatFormatting.RED), false);
        }
        else {
            String addtolist = "";
            for (int i = 1; i < 2; i++) {
                addtolist += command;
            }
            commands.add(addtolist);
            success = true;
            source.sendSuccess(Component.literal("/" + addtolist+" will be executed whenever you join").withStyle(ChatFormatting.DARK_AQUA),false);
            }
        if (success) {
            PrintWriter writer;
            try {
                writer = new PrintWriter("joincommands.txt", "UTF-8");
                for (int i = 0; i < commands.size(); i++) {
                    writer.println(commands.get(i));
                }
                source.sendSuccess(Component.literal("Successfully updated").withStyle(ChatFormatting.GREEN),false);
                writer.close();
                success = false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                success = false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return Command.SINGLE_SUCCESS;
    }
    private static int delete(CommandSourceStack source, int numinlist, ArrayList<String> commands, Boolean success) {
        try {
            commands.remove(numinlist);
            success = true;
        } catch (Exception e) {
            source.sendSuccess(Component.literal("Invalid, please check your index # (/joincommand list)").withStyle(ChatFormatting.RED), false);
        }
        if (success) {
            PrintWriter writer;
            try {
                writer = new PrintWriter("joincommands.txt", "UTF-8");
                for (int i = 0; i < commands.size(); i++) {
                    writer.println(commands.get(i));
                }
                source.sendSuccess(Component.literal("Successfully updated").withStyle(ChatFormatting.GREEN),false);
                writer.close();
                success = false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                success = false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return Command.SINGLE_SUCCESS;
    }

    private static int listJc(CommandSourceStack source, ArrayList<String> commands) {
        source.sendSuccess(Component.literal("****************************************").withStyle(ChatFormatting.GREEN), false);
        if (commands.size()==0) {
            source.sendSuccess(Component.literal("Kinda lonely here :("), false);
        }
        for (int i = 0; i < commands.size(); i++) {
            source.sendSuccess(Component.literal(String.valueOf(i)+": /"+commands.get(i)), false);
        }
        source.sendSuccess(Component.literal("****************************************").withStyle(ChatFormatting.GREEN), false);



        return Command.SINGLE_SUCCESS;
    }


}
