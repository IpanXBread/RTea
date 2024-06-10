package me.pluginrawtea.rtea.listeners;

import me.pluginrawtea.rtea.RTea;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onKillListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        Economy eco = RTea.getEconomy();
        Player deceased = event.getEntity();

        if (deceased.getKiller() instanceof Player) {
            Player killer = deceased.getKiller();
            EconomyResponse response = eco.depositPlayer(killer, 0.2);
            response = eco.depositPlayer(deceased, 0.05);
        }
    }
}
