package me.pluginrawtea.rtea.commands;

import me.pluginrawtea.rtea.RTea;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TestCommand {

    private final RTea plugin;

    public TestCommand(RTea plugin) {
        this.plugin = plugin;
    }

//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
//
//        if (sender instanceof Player) {
//            Player p = (Player) sender;
//            if (p.hasPermission("rtea.ipanmode")) {
//                if (p.isInvulnerable()) {
//                    p.setInvulnerable(false);
//                    p.sendMessage(ChatColor.RED + "Ipan mode disabled");
//                } else {
//                    p.setInvulnerable(true);
//                    p.sendMessage(ChatColor.GREEN + "Ipan mode enabled");
//                }
//            } else {
//                System.out.println("Only player can run this command");
//            }
//        } else {
//            Player p = (Player) sender;
//            p.sendMessage(ChatColor.RED + "Unfortunately, you are not him...!");
//        }
//        return true;
//    }

//    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
//        Player p = (Player) sender;
//        Block playerBlock = p.getLocation().getBlock();
//        Block blockUnder = playerBlock.getRelative(BlockFace.DOWN); // The block under the player.
//        if (blockUnder.getType() == Material.AIR) {
//            final List<Block> blockList = Arrays.asList(blockUnder, blockUnder.getRelative(BlockFace.EAST), blockUnder.getRelative(BlockFace.WEST), blockUnder.getRelative(BlockFace.NORTH), blockUnder.getRelative(BlockFace.SOUTH), blockUnder.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST), blockUnder.getRelative(BlockFace.NORTH).getRelative(BlockFace.EAST), blockUnder.getRelative(BlockFace.SOUTH).getRelative(BlockFace.WEST), blockUnder.getRelative(BlockFace.SOUTH).getRelative(BlockFace.EAST));
//            for (Block block : blockList) block.setType(Material.BEDROCK);
//            p.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
//                public void run() {
//                    for (Block block : blockList) {
//                        if (block != null && block.getType() == Material.BEDROCK) block.setType(Material.AIR);
//                    }
//                    blockList.clear();
//                }
//            }, 60 * 1200L);
//        }
//        return true;
//    }
}
