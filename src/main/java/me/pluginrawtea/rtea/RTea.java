package me.pluginrawtea.rtea;

import me.pluginrawtea.rtea.commands.TestCommand;
import me.pluginrawtea.rtea.listeners.TestListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RTea extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("WWWWWWWWWWWRRRRRRRRRRRRYYYYYYYYYYYYYYYYY");

        // --- Listeners --- \\
        getServer().getPluginManager().registerEvents(new TestListener(), this);

        // --- Commands --- \\
        getCommand("ipanmode").setExecutor(new TestCommand());

    }
}
