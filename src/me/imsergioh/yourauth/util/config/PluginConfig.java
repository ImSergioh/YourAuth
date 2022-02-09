package me.imsergioh.yourauth.util.config;

import me.imsergioh.yourauth.YourAuth;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class PluginConfig {

    private String directoryPath;
    private String fileName;

    private File file;
    private FileConfiguration config;

    public PluginConfig(String directoryPath, String fileName){
        this.directoryPath = directoryPath;
        this.fileName = fileName;
        new File(directoryPath).mkdirs();
        this.file = new File(directoryPath, fileName);
    }

    public void setupFile(boolean copyFromPath){
        if(!file.exists()){
            if(!copyFromPath) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try (InputStream in = YourAuth.getPlugin().getResource(fileName)) {
                    Files.copy(in, file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
