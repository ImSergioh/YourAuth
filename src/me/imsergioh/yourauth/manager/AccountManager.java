package me.imsergioh.yourauth.manager;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.api.MojangAPI;
import me.imsergioh.yourauth.instance.Account;
import me.imsergioh.yourauth.util.Messages;
import me.imsergioh.yourauth.util.ServerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class AccountManager {

    private String dirPath;
    private File directory;
    private HashMap<UUID, Account> accountMap = new HashMap<>();

    public AccountManager(String dirPath){
        new File(dirPath).mkdirs();
        this.directory = new File(dirPath);
    }

    public boolean checkPremium(Player player){
        String mojangID = MojangAPI.getIDFromUsername(player.getName());
        String playerID = player.getUniqueId().toString().replace("-", "");
        if(mojangID.equals(playerID)){
            player.sendMessage(Messages.loginSuccessfully);
            ServerUtil.sendToServer(player, YourAuth.getPlugin().getPluginConfig().getConfig().getString("hub-server"));
            return true;
        }
        return false;
    }

    public void announcePlayerAccount(Player player){
        UUID uuid = player.getUniqueId();

        if(isRegistered(uuid)){
            player.sendMessage(Messages.login);
        } else {
            player.sendMessage(Messages.register);
        }
    }

    public void registerAccount(Player player, String password, String confirmPassword){
        UUID uuid = player.getUniqueId();
        if(!isRegistered(uuid)){
            if(password.equals(confirmPassword)){
                Account account = new Account(uuid, directory);
                account.setPassword(password);
                accountMap.put(uuid, new Account(uuid, directory));
            } else {
                player.sendMessage(Messages.passwordNoMatch);
            }
        } else {
            player.sendMessage(Messages.alreadyRegistered);
        }
    }

    public boolean loginAccount(Player player, String password){
        UUID uuid = player.getUniqueId();
        if(isRegistered(uuid)){
            Account account = getAccount(uuid);
            if(password.equals(account.getPassword())){
                player.sendMessage(Messages.loginSuccessfully);
                ServerUtil.sendToServer(player, YourAuth.getPlugin().getPluginConfig().getConfig().getString("hub-server"));
                return true;
            } else {
                player.kickPlayer(Messages.wrongPassword);
            }
        } else {
            player.sendMessage(Messages.noRegistered);
        }
        return false;
    }

    public void unloadAccount(Player player){
        if(accountMap.containsValue(player.getUniqueId())){
            accountMap.remove(player.getUniqueId());
        }
    }

    public boolean isRegistered(UUID uuid){
        File file = new File(directory, uuid+".yml");
        return file.exists();
    }

    public Account getAccount(UUID uuid){
        if(!accountMap.containsValue(uuid)){
            accountMap.put(uuid, new Account(uuid, directory));
        }
        return accountMap.get(uuid);
    }

}
