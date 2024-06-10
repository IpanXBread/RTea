package me.pluginrawtea.rtea.commands;

import me.pluginrawtea.rtea.listeners.GroupChatListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GroupChatCommand implements CommandExecutor {

    private final GroupChatListener groupChatListener;

    public GroupChatCommand(GroupChatListener groupChatListener) {
        this.groupChatListener = groupChatListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        UUID playerUUID = player.getUniqueId();

        // Toggle the group chat mode
        groupChatListener.toggleGroupChat(playerUUID);

        if (groupChatListener.isGroupChatToggled(playerUUID)) {
            player.sendMessage(ChatColor.GREEN + "Group chat mode enabled. All your messages will be sent to the group chat.");
        } else {
            player.sendMessage(ChatColor.RED + "Group chat mode disabled. You need to use /g to send messages to the group chat.");
        }

        return true;
    }
}