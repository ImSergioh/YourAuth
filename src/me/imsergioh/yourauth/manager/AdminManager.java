package me.imsergioh.yourauth.manager;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class AdminManager {

    public static ArrayList<UUID> adminUUIDList;

    public static void registerAdmin(Player player){
        if(adminUUIDList == null){
            adminUUIDList = new ArrayList<>();
        }
        adminUUIDList.add(player.getUniqueId());
    }

    public static boolean isAdmin(Player player){
        if(adminUUIDList != null){
            if(adminUUIDList.contains(player.getUniqueId())){
                return true;
            }
        }
        return false;
    }

    public static void unregisterAdmin(Player player){
        if(isAdmin(player)) {
            adminUUIDList.remove(player.getUniqueId());
        }
    }

}
