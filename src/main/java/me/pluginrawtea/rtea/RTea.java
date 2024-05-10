// RTea.java

package me.pluginrawtea.rtea;

import me.pluginrawtea.rtea.commands.BalanceCommand;
import me.pluginrawtea.rtea.commands.RTFollowCommand;
import me.pluginrawtea.rtea.commands.TestCommand;
import me.pluginrawtea.rtea.listeners.*;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class RTea extends JavaPlugin {

    private static Economy econ = null;

    @Override
    public void onEnable() {

        System.out.println("Raw Tea plugin has now started, made by IpanXBread.");

        // --- Hook other plugin's API --- \\
        if (!setupEconomy() ) {
            System.out.println("No Economy plugin found. Disabling Raw Tea plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // --- Listeners --- \\
        getServer().getPluginManager().registerEvents(new TestListener(), this);
        getServer().getPluginManager().registerEvents(new onJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new onChatListener(), this);
        getServer().getPluginManager().registerEvents(new onBlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new onBlockPlaceListener(), this);

        // --- Commands --- \\
        getCommand("followblockmode").setExecutor(new RTFollowCommand(this));
//        getCommand("bitz").setExecutor(new BalanceCommand());

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}
