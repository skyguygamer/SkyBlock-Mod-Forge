package net.skyguygamer.sbmod;


import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.targets.CommonLaunchHandler;
import net.minecraftforge.fml.loading.targets.FMLClientLaunchHandler;
import net.skyguygamer.sbmod.commands.*;
import net.skyguygamer.sbmod.config.SbModClientConfigs;
import net.skyguygamer.sbmod.util.KeyBinding;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.util.List;

//test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(SbMod.MOD_ID)
public class SbMod {
    public static int firstCheck = 1;
    public static int modsCheck = 0;
    public static Boolean loggingIn = false;
    public static Player player = null;
    public static int pressTime = 0;
    public static int advertTimer = 0;
    public static Boolean loggedOn = false;
    public static final String MOD_ID = "sbmod";
    public static String msgsent = "";
    public static int time = 0;
    public static int coolDownCounter = 0;
    public static boolean enchantSword = false;
    public static boolean playsound = false;
    public static boolean enchantTool = false;
    public static boolean enchantChest = false;
    public static boolean enchantBow = false;
    public static boolean enchantHelmet = false;
    public static boolean enchantBoots = false;
    public static boolean enchantRod = false;
    public static boolean enchantOther = false;
    public static boolean enchantAxe = false;
    public static boolean enchant = false;
    public static boolean autoFix = false;
    public static boolean autoPrivate = false;
    public static boolean coolDown = false;
    public static boolean printMsg = false;
    public static int printMsgTimer = 0;
    public static boolean spawnMobs = false;
    public static int spawnTime = 0;
    public static void convertText(String text) {
        for (int i = 0; i < text.length(); i ++) {
            String character = String.valueOf(text.charAt(i));

            try {
                //if(!GraphicsEnvironment.isHeadless()) {
                    Robot robot = new Robot();
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    switch (character) {
                        case "a" -> {
                            robot.keyPress(KeyEvent.VK_A);
                            robot.keyRelease(KeyEvent.VK_A);
                        }
                        case "b" -> {
                            robot.keyPress(KeyEvent.VK_B);
                            robot.keyRelease(KeyEvent.VK_B);
                        }
                        case "c" -> {
                            robot.keyPress(KeyEvent.VK_C);
                            robot.keyRelease(KeyEvent.VK_C);
                        }
                        case "d" -> {
                            robot.keyPress(KeyEvent.VK_D);
                            robot.keyRelease(KeyEvent.VK_D);
                        }
                        case "e" -> {
                            robot.keyPress(KeyEvent.VK_E);
                            robot.keyRelease(KeyEvent.VK_E);
                        }
                        case "f" -> {
                            robot.keyPress(KeyEvent.VK_F);
                            robot.keyRelease(KeyEvent.VK_F);
                        }
                        case "g" -> {
                            robot.keyPress(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_G);
                        }
                        case "h" -> {
                            robot.keyPress(KeyEvent.VK_H);
                            robot.keyRelease(KeyEvent.VK_H);
                        }
                        case "i" -> {
                            robot.keyPress(KeyEvent.VK_I);
                            robot.keyRelease(KeyEvent.VK_I);
                        }
                        case "j" -> {
                            robot.keyPress(KeyEvent.VK_J);
                            robot.keyRelease(KeyEvent.VK_J);
                        }
                        case "k" -> {
                            robot.keyPress(KeyEvent.VK_K);
                            robot.keyRelease(KeyEvent.VK_K);
                        }
                        case "l" -> {
                            robot.keyPress(KeyEvent.VK_L);
                            robot.keyRelease(KeyEvent.VK_L);
                        }
                        case "m" -> {
                            robot.keyPress(KeyEvent.VK_M);
                            robot.keyRelease(KeyEvent.VK_M);
                        }
                        case "n" -> {
                            robot.keyPress(KeyEvent.VK_N);
                            robot.keyRelease(KeyEvent.VK_N);
                        }
                        case "o" -> {
                            robot.keyPress(KeyEvent.VK_O);
                            robot.keyRelease(KeyEvent.VK_O);
                        }
                        case "p" -> {
                            robot.keyPress(KeyEvent.VK_P);
                            robot.keyRelease(KeyEvent.VK_P);
                        }
                        case "q" -> {
                            robot.keyPress(KeyEvent.VK_Q);
                            robot.keyRelease(KeyEvent.VK_Q);
                        }
                        case "r" -> {
                            robot.keyPress(KeyEvent.VK_R);
                            robot.keyRelease(KeyEvent.VK_R);
                        }
                        case "s" -> {
                            robot.keyPress(KeyEvent.VK_S);
                            robot.keyRelease(KeyEvent.VK_S);
                        }
                        case "t" -> {
                            robot.keyPress(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_T);
                        }
                        case "u" -> {
                            robot.keyPress(KeyEvent.VK_U);
                            robot.keyRelease(KeyEvent.VK_U);
                        }
                        case "v" -> {
                            robot.keyPress(KeyEvent.VK_V);
                            robot.keyRelease(KeyEvent.VK_V);
                        }
                        case "w" -> {
                            robot.keyPress(KeyEvent.VK_W);
                            robot.keyRelease(KeyEvent.VK_W);
                        }
                        case "x" -> {
                            robot.keyPress(KeyEvent.VK_X);
                            robot.keyRelease(KeyEvent.VK_X);
                        }
                        case "y" -> {
                            robot.keyPress(KeyEvent.VK_Y);
                            robot.keyRelease(KeyEvent.VK_Y);
                        }
                        case "z" -> {
                            robot.keyPress(KeyEvent.VK_Z);
                            robot.keyRelease(KeyEvent.VK_Z);
                        }
                        case "A" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_A);
                            robot.keyRelease(KeyEvent.VK_A);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "B" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_B);
                            robot.keyRelease(KeyEvent.VK_B);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "C" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_C);
                            robot.keyRelease(KeyEvent.VK_C);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "D" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_D);
                            robot.keyRelease(KeyEvent.VK_D);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "E" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_E);
                            robot.keyRelease(KeyEvent.VK_E);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "F" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_F);
                            robot.keyRelease(KeyEvent.VK_F);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "G" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_G);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "H" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_H);
                            robot.keyRelease(KeyEvent.VK_H);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "I" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_I);
                            robot.keyRelease(KeyEvent.VK_I);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "J" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_J);
                            robot.keyRelease(KeyEvent.VK_J);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "K" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_K);
                            robot.keyRelease(KeyEvent.VK_K);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "L" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_L);
                            robot.keyRelease(KeyEvent.VK_L);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "M" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_M);
                            robot.keyRelease(KeyEvent.VK_M);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "N" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_N);
                            robot.keyRelease(KeyEvent.VK_N);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "O" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_O);
                            robot.keyRelease(KeyEvent.VK_O);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "P" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_P);
                            robot.keyRelease(KeyEvent.VK_P);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "Q" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_Q);
                            robot.keyRelease(KeyEvent.VK_Q);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "R" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_R);
                            robot.keyRelease(KeyEvent.VK_R);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "S" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_S);
                            robot.keyRelease(KeyEvent.VK_S);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "T" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "U" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_U);
                            robot.keyRelease(KeyEvent.VK_U);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "V" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_V);
                            robot.keyRelease(KeyEvent.VK_V);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "W" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_W);
                            robot.keyRelease(KeyEvent.VK_W);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "X" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_X);
                            robot.keyRelease(KeyEvent.VK_X);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "Y" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_Y);
                            robot.keyRelease(KeyEvent.VK_Y);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "Z" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_Z);
                            robot.keyRelease(KeyEvent.VK_Z);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "0" -> {
                            robot.keyPress(KeyEvent.VK_0);
                            robot.keyRelease(KeyEvent.VK_0);
                        }
                        case "1" -> {
                            robot.keyPress(KeyEvent.VK_1);
                            robot.keyRelease(KeyEvent.VK_1);
                        }
                        case "2" -> {
                            robot.keyPress(KeyEvent.VK_2);
                            robot.keyRelease(KeyEvent.VK_2);
                        }
                        case "3" -> {
                            robot.keyPress(KeyEvent.VK_3);
                            robot.keyRelease(KeyEvent.VK_3);
                        }
                        case "4" -> {
                            robot.keyPress(KeyEvent.VK_4);
                            robot.keyRelease(KeyEvent.VK_4);
                        }
                        case "5" -> {
                            robot.keyPress(KeyEvent.VK_5);
                            robot.keyRelease(KeyEvent.VK_5);
                        }
                        case "6" -> {
                            robot.keyPress(KeyEvent.VK_6);
                            robot.keyRelease(KeyEvent.VK_6);
                        }
                        case "7" -> {
                            robot.keyPress(KeyEvent.VK_7);
                            robot.keyRelease(KeyEvent.VK_7);
                        }
                        case "8" -> {
                            robot.keyPress(KeyEvent.VK_8);
                            robot.keyRelease(KeyEvent.VK_8);
                        }
                        case "9" -> {
                            robot.keyPress(KeyEvent.VK_9);
                            robot.keyRelease(KeyEvent.VK_9);
                        }
                        case "&" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_7);
                            robot.keyRelease(KeyEvent.VK_7);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "[" -> {
                            robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                            robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
                        }
                        case "]" -> {
                            robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                            robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                        }
                        case "_" -> {
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.keyPress(KeyEvent.VK_SUBTRACT);
                            robot.keyRelease(KeyEvent.VK_SUBTRACT);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        case "\n" -> {
                            robot.keyPress(KeyEvent.VK_ENTER);
                            robot.keyRelease(KeyEvent.VK_ENTER);
                        }
                        case "�" -> {
                            robot.keyPress(KeyEvent.VK_ESCAPE);
                            robot.keyRelease(KeyEvent.VK_ESCAPE);
                        }
                    }
                //}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //private static final Logger LOGGER = LogUtils.getLogger();

    public SbMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SbModClientConfigs.SPEC, "sbmod-client.toml");
    }




    @Mod.EventBusSubscriber(modid = "sbmod")

    public static class EventHandlers {
        //Registering Keybindings

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.backKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/back", Component.literal(""));
            }
            if(KeyBinding.jumpKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/jump", Component.literal(""));
            }
            if(KeyBinding.ehomeKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/ehome", Component.literal(""));
            }
            if(KeyBinding.craftKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/craft", Component.literal(""));
            }
            if(KeyBinding.homeKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/home", Component.literal(""));
            }
            if(KeyBinding.ecKey.consumeClick()) {
                Minecraft.getInstance().player.chatSigned("/ec", Component.literal(""));
            }

        }

        @SubscribeEvent
        public static void logOn(ClientPlayerNetworkEvent.LoggingIn event)  {
            player = event.getPlayer();
            //Login message
            if (SbModClientConfigs.welcomemsg.get() && !loggedOn) {
                String boarder = "";
                for (int i = 0; i < 20; i++) {
                    boarder += "§a-";
                    boarder += "§2=";
                }
                player.displayClientMessage((Component.literal(boarder + "§a-")), false);
                player.displayClientMessage((Component.literal("§7Skyblock Mod for forge 1.19.2")), false);
                player.displayClientMessage((Component.literal("§7Updated version 3.0 §cBETA")), false);
                player.displayClientMessage((Component.literal("§7Type /shelp for list of commands")), false);
                player.displayClientMessage((Component.literal(boarder + "§a-")), false);
            }
            if (!loggedOn) {
                List<String> commands = new ArrayList<String>();
                try {
                    BufferedReader jclist = new BufferedReader(new FileReader("joincommands.txt"));
                    String line;
                    while ((line = jclist.readLine()) != null) {
                        commands.add(line);
                    }
                    jclist.close();
                } catch (Exception e) {
                    PrintWriter writer;
                    try {
                        writer = new PrintWriter("joincommands.txt", "UTF-8");
                    } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
                System.out.println(commands);
                System.out.println(commands.size());
                for (int i = 0; i < commands.size(); i++) {
                    LocalPlayer lp = event.getPlayer();
                    lp.chatSigned(commands.get(i), Component.literal(""));
                    loggedOn = true;
                }
            }
        }

        @SubscribeEvent
        public static void onBlockPlace(PlayerInteractEvent event) {
            Item item = event.getItemStack().getItem();
            if(!printMsg && item == Items.ACACIA_SIGN || item == Items.SPRUCE_SIGN || item == Items.BIRCH_SIGN || item == Items.CRIMSON_SIGN || item == Items.JUNGLE_SIGN || item == Items.DARK_OAK_SIGN || item == Items.WARPED_SIGN || item == Items.OAK_SIGN || item == Items.MANGROVE_SIGN) {
                printMsg = true;
            }
        }
        //Straight up doesn't work

        /*@SubscribeEvent
        public static void onChat2(ServerChatEvent.Submitted event) {
            event.setCanceled(true);
        }
        */

        /*@SubscribeEvent
        public static void onChatrecieve(ClientChatReceivedEvent event) {
            event.setCanceled(true);
        }

         */



        @SubscribeEvent
        public static void on(ClientChatReceivedEvent e) {
            
        }



        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent event) {
            LocalPlayer lp = Minecraft.getInstance().player;
            //AutoPrivate
            if (printMsg) {
                if (printMsgTimer >= 10) {
                    if (autoPrivate) {
                        convertText(AutoPrivate.text);
                    }
                    printMsg = false;
                    printMsgTimer = 0;
                }
                else {
                    printMsgTimer ++;
                }
            }
            //AutoSpawnMob
            try {
                if (spawnMobs) {
                    if (spawnTime >= 1500) {
                        lp.chatSigned(AutoSpawnMob.command, Component.literal(""));
                        spawnTime = 0;
                    }
                    spawnTime++;
                }
            } catch (Exception e) {
                ;
            }
            //AutoFix
            if (autoFix && !coolDown) {

                ItemStack item = Minecraft.getInstance().player.getMainHandItem();
                float percent = 100*(((float) item.getMaxDamage() - (float) item.getDamageValue())/ (float) item.getMaxDamage());
                try {
                    if (percent < 25 && autoFix && item.isDamageableItem() && !coolDown) {
                        lp.chatSigned("/fix all", Component.literal(""));
                        coolDown = true;
                    }
                } catch (Exception e) {}
            }
            //Cool down for AutoFix
            if (coolDown) {
                if (coolDownCounter >= 48040) {
                    coolDown = false;
                    coolDownCounter = 0;
                }
                coolDownCounter ++;
            }
            //AutoAdvert
            if (AutoAdvert.sendingmessages) {
                if (advertTimer >= AutoAdvert.interval) {

                    lp.chatSigned(AutoAdvert.message, Component.literal(""));
                    advertTimer = 0;
                }
                advertTimer++;
            }
            //AutoEnchanting
            try {
                if (pressTime == 0 && enchantAxe) {
                    lp.chatSigned("/enchant sharpness 5", Component.literal(""));
                } else if (pressTime == 20 && enchantAxe) {
                    lp.chatSigned("/enchant smite 5", Component.literal(""));
                } else if (pressTime == 40 && enchantAxe) {
                    lp.chatSigned("/enchant baneofarthropods 5", Component.literal(""));
                } else if (pressTime == 60 && enchantAxe) {
                    lp.chatSigned("/enchant efficiency 5", Component.literal(""));
                } else if (pressTime == 80 && enchantAxe) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                } else if (pressTime == 100 && enchantAxe) {
                    lp.chatSigned("/enchant fortune 3", Component.literal(""));
                } else if (pressTime == 120 && enchantAxe) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                    enchantAxe = false;
                    enchant = false;
                } 
                if (pressTime == 0 && enchantSword) {
                    lp.chatSigned("/enchant sharpness 5", Component.literal(""));
                }
                else if (pressTime == 20 && enchantSword) {
                    lp.chatSigned("/enchant smite 5", Component.literal(""));
                }
                else if (pressTime == 40 && enchantSword) {
                    lp.chatSigned("/enchant baneofarthropods 5", Component.literal(""));
                }
                else if (pressTime == 60 && enchantSword) {
                    lp.chatSigned("/enchant fireaspect 2", Component.literal(""));
                }
                else if (pressTime == 80 && enchantSword) {
                    lp.chatSigned("/enchant looting 3", Component.literal(""));
                }
                else if (pressTime == 100 && enchantSword) {
                    lp.chatSigned("/enchant knockback 2", Component.literal(""));
                }
                else if (pressTime == 120 && enchantSword) {
                    lp.chatSigned("/enchant sweepingedge 3", Component.literal(""));
                }
                else if (pressTime == 140 && enchantSword) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 160 && enchantSword) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                    enchantSword = false;
                    enchant = false;
                }
                if (pressTime == 0 && enchantTool) {
                    lp.chatSigned("/enchant efficiency 5", Component.literal(""));
                }
                else if (pressTime == 20 && enchantTool) {
                    lp.chatSigned("/enchant unbreaking  3", Component.literal(""));
                }
                else if (pressTime == 40 && enchantTool) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                }
                else if (pressTime == 60 && enchantTool) {
                    lp.chatSigned("/enchant fortune 3", Component.literal(""));
                    enchantTool = false;
                    enchant = false;
                }
                if (pressTime == 0 && enchantChest) {
                    lp.chatSigned("/enchant protection 4", Component.literal(""));
                }
                else if (pressTime == 20 && enchantChest) {
                    lp.chatSigned("/enchant fireprotection 4", Component.literal(""));
                }
                else if (pressTime == 40 && enchantChest) {
                    lp.chatSigned("/enchant blastprotection 4", Component.literal(""));
                }
                else if (pressTime == 60 && enchantChest) {
                    lp.chatSigned("/enchant projectileprotection 4", Component.literal(""));
                }
                else if (pressTime == 80 && enchantChest) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 100 && enchantChest) {
                    lp.chatSigned("/enchant thorns 3", Component.literal(""));
                }
                else if (pressTime == 120 && enchantChest) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                    enchantChest = false;
                    enchant = false;
                }

                if (pressTime == 0 && enchantBow) {
                    lp.chatSigned("/enchant power 5", Component.literal(""));
                }
                else if (pressTime == 20 && enchantBow) {
                    lp.chatSigned("/enchant punch 2", Component.literal(""));
                }
                else if (pressTime == 40 && enchantBow) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 60 && enchantBow) {
                    lp.chatSigned("/enchant flame 1", Component.literal(""));
                }
                else if (pressTime == 80 && enchantBow) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                }
                else if (pressTime == 100 && enchantBow) {
                    lp.chatSigned("/enchant infinity 1", Component.literal(""));
                    enchantBow = false;
                    enchant = false;
                }

                if (pressTime == 0 && enchantHelmet) {
                    lp.chatSigned("/enchant protection 4", Component.literal(""));
                }
                else if (pressTime == 20 && enchantHelmet) {
                    lp.chatSigned("/enchant fireprotection 4", Component.literal(""));
                }
                else if (pressTime == 40 && enchantHelmet) {
                    lp.chatSigned("/enchant blastprotection 4", Component.literal(""));
                }
                else if (pressTime == 60 && enchantHelmet) {
                    lp.chatSigned("/enchant projectileprotection 4", Component.literal(""));
                }
                else if (pressTime == 80 && enchantHelmet) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 100 && enchantHelmet) {
                    lp.chatSigned("/enchant thorns 3", Component.literal(""));
                }
                else if (pressTime == 120 && enchantHelmet) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                }
                else if (pressTime == 140 && enchantHelmet) {
                    lp.chatSigned("/enchant respiration 3", Component.literal(""));
                }
                else if (pressTime == 160 && enchantHelmet) {
                    lp.chatSigned("/enchant aquaaffinity 1", Component.literal(""));
                    enchantHelmet = false;
                    enchant = false;
                }
                if (pressTime == 0 && enchantBoots) {
                    lp.chatSigned("/enchant protection 4", Component.literal(""));
                }
                else if (pressTime == 20 && enchantBoots) {
                    lp.chatSigned("/enchant fireprotection 4", Component.literal(""));
                }
                else if (pressTime == 40 && enchantBoots) {
                    lp.chatSigned("/enchant blastprotection 4", Component.literal(""));
                }
                else if (pressTime == 60 && enchantBoots) {
                    lp.chatSigned("/enchant projectileprotection 4", Component.literal(""));
                }
                else if (pressTime == 80 && enchantBoots) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 100 && enchantBoots) {
                    lp.chatSigned("/enchant thorns 3", Component.literal(""));
                }
                else if (pressTime == 120 && enchantBoots) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                }
                else if (pressTime == 140 && enchantBoots) {
                    lp.chatSigned("/enchant depth_strider 3", Component.literal(""));
                }
                else if (pressTime == 160 && enchantBoots) {
                    lp.chatSigned("/enchant featherfalling 4", Component.literal(""));
                    enchantBoots = false;
                    enchant = false;
                }
                if (pressTime == 0 && enchantRod) {
                    lp.chatSigned("/enchant lure 3", Component.literal(""));
                }
                else if (pressTime == 20 && enchantRod) {
                    lp.chatSigned("/enchant luck 3", Component.literal(""));
                }
                else if (pressTime == 40 && enchantRod) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 60 && enchantRod) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                    enchantRod = false;
                    enchant = false;
                }
                if (pressTime == 0 && enchantOther) {
                    lp.chatSigned("/enchant unbreaking 3", Component.literal(""));
                }
                else if (pressTime == 20 && enchantOther) {
                    lp.chatSigned("/enchant mending 1", Component.literal(""));
                    enchantOther = false;
                    enchant = false;
                }
                
                if (enchant) {
                    pressTime++;
                }
            } catch (Exception e) {}
        }
        @SubscribeEvent
        public static void logOff(ClientPlayerNetworkEvent.LoggingOut event) {
            loggedOn = false;
            time = 0;
            enchantSword = false;
            playsound = false;
            enchantTool = false;
            enchantChest = false;
            enchantBow = false;
            enchantHelmet = false;
            enchantBoots = false;
            enchantRod = false;
            enchantOther = false;
            enchantAxe = false;
            enchant = false;
            spawnMobs = false;
            autoFix = false;
        }

        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            HelloCommand.register(event.getDispatcher());
            CalcCommand.register(event.getDispatcher());
            Divide64.register(event.getDispatcher());
            JoinCommand.register(event.getDispatcher());
            HelpCommand.register(event.getDispatcher());
            AutoAdvert.register(event.getDispatcher());
            SetPrefix.register(event.getDispatcher());
            EnchantAllCommand.register((event.getDispatcher()));
            AutoFix.register(event.getDispatcher());
            CommandAliases.register((event.getDispatcher()));
        }
        @SubscribeEvent
        public static void registerCommands(RegisterClientCommandsEvent event) {
            HelloCommand.register(event.getDispatcher());
            CalcCommand.register(event.getDispatcher());
            Divide64.register(event.getDispatcher());
            JoinCommand.register(event.getDispatcher());
            HelpCommand.register(event.getDispatcher());
            AutoAdvert.register(event.getDispatcher());
            SetPrefix.register(event.getDispatcher());
            EnchantAllCommand.register((event.getDispatcher()));
            AutoFix.register(event.getDispatcher());
            CommandAliases.register((event.getDispatcher()));
            AutoPrivate.register(event.getDispatcher());
            AutoSpawnMob.register(event.getDispatcher());
        }
    }
    @Mod.EventBusSubscriber(modid = "sbmod", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.backKey);
            event.register(KeyBinding.jumpKey);
            event.register(KeyBinding.ehomeKey);
            event.register(KeyBinding.craftKey);
            event.register(KeyBinding.homeKey);
            event.register(KeyBinding.ecKey);
        }
    }
}
