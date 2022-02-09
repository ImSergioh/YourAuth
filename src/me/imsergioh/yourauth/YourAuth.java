package me.imsergioh.yourauth;

import me.imsergioh.yourauth.manager.AccountManager;
import me.imsergioh.yourauth.util.config.PluginConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class YourAuth extends JavaPlugin {

    private static YourAuth plugin;

    private PluginConfig config;
    private AccountManager accountManager;

    @Override
    public void onEnable() {
        plugin = this;

        config = new PluginConfig(plugin.getDataFolder().toString(), "config.yml");
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        accountManager = new AccountManager(this.getDataFolder()+"/accounts");
    }

    public PluginConfig getPluginConfig() {
        return config;
    }

    public static YourAuth getPlugin() {
        return plugin;
    }
}
