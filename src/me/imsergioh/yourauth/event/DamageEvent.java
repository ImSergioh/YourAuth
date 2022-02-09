package me.imsergioh.yourauth.event;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AdminManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    private YourAuth plugin = YourAuth.getPlugin();

    @EventHandler
    public void onEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player) {
            if (!AdminManager.isAdmin((Player) event.getEntity())) {
                event.setCancelled(true);
            }
        }
        if(event.getDamager() instanceof Player) {
            if (!AdminManager.isAdmin((Player) event.getDamager())) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onEvent(EntityDamageEvent event){
        if(event.getEntity() instanceof Player) {
            if (!AdminManager.isAdmin((Player) event.getEntity())) {
                event.setCancelled(true);
            }
        }
    }
}
