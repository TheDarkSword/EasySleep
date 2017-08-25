package it.mineblock.easysleep;

import it.mineblock.mbcore.Chat;
import it.mineblock.mbcore.spigot.Config;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

/**
 * Copyright © 2017 by Lorenzo Magni
 * All rights reserved. No part of this code may be reproduced, distributed, or transmitted in any form or by any means,
 * including photocopying, recording, or other electronic or mechanical methods, without the prior written permission
 * of the creator.
 */
public class Main extends JavaPlugin {

    public static FileConfiguration config;
    public static ArrayList<Player> sleepingPlayers = new ArrayList<>();

    private static Config configuration = Config.getInstance();

    public void onEnable() {

        config = configuration.autoloadConfig(this, "config.yml", new File(getDataFolder(), "config.yml"));

        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerSleep(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnPlayerLeaveBed(), this);

        Chat.getLogger("&2EasyBed &aenabled", "info");
    }

    public void onDisable() {
        Chat.getLogger("&2EasyBed &cenabled", "info");
    }

}
