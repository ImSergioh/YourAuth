package me.imsergioh.yourauth.util;

import me.imsergioh.yourauth.YourAuth;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class ServerUtil {

    public static void sendToServer(Player player, String server){
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage(YourAuth.getPlugin(), "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.RED+"Error when trying to connect to "+server);
        }
    }

}
