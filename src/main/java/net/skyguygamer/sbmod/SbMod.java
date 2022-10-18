package net.skyguygamer.sbmod;


import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.CommandFunction;
import net.minecraft.commands.CommandSigningContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerPlayerConnection;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.profiling.jfr.event.WorldLoadFinishedEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.targets.CommonLaunchHandler;
import net.minecraftforge.fml.loading.targets.FMLClientDevLaunchHandler;
import net.minecraftforge.fml.loading.targets.FMLClientLaunchHandler;
import net.skyguygamer.sbmod.commands.*;
import net.skyguygamer.sbmod.config.SbModClientConfigs;
import org.slf4j.event.LoggingEvent;
import org.spongepowered.asm.mixin.injection.modify.LocalVariableDiscriminator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.swing.text.html.HTML.Tag.S;

//test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(SbMod.MOD_ID)
public class SbMod {
    public static int advertTimer = 0;
    public static Boolean loggedOn = false;
    public static final String MOD_ID = "sbmod";
    //private static final Logger LOGGER = LogUtils.getLogger();

    public SbMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SbModClientConfigs.SPEC, "sbmod-client.toml");
    }




    @Mod.EventBusSubscriber(modid = "sbmod")

    public static class EventHandlers {
        /*@SubscribeEvent
        public static void move(TickEvent.PlayerTickEvent event) {
            Boolean logg = true;
            Vec3 coord = event.player.getPosition(5);
            if ((!event.player.getPosition(5).equals(coord)) && logg) {
                event.player.displayClientMessage((Component.literal("Test")) , false);

            }
            logg = false;

        }
         */
        @SubscribeEvent
        public static void registerCommands(RegisterClientCommandsEvent event) {
            HelloCommand.register(event.getDispatcher());
            AddCommand.register(event.getDispatcher());
            Divide64.register(event.getDispatcher());
            JoinCommand.register(event.getDispatcher());
            HelpCommand.register(event.getDispatcher());
            AutoAdvert.register((event.getDispatcher()));
        }
        @SubscribeEvent
        public static void chat(ClientChatEvent event) {
            if(event.getMessage().contains("d")) {

            }

        }

        @SubscribeEvent
        public static void logOn(ClientPlayerNetworkEvent.LoggingIn event)  {


            Player player = event.getPlayer();

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
                player.displayClientMessage((Component.literal(boarder  + "§a-")), false);
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
                for (int i = 0; i < commands.size(); i++) {
                    //HOWTF DO U SEND MESSAGE AS PLAYER?????
                    LocalPlayer lp = event.getPlayer();
                    //lp.commandSigned("64 600", Component.empty());
                    lp.commandUnsigned(commands.get(i));
                    //Minecraft.getInstance().player.commandUnsigned("64 500");
                    //event.getPlayer().commandUnsigned("64 50");

                    //lp.commandHasSignableArguments("autoadvert message '&aPP'");
                    //player.displayClientMessage(Component.literal(commands.get(i)), false);

                    //ClientCommandHandler.;
                    //System.out.println(commands.get((i)));


                    loggedOn = true;
                }
            }
        }
        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent event) {
            LocalPlayer lp = Minecraft.getInstance().player;
            if (AutoAdvert.sendingmessages) {
                if (advertTimer >= AutoAdvert.interval) {
                    lp.chatSigned(AutoAdvert.message, Component.literal(""));
                    advertTimer = 0;
                }
                advertTimer++;
            }
        }
        @SubscribeEvent
        public static void logOff(ClientPlayerNetworkEvent.LoggingOut event) {
            loggedOn = false;
        }

        //Command Register

    }




    /*
    public SbMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

     */

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    /*
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }

     */

}
