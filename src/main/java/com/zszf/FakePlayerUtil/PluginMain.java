package com.zszf.FakePlayerUtil;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PluginMain extends JavaPlugin {
    public static Configuration configuration;
    public static JavaPlugin instance;
    public static Logger logger;

    @Override
    public void onLoad(){
        saveDefaultConfig();
    }
    @Override
    public void onEnable(){
        instance = this;
        configuration = getConfig();
        logger = getLogger();
    }
}
