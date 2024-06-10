package me.pluginrawtea.rtea.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBarUtil {

    public static void sendActionBar(Player player, String message) {
        String formattedMessage = ChatColor.YELLOW + "" + ChatColor.ITALIC + message;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(formattedMessage));
    }
}
