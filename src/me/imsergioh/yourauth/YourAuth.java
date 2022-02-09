package me.imsergioh.yourauth;

import me.imsergioh.yourauth.util.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class YourAuth extends JavaPlugin {

    private static YourAuth plugin;

    private PluginConfig config;

    @Override
    public void onEnable() {
        plugin = this;

        config = new PluginConfig(plugin.getDataFolder().toString(), "config.yml");
    }

    public static YourAuth getPlugin() {
        return plugin;
    }
}
