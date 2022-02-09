package me.imsergioh.yourauth;

import me.imsergioh.yourauth.commands.adminCMD;
import me.imsergioh.yourauth.commands.loginCMD;
import me.imsergioh.yourauth.commands.registerCMD;
import me.imsergioh.yourauth.event.*;
import me.imsergioh.yourauth.manager.AccountManager;
import me.imsergioh.yourauth.util.config.PluginConfig;
import net.minecraft.server.v1_8_R3.Blocks;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class YourAuth extends JavaPlugin {

    private static YourAuth plugin;

    private PluginConfig config;
    private PluginConfig messages;
    private AccountManager accountManager;

    @Override
    public void onEnable() {
        plugin = this;

        config = new PluginConfig(plugin.getDataFolder().toString(), "config.yml");
        config.setupFile(true);

        messages = new PluginConfig(plugin.getDataFolder().toString(), "messages.yml");
        messages.setupFile(true);

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        accountManager = new AccountManager(this.getDataFolder()+"/accounts");

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinEvent(), this);
        pm.registerEvents(new QuitEvent(), this);
        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new BlocksEvents(), this);
        pm.registerEvents(new CommandEvent(), this);

        getCommand("register").setExecutor(new registerCMD());
        getCommand("login").setExecutor(new loginCMD());
        getCommand("admin").setExecutor(new adminCMD());
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public PluginConfig getMessages() {
        return messages;
    }

    public PluginConfig getPluginConfig() {
        return config;
    }

    public static YourAuth getPlugin() {
        return plugin;
    }
}
