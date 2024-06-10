// RTea.java

package me.pluginrawtea.rtea;

import me.pluginrawtea.rtea.commands.*;
import me.pluginrawtea.rtea.listeners.*;

import me.pluginrawtea.rtea.projects.Race;
import me.pluginrawtea.rtea.sub.RaceTrack;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class RTea extends JavaPlugin {

    private static Economy econ = null;
    private final Map<String, RaceTrack> raceTracks = new HashMap<>();
    private final GroupChatListener groupChatListener = new GroupChatListener();
    private final GroupChatCommand groupChatCommand = new GroupChatCommand(groupChatListener);

    @Override
    public void onEnable() {

        System.out.println("Raw Tea plugin has now started, made by IpanXBread.");

        // --- Ice Boat Race --- \\
        raceTracks.put("IpanXBread_racemap_1", new RaceTrack("IpanXBread_racemap_1", Arrays.asList("1", "2", "3"), "IpanXBread", 2.0, 0.02));
        raceTracks.put("Frog_racemap_1", new RaceTrack("Frog_racemap_1", Arrays.asList("1", "2", "3"), "OffsideFrog5051", 2.0, 0.02));

        // --- Water Boat Race --- \\

        // --- Elytra Race --- \\
        raceTracks.put("IpanXBread_elytra_1", new RaceTrack("IpanXBread_elytra_1", Arrays.asList("1", "2", "3", "4", "5", "6"), "IpanXBread", 5.0, 0.05));

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
        getServer().getPluginManager().registerEvents(new onKillListener(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLogInListener(), this);
        getServer().getPluginManager().registerEvents(groupChatListener, this);

        // --- Commands --- \\
        getCommand("followblockmode").setExecutor(new RTFollowCommand(this));
//        getCommand("bitz").setExecutor(new BalanceCommand());
        getCommand("ibrm").setExecutor(new Race(raceTracks));
        this.getCommand("gchat").setExecutor(groupChatCommand);

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
