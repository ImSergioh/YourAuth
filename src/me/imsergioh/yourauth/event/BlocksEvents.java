package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AdminManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BlocksEvents implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(BlockPlaceEvent event){
        Player player = event.getPlayer();

        if(!AdminManager.isAdmin(player)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEvent(BlockBreakEvent event){
        Player player = event.getPlayer();

        if(!AdminManager.isAdmin(player)){
            event.setCancelled(true);
        }
    }
}
