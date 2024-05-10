// RTFollowCommand.java

package me.pluginrawtea.rtea.commands;

import me.pluginrawtea.rtea.RTea;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RTFollowCommand implements CommandExecutor {

    private final RTea plugin;

    public RTFollowCommand(RTea plugin) {
        this.plugin = plugin;
    }

    // For Conditional Invulnerable Mode and not everyone has the permission
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("rtea.FollowingSpawnBlock")) {
                if (p.isInvulnerable()) {
//                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "Following Spawn Block mode disabled");
                } else {
//                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "Following Spawn Block mode enabled");
                }
            } else {
                System.out.println("Only player can run this command");
            }
        } else {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.RED + "Unfortunately, you are not him...!");
        }
        return true;

    }
}
