package me.pluginrawtea.rtea.projects;

import me.pluginrawtea.rtea.RTea;
import me.pluginrawtea.rtea.sub.RaceTrack;
import me.pluginrawtea.rtea.util.ActionBarUtil;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class Race implements CommandExecutor {

    private final Map<String, RaceTrack> raceTracks;

    public Race(Map<String, RaceTrack> raceTracks) {
        this.raceTracks = raceTracks;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();
            Economy eco = RTea.getEconomy();
//            String commandName = command.getName().toLowerCase();

            if (args.length == 1 && args[0].equalsIgnoreCase("check")) {
                // ibrm check \\
                player.sendMessage(ChatColor.GRAY + "ibrm checking...");
                for (RaceTrack raceTrack : raceTracks.values()) {
                    Map<UUID, Map<String, Boolean>> playerCommandStates = raceTrack.getPlayerCommandStates();
                    Map<String, Boolean> commandStates = playerCommandStates.get(playerUUID);
                    if (commandStates != null) {
                        player.sendMessage(ChatColor.GOLD + "Track: " + raceTrack.getTrackName());
                        for (Map.Entry<String, Boolean> entry : commandStates.entrySet()) {
                            player.sendMessage(ChatColor.YELLOW + entry.getKey() + " = " + entry.getValue());
                        }
                    }
                }
                return true;
            } else if (args.length >= 2) {
                String subCommand = args[0].toLowerCase();
                String trackName = args[1];
                RaceTrack raceTrack = raceTracks.get(trackName);
                if (subCommand.equals("run")) {
                    // ibrm run racemap \\
                    if (args.length >= 3) {
                        if (raceTrack != null) {
                            // make a key
                            String key = args[1] + "_" + args[2];

                            // make a sound
                            player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_HIT, 1000000.0f, 100.0f);

                            // set key to true for that specific player
                            Map<UUID, Map<String, Boolean>> playerCommandStates = raceTrack.getPlayerCommandStates();
                            Map<String, Boolean> commandStates = playerCommandStates.computeIfAbsent(player.getUniqueId(), k -> new HashMap<>());
                            commandStates.put(key, true);

                            // checks if the user has gone through all the checkpoint :
                            int totalCheckpoints = raceTrack.getTotalCheckpoints();
                            boolean isAllStepsCompleted = true;

                            for (int i = 1; i <= totalCheckpoints; i++) {
                                String checkpoint = Integer.toString(i);
                                if (!commandStates.getOrDefault(trackName + "_" + checkpoint, false)) {
                                    isAllStepsCompleted = false;
                                    break;
                                }
                            }

                            // make an actionbar
                            if (args[2].equals("1")) {
                                if (isAllStepsCompleted) {
                                    player.sendMessage(ChatColor.YELLOW + "[RawTea] - Congrats! $" + raceTrack.getPlayerReward() + " has been added to your account.");
                                    EconomyResponse response = eco.depositPlayer(raceTrack.getCreator(), raceTrack.getCreatorReward());
                                    response = eco.depositPlayer(player, raceTrack.getPlayerReward());
                                    for (String checkpointKey : commandStates.keySet()) {
                                        commandStates.put(checkpointKey, false);
                                    }
                                    ActionBarUtil.sendActionBar(player, "Congratulations!");
                                } else {
                                    ActionBarUtil.sendActionBar(player, "Start!");
                                }
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "[RawTea] - Track to run not found");
                        }
                        return true;
                    } else {
                        player.sendMessage(ChatColor.RED + "[RawTea] Not enough arguments.");
                    }
                } else if (subCommand.equals("debug")) {
                    // ibrm debug racemap \\
                    if (raceTrack != null) {
                        player.sendMessage(ChatColor.GOLD + "Debugging.. " + raceTrack.getTrackName());
                        player.sendMessage(ChatColor.GREEN + "Track Name: " + raceTrack.getTrackName());
                        player.sendMessage(ChatColor.GREEN + "Checkpoints: " + String.join(", ", raceTrack.getCheckpoints()));
                        player.sendMessage(ChatColor.GREEN + "Creator: " + raceTrack.getCreator());
                        player.sendMessage(ChatColor.GREEN + "Player Reward: " + raceTrack.getPlayerReward());
                        player.sendMessage(ChatColor.GREEN + "Creator Reward: " + raceTrack.getCreatorReward());
                    } else {
                        player.sendMessage(ChatColor.RED + "Track to debug not found");
                    }
                } else {
                    // ibrm unknown unknown \\
                    player.sendMessage("Bro what are you trying to do?");
                }
            } else {
                // ibrm \\
                player.sendMessage("Ipans Breaking Record Moment!");
            }
            return true;
        }
        return false;
    }
}
