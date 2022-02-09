package me.imsergioh.yourauth.api;

import me.imsergioh.yourauth.WebUtil;

public class MojangAPI {

    public static String getIDFromUsername(String username){
        try {
            String response = WebUtil.readURL("https://api.mojang.com/users/profiles/minecraft/" + username);
            return response.replace("\"", "").split(",")[1].split(":")[1].replace("}", "")
                    .replace("\n", "");
        } catch (Exception e){return "ERROR";}
    }

}
