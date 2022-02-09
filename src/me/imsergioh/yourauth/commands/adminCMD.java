package me.imsergioh.yourauth.commands;

import me.imsergioh.yourauth.manager.AdminManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class adminCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            try {
                Player target = Bukkit.getPlayer(String.valueOf(args[0]));
                if(!AdminManager.isAdmin(target)) {
                    AdminManager.registerAdmin(target.getPlayer());
                } else {
                    AdminManager.unregisterAdmin(target.getPlayer());
                }
            } catch (Exception e){}
        }
        return true;
    }
}
