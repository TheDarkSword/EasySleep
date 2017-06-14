package it.mineblock.easysleep;

import it.mineblock.mbcore.Chat;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

/**
 * Copyright © 2017 by Lorenzo Magni
 * All rights reserved. No part of this code may be reproduced, distributed, or transmitted in any form or by any means,
 * including photocopying, recording, or other electronic or mechanical methods, without the prior written permission
 * of the creator.
 */
public class OnPlayerSleep implements Listener {

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        int onlinePlayers = Bukkit.getOnlinePlayers().size();

        Main.sleepingPlayers.add(player);

        if (Utls.isPlayerAlone()) {
            return;
        }

        if (Utls.isPercentageSatisfied()) {
            for (Player receiver : Bukkit.getOnlinePlayers()) {
                Chat.send(Message.SLEEP_SKIP.getReplaced(new String[]{
                        "{player}",
                        "{sleeping}",
                        "{online}"
                }, new String[]{
                        player.getDisplayName(),
                        String.valueOf(Main.sleepingPlayers.size()),
                        String.valueOf(onlinePlayers)
                }), receiver);
                Utls.timeSetDay(world);
            }
        } else {
            for (Player receiver : Bukkit.getOnlinePlayers()) {
                Chat.send(Message.SLEEP_MISSING.getReplaced(new String[]{
                        "{player}",
                        "{sleeping}",
                        "{online}",
                        "{missing}"
                }, new String[]{
                        player.getDisplayName(),
                        String.valueOf(Main.sleepingPlayers.size()),
                        String.valueOf(onlinePlayers),
                        String.valueOf(Utls.getMissingPlayers())
                }), receiver);
            }
        }
    }
}
