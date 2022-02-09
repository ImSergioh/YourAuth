package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AdminManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();

        if(!AdminManager.isAdmin(player)){

            if(event.getMessage().startsWith("/login")){return;}
            if(event.getMessage().startsWith("/register")){return;}
            event.setCancelled(true);
        }
    }
}
