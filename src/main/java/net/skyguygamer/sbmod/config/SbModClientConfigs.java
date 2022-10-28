package net.skyguygamer.sbmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SbModClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> welcomemsg;
    public static final ForgeConfigSpec.ConfigValue<Boolean> tognotify;

    static {
        BUILDER.push("Configs for Skyblock Mod");

        welcomemsg = BUILDER.comment("On login message")
                .define("Welcome", true);
        tognotify = BUILDER.comment("Highlights your name in chat")
                .define("Notify", false);


        //HERE DEFINE CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
