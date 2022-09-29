package net.skyguygamer.sbmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skyguygamer.sbmod.commands.HelloCommand;
import org.slf4j.Logger;
//test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(SbMod.MOD_ID)
public class SbMod {
    public static final String MOD_ID = "sbmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SbMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        }
    @Mod.EventBusSubscriber(modid = "sbmod")
    public class EventHandlers {
        @SubscribeEvent
        public static void registerCommands(RegisterCommandsEvent event) {
            HelloCommand.register(event.getDispatcher());
        }
    }
}
