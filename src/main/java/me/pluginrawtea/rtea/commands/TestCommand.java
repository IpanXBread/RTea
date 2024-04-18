package me.pluginrawtea.rtea.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isInvulnerable()) {
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.RED + "Ipan mode disabled");
            } else {
                p.setInvulnerable(true);
                p.sendMessage(ChatColor.GREEN + "Ipan mode enabled");
            }
        } else {
            System.out.println("Only player can run this command");
        }

        return true;
    }
}
