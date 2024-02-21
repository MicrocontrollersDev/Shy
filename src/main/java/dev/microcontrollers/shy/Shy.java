package dev.microcontrollers.shy;

import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import dev.microcontrollers.shy.event.ShyHider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import dev.microcontrollers.shy.config.ShyConfig;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = Shy.MODID, name = Shy.NAME, version = Shy.VERSION)
public class Shy {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    @Mod.Instance(MODID)
    public static Shy INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static ShyConfig config;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ShyConfig();
        MinecraftForge.EVENT_BUS.register(new ShyHider());
    }
}
