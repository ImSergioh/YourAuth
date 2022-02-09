package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AdminManager;
import me.imsergioh.yourauth.util.ServerUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location loc = event.getFrom();

        if(!AdminManager.isAdmin(player)){
            player.teleport(loc);
        }
    }
}
