package com.gmail.kobun127.openserver;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Set;

public class ConfigManager {

    private ConfigManager() {
    }

    public static void initConfig() {
        OpenServer.getPlugin().saveDefaultConfig();
    }

    public static void updateConfig() {
        OpenServer.getPlugin().reloadConfig();
    }

    public static Set<String> getServerNames() {
        FileConfiguration config = OpenServer.getPlugin().getConfig();
        ConfigurationSection section = config.getConfigurationSection("servers");
        return section.getKeys(false);
    }

    public static String getRunScriptPath(String serverName) {
        FileConfiguration config = OpenServer.getPlugin().getConfig();
        return config.getString("servers." + serverName + ".run-script-path");
    }
}