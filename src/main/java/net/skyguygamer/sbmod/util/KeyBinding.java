package net.skyguygamer.sbmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_SB = "key.category.sbmod.sb";
    public static final String KEY_JUMP_COMMAND = "key.sbmod.jump.command";
    public static final String KEY_CRAFT_COMMAND = "key.sbmod.craft.command";
    public static final String KEY_ENDERCHEST_COMMAND = "key.sbmod.enderchest.command";
    public static final String KEY_HOME_COMMAND = "key.sbmod.home.command";
    public static final String KEY_BACK_COMMAND = "key.sbmod.back.command";
    public static final String KEY_EHOME_COMMAND = "key.sbmod.ehome.command";


    public static final KeyMapping jumpKey = new KeyMapping(KEY_JUMP_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);
    public static final KeyMapping craftKey = new KeyMapping(KEY_CRAFT_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);
    public static final KeyMapping ecKey = new KeyMapping(KEY_ENDERCHEST_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);
    public static final KeyMapping homeKey = new KeyMapping(KEY_HOME_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);
    public static final KeyMapping backKey = new KeyMapping(KEY_BACK_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);
    public static final KeyMapping ehomeKey = new KeyMapping(KEY_EHOME_COMMAND, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, KEY_CATEGORY_SB);

}
