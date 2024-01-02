package com.zszf.FakePlayerUtil;

import com.zszf.FakePlayerUtil.commands.playerCommand;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.logging.Logger;

public class PluginMain extends JavaPlugin {

    public static JavaPlugin instance;
    public Configuration configuration;
    public static Logger logger;

    @Override
    public void onLoad(){
        saveDefaultConfig();
    }

    @Override
    public void onEnable(){
        configuration = getConfig();
        instance = this;
        logger = getLogger();
        logger.info("Loading Player Util for leaves by zszf!");
        logger.info("Loading Commands!");
        Objects.requireNonNull(getServer().getPluginCommand("player")).setExecutor(new playerCommand());
        logger.info("Complete!");
    }

    @Override
    public void onDisable(){
        logger.info("bye");
    }
}
