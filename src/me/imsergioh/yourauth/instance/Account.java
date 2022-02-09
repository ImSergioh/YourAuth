package me.imsergioh.yourauth.instance;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Account {

    private final UUID uuid;
    private String password;

    private File file;
    private FileConfiguration config;

    public Account(UUID uuid, File accountManagerDirectory){
        this.uuid = uuid;
        this.file = new File(accountManagerDirectory, uuid+".yml");

        regFile();
        checkDefaults();
    }

    public void setPassword(String password){
        this.password = password;
        config.set("password", password);
        saveConfig();
    }

    public String getPassword(){
        return password;
    }

    private void regFile(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    private void checkDefaults(){
        if(config.contains("password")){
            this.password = config.getString("password");
        }
    }

    private void saveConfig(){
        try {
            config.save(file);
        } catch (Exception e){}
    }

}
