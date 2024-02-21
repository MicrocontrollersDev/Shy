package dev.microcontrollers.shy.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Button;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import dev.microcontrollers.shy.Shy;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ShyConfig extends Config {
    @Switch(
            name = "Enabled",
            description = "The master toggle for hiding players.",
            subcategory = "General"
    )
    public static boolean toggled = false;

    @Switch(
            name = "Ignore Mobs",
            description = "When enabled, mobs will still render when near.",
            subcategory = "General"
    )
    public static boolean ignoreMobs = true;

    @Switch(
            name = "Ignore NPCs",
            description = "When enabled, NPCs on Hypixel will still render when near, but their armorstands will not. Check \"Ignore Armorstands\" for that.",
            subcategory = "General"
    )
    public static boolean ignoreNPCs = true;

    @Switch(
            name = "Ignore Armorstands",
            description = "When enabled, Armorstands will still render when near.",
            subcategory = "General"
    )
    public static boolean ignoreArmorstands = true;

    @Slider(
            name = "Distance Slider",
            description = "Measured in blocks.",
            subcategory = "General",
            min = 0, max = 10,
            step = 1
    )
    public static int distance = 10;

    @Button(
            name = "Join the Discord",
            text = "Click!",
            subcategory = "Socials"
    )
    Runnable discord = () -> {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://discord.gg/rejfv9kFJj"));
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public ShyConfig() {
        super(new Mod(Shy.NAME, ModType.UTIL_QOL), Shy.MODID + ".json");
        initialize();

        addDependency("hypixelCheck", "enabled");
    }
}

