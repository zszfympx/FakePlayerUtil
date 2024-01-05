package com.zszf.FakePlayerUtil.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Player implements TabExecutor {
    private static Location location;
    private final String[] length1 = {"spawn", "kill"};
    private final String[] spawnArg1 = {"<BotNameWithoutPrefixAndSuffix>"};
    private final String[] spawnArg2 = {"(At)"};
    private final String[] spawnArg3 = {"<x> <y> <z>"};
    private final String[] killArg1 = {"<BotNameWithPrefixAndSuffix"};

    /**
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     * @return
     */
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String mode = strings[0];
        if (mode.equals("spawn")) {

            String name = strings[1];

            if (!(commandSender instanceof org.bukkit.entity.Player)) {
                try {
                    getLocation(strings);
                } catch (Exception e) {
                    return false;
                }
            } else {
                location = ((org.bukkit.entity.Player) commandSender).getLocation();
                try {
                    getLocation(strings);
                } catch (Exception ignored) {
                }
            }
            Bukkit.dispatchCommand(commandSender, String.format("/bot create %s %s %s %s %s %s", name, name, location.getWorld().getName(), location.getX(), location.getY(), location.getZ()));
            return true;
        } else if (mode.equals("kill")) {
            String name = strings[1];
            Bukkit.dispatchCommand(commandSender, String.format("/bot remove %s", name));
            return true;
        }
        return false;
    }

    private void getLocation(@NotNull String[] strings) {
        double x = Float.parseFloat(strings[3]);
        double y = Float.parseFloat(strings[4]);
        double z = Float.parseFloat(strings[5]);
        location = new Location(Bukkit.getWorlds().get(0), x, y, z);
    }

    /**
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     * @return
     */
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length >= 6) {
            return null;
        }
        if (strings.length == 1) {
            return List.of(length1);
        }
        if (strings.length == 2 && strings[0].equals("spawn")) {
            return List.of(spawnArg1);
        }
        if (strings.length == 3 && strings[1] != null) {
            return List.of(spawnArg2);
        }
        if (strings.length >= 4) {
            return List.of(spawnArg3);
        }
        if (strings.length == 2 && strings[0].equals("kill")) {
            return List.of(killArg1);
        }
        return null;
    }
}
