package com.gmail.kobun127.openserver.Commands;

import com.gmail.kobun127.openserver.ConfigManager;
import com.gmail.kobun127.openserver.OpenServer;
import com.gmail.kobun127.openserver.ShellRunner;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenServerCommand implements CommandExecutor, TabCompleter {

    List<String> serverList = new ArrayList<>(ConfigManager.getServerNames());

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("openserver.admin"))
            sender.sendMessage(ChatColor.RED + "[OpenServer] Permission denied.");
        if (args.length != 1) sender.sendMessage(ChatColor.RED + "[OpenServer] Invalid command.");

        String serverName = args[0];
        String scriptPath = ConfigManager.getRunScriptPath(serverName);
        if (scriptPath == null) sender.sendMessage(ChatColor.RED + "[OpenServer] Missing server.");

        new ShellRunner(scriptPath, sender).runTaskAsynchronously(OpenServer.getPlugin());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        switch (args.length) {
            default:
                return null;
            case 1:
                List<String> response = new ArrayList<>(serverList);
                StringUtil.copyPartialMatches(args[0], serverList, response);
                Collections.sort(response);
                return response;
        }
    }
}
