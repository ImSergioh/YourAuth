package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.util.ServerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        event.setJoinMessage("");
        Player player = event.getPlayer();

        if(plugin.getAccountManager().checkPremium(player)){
            ServerUtil.sendToServer(player, plugin.getPluginConfig().getConfig().getString("hub-server"));
        } else {
            plugin.getAccountManager().announcePlayerAccount(player);
        }
    }
}
