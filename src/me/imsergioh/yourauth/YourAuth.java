package me.imsergioh.yourauth;

import org.bukkit.plugin.java.JavaPlugin;

public class YourAuth extends JavaPlugin {

    private static YourAuth plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    public static YourAuth getPlugin() {
        return plugin;
    }
}
