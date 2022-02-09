package me.imsergioh.yourauth.util;

import me.imsergioh.yourauth.YourAuth;

public class Messages {

    public static String noValidSession = fromMessagesConfig("messages.noValidSession");

    public static String chatColor(String text){
        return text.replace("&", "§");
    }

    public static String fromMessagesConfig(String path){
        return chatColor(YourAuth.getPlugin().getMessages().getConfig().getString(path));
    }

}
