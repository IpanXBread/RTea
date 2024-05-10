package me.pluginrawtea.rtea.commands;

import me.pluginrawtea.rtea.RTea;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy economy = RTea.getEconomy();

            if (args.length == 0) {
                player.sendMessage(ChatColor.GREEN + "Current balance: " + economy.format(economy.getBalance(player)));
            }
        }



        return true;
    }
}
