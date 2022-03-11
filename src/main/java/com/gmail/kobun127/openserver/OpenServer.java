package com.gmail.kobun127.openserver;

import com.gmail.kobun127.openserver.Commands.OpenServerCommand;
import com.gmail.kobun127.openserver.Commands.ReloadCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class OpenServer extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ConfigManager.initConfig();
        getCommand("openserver").setExecutor(new OpenServerCommand());
        getCommand("openserver").setTabCompleter(new OpenServerCommand());
        getCommand("reloadconfig").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {

    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
