package net.skyguygamer.sbmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SbModClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ore;
    public static final ForgeConfigSpec.ConfigValue<Boolean> welcomemsg;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> jclist;

    static {
        BUILDER.push("Configs for Skyblock Mod");

        jclist = BUILDER.comment("List of join commands")
                .defineList("example_string_list_config_entry", Arrays.asList("c1", "c2"), entry -> true);


        welcomemsg = BUILDER.comment("On login message")
                .define("Welcome", true);

        ore = BUILDER.comment("Ore?")
                .defineInRange("Ore", 50,1,100);
        //HERE DEFINE CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
