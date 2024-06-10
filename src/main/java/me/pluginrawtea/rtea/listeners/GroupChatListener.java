package me.pluginrawtea.rtea.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Logger;

public class GroupChatListener implements Listener {

    private final HashMap<UUID, Boolean> groupChatToggle = new HashMap<>();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (groupChatToggle.getOrDefault(player.getUniqueId(), false)) {
//            String newMessage = "/g " + event.getMessage();
//            event.setMessage(newMessage);
            event.setCancelled(true);
            Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugin("RTea"), () -> {
                String newMessage = event.getMessage();
                player.performCommand("g " + newMessage);
            });
        }
    }

    public void toggleGroupChat(UUID playerUUID) {
        boolean isToggled = groupChatToggle.getOrDefault(playerUUID, false);
        groupChatToggle.put(playerUUID, !isToggled);
    }

    public boolean isGroupChatToggled(UUID playerUUID) {
        return groupChatToggle.getOrDefault(playerUUID, false);
    }

}
