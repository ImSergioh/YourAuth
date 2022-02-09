package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.util.ServerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class QuitEvent implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();

        plugin.getAccountManager().unloadAccount(player);
    }
}
