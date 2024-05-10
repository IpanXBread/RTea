package me.pluginrawtea.rtea.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Set;

public class onChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String[] words = message.split(" "); // Split the message into words
        Set<String> onlinePlayerNames = new HashSet<>();

        // Get the names of all online players
        for (Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayerNames.add(player.getName().toLowerCase());
        }

        // Iterate through each word in the message
        for (String word : words) {
            // Check if the word matches an online player's name (case-insensitive)
            if (onlinePlayerNames.contains(word.toLowerCase())) {
                // Get the mentioned player by name
                Player mentionedPlayer = Bukkit.getPlayerExact(word);

                // Play a sound for the mentioned player if they are online
                if (mentionedPlayer != null && mentionedPlayer.isOnline()) {
                    mentionedPlayer.playSound(mentionedPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0f, 2.0f);
                }
            }
        }
    }

}
