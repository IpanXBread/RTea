package me.pluginrawtea.rtea.listeners;

import me.pluginrawtea.rtea.RTea;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlotEnter implements Listener {

    // 1. Learn how to read API from other plugins

    private final RTea plugin;

    public onPlotEnter(RTea plugin) {
        this.plugin = plugin;
    }

//    @EventHandler
//    public void onEnteringPlot(PlayerJoinEvent e) {
//        //note that PlayerJoinEvent is just a temporary event, the real event is not discovered yet
//
//        String plotMessage = this.plugin.getConfig().getString("plot-message");
//        if (plotMessage != null) {
//            plotMessage = plotMessage.replace("%player%", e.getPlayer().getDisplayName()); //this one suppose to get the owner of the plot, not the active player
//            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plotMessage));
//        }
//    }
}
