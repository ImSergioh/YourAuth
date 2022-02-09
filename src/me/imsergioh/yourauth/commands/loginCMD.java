package me.imsergioh.yourauth.commands;

import me.imsergioh.yourauth.YourAuth;
import me.imsergioh.yourauth.manager.AccountManager;
import me.imsergioh.yourauth.util.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class loginCMD implements CommandExecutor {

    private YourAuth plugin = YourAuth.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        AccountManager accountManager = plugin.getAccountManager();

        if(args.length >= 1){
            String password = args[0];
            accountManager.loginAccount((Player) sender, password);
        } else {
            sender.sendMessage(Messages.fromMessagesConfig("loginUsage"));
        }
        return true;
    }
}
