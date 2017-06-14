package it.mineblock.easysleep;

import org.bukkit.Bukkit;
import org.bukkit.World;


/**
 * Copyright © 2017 by Lorenzo Magni
 * All rights reserved. No part of this code may be reproduced, distributed, or transmitted in any form or by any means,
 * including photocopying, recording, or other electronic or mechanical methods, without the prior written permission
 * of the creator.
 */
public class Utls {

    public static boolean isPlayerAlone() {
        if(Bukkit.getOnlinePlayers().size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPercentageSatisfied() {
        double neededPercentage = Main.config.getDouble("needed-percentage");
        int sleepingPlayers = Main.sleepingPlayers.size();
        return (sleepingPlayers / Bukkit.getOnlinePlayers().size()) >= neededPercentage;
    }

    public static int getMissingPlayers() {
        double neededPercentage = Main.config.getDouble("needed-percentage");
        int sleepingPlayers = Main.sleepingPlayers.size();
        int neededPlayers = 0;

        while((neededPlayers / Bukkit.getOnlinePlayers().size()) < neededPercentage) {
            neededPlayers ++;
        }

        return neededPlayers - sleepingPlayers;
    }

    public static void timeSetDay(World world) {
        world.setTime(24000L);
        if(world.hasStorm()) {
            world.setStorm(false);
        }
        if(world.isThundering()) {
            world.setThundering(false);
        }
    }

    public static boolean isDay(World world) {
        long time = world.getTime();
        return time > 24000L && time < 13000L;
    }
}
