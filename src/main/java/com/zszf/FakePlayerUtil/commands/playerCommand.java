package com.zszf.FakePlayerUtil.commands;

import com.zszf.FakePlayerUtil.PluginMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class playerCommand implements CommandExecutor {

    /**
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     * @return
     */
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        PluginMain.logger.info(Arrays.toString(strings));
        return true;
    }
}
