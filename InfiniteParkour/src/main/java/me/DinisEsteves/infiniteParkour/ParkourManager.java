package me.DinisEsteves.infiniteParkour;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


public class ParkourManager {
    private final Set<String> activePlayers = new HashSet<>();
    private final LinkedList<Location> activeBlocks = new LinkedList<>();
    int score = 0;
    Location beginning = null;

    public void addBlock(Location block) {
        activeBlocks.add(block);
    }

    public boolean isNextBlock(Location block) {
        return block.getBlockX() == activeBlocks.get(1).getBlockX() && block.getBlockY() == activeBlocks.get(1).getBlockY() + 1
        && block.getBlockZ() == activeBlocks.get(1).getBlockZ();
    }
    private static int generateRandom() {
        int value;
        do {
            value = ThreadLocalRandom.current().nextInt(0, 5);
        } while (value == 1);
        return value;
    }

    public void startParkour(Player player) {
        activePlayers.add(player.getName());
        beginning = player.getLocation().add(0, -45, 0);
        // Additional logic to start the parkour
    }

    public void addScore() {
        score += 1;
    }

    public void stopParkour(Player player) {
        activePlayers.remove(player.getName());
        activeBlocks.forEach(block -> {
            block.getBlock().setType(Material.AIR);
        });
        activeBlocks.clear();
        player.teleport(beginning);
        beginning = null;
        player.sendMessage(ChatColor.GREEN + "Your Score Was: " + ChatColor.BOLD + score);
        score = 0;
    }

    public boolean isPlayerInParkour(String player) {
        return activePlayers.contains(player);
    }

    public void genereteNewBlock() {
        activeBlocks.get(0).getBlock().setType(Material.AIR);
        activeBlocks.removeFirst();
        int y = ThreadLocalRandom.current().nextInt(-1, 2);
        int z = generateRandom();
        int x = (z == 0) ?  ThreadLocalRandom.current().nextInt(2, 5) : 0;
        Location newBlock = activeBlocks.get(1).clone().add(x,y,z);
        newBlock.getBlock().setType(Material.PRISMARINE);
        activeBlocks.add(newBlock);
    }
}

