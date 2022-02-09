package me.imsergioh.yourauth.manager;

import me.imsergioh.yourauth.instance.Account;

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

    public boolean isRegistered(UUID uuid){
        File file = new File(directory, uuid+".yml");
        return file.exists();
    }

    public Account getAccount(UUID uuid){
        return accountMap.get(uuid);
    }

    private void loadAccount(UUID uuid){
        accountMap.put(uuid, new Account(uuid));
    }

}
