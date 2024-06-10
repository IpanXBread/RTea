package me.pluginrawtea.rtea.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.Arrays;
import java.util.List;

public class onPlayerLogInListener implements Listener {

    @EventHandler
    public void asyncOnPlayerPreLogin (AsyncPlayerPreLoginEvent event) {
        if (event.getName().contains(" ")) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "Your username contains a space, please rename your username.");
        }
    }
}
