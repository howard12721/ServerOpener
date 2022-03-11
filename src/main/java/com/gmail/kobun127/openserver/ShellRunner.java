package com.gmail.kobun127.openserver;

import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellRunner extends BukkitRunnable {

    public ShellRunner(String path, CommandSender executor) {
        shellPath = path;
        this.executor = executor;
    }

    String shellPath;
    CommandSender executor;

    @Override
    public void run() {
        try {
            Process process;
            process = Runtime.getRuntime().exec("bash " + shellPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String result;
            while ((result = reader.readLine()) != null) {
                executor.sendMessage(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
