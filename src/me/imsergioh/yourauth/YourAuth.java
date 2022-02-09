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
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    public PluginConfig getPluginConfig() {
        return config;
    }

    public static YourAuth getPlugin() {
        return plugin;
    }
}
