package me.pluginrawtea.rtea.listeners;

import me.pluginrawtea.rtea.RTea;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FollowingBlockMode extends BukkitRunnable {

    private final RTea plugin;

    public FollowingBlockMode(RTea plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("rtea.FollowingSpawnBlock")) { // Check if player has permission
                Location playerLocation = player.getLocation();
                Location spawnLocation = playerLocation.clone().subtract(0, 1, 0); // Subtract 1 from Y coordinate

                // Spawn stone block at the calculated location
                player.getWorld().getBlockAt(spawnLocation).setType(Material.STONE);
            }
        }
    }

}
