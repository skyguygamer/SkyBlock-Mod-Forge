package net.skyguygamer.sbmod;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.skyguygamer.sbmod.commands.AddCommand;
import net.skyguygamer.sbmod.commands.Divide64;
import net.skyguygamer.sbmod.commands.HelloCommand;
import net.skyguygamer.sbmod.commands.JoinCommand;
import net.skyguygamer.sbmod.config.SbModClientConfigs;
import org.slf4j.Logger;
//test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(SbMod.MOD_ID)
public class SbMod {

    public static final String MOD_ID = "sbmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SbMod() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SbModClientConfigs.SPEC, "sbmod-client.toml");
    }

    @Mod.EventBusSubscriber(modid = "sbmod")
    public class EventHandlers {
        @SubscribeEvent
        public static void logOn(PlayerEvent.PlayerLoggedInEvent event) {
            Player player = event.getEntity();

            //Login message
            if (SbModClientConfigs.welcomemsg.get()) {
                String boarder = "";
                for (int i = 0; i < 20; i++) {
                    boarder += "§a-";
                    boarder += "§2=";
                }
                player.displayClientMessage((Component.literal(boarder + "§a-")), false);
                player.displayClientMessage(Component.literal("§7Skyblock Mod for forge 1.19.2"), false);
                player.displayClientMessage((Component.literal("§7Updated version 3.0 §cBETA")), false);
                player.displayClientMessage((Component.literal("§7Type /shelp for list of commands")), false);
                player.displayClientMessage((Component.literal(boarder  + "§a-")), false);
            }
        }

        //Commands
        @SubscribeEvent
        public static void registerCommands(RegisterClientCommandsEvent event) {
            HelloCommand.register(event.getDispatcher());
            AddCommand.register(event.getDispatcher());
            Divide64.register(event.getDispatcher());
            JoinCommand.register(event.getDispatcher());
        }
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
