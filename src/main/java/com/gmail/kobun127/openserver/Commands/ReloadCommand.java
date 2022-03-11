package com.gmail.kobun127.openserver.Commands;

import com.gmail.kobun127.openserver.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ConfigManager.updateConfig();
        sender.sendMessage(ChatColor.GREEN + "[OpenServer] config reloaded.");
        return true;
    }
}
