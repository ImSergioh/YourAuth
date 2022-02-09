package me.imsergioh.yourauth.commands;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AccountManager;
import me.imsergioh.yourauth.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class registerCMD implements CommandExecutor {

    private YourAuth plugin = YourAuth.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        AccountManager accountManager = plugin.getAccountManager();

        if(args.length >= 2){
            String password = args[0];
            String confirmPassword = args[1];
            accountManager.registerAccount((Player) sender, password, confirmPassword);
        } else {
            sender.sendMessage(Messages.fromMessagesConfig("registerUsage"));
        }
        return true;
    }
}
