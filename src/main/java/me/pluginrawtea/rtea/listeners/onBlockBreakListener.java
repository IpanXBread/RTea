package me.pluginrawtea.rtea.listeners;

import me.pluginrawtea.rtea.RTea;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Economy eco = RTea.getEconomy();
        Player p = e.getPlayer();

        EconomyResponse response = eco.depositPlayer(p, 0.0025);
    }

}
