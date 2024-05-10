// onJoinListener.java

package me.pluginrawtea.rtea.listeners;

import me.pluginrawtea.rtea.RTea;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLOutput;

public class onJoinListener implements Listener {

    private final RTea plugin;

    public onJoinListener(RTea plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoinServer(PlayerJoinEvent e) {
//        final Player p = e.getPlayer();
        Player joiningPlayer = e.getPlayer();

//        System.out.println("Player should look at south direction..");
//        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
//            @Override
//            public void run() {
//                p.sendMessage("You should look at south direction");
//                Location loc = p.getLocation();
//                loc.setYaw(0);
//                p.teleport(loc);
//            }
//        }, 1L);

        // Play a sound to all online players
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(joiningPlayer)) { // Exclude the joining player
                onlinePlayer.playSound(onlinePlayer.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 100.0f, 100.0f);
            }
        }

    }
}
