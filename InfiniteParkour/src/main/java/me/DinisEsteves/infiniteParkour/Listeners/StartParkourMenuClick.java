package me.DinisEsteves.infiniteParkour.Listeners;

import me.DinisEsteves.infiniteParkour.ParkourManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StartParkourMenuClick implements Listener {
    private final ParkourManager parkourManager;

    public StartParkourMenuClick(ParkourManager parkourManager) {
        this.parkourManager = parkourManager;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Start Infinite Parkour?")) {
            Player player = (Player) event.getWhoClicked();
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case EMERALD_BLOCK:

                    Location playerLocation = player.getLocation();
                    Location blockLocation = playerLocation.clone().add(0, 45, 0);
                    player.teleport(blockLocation);

                    blockLocation.add(0, -1, 0);
                    blockLocation.getBlock().setType(Material.PRISMARINE);
                    parkourManager.addBlock(blockLocation);
                    Location blockLocation2 = blockLocation.clone();
                    blockLocation2.add(2, 0, 0);
                    blockLocation2.getBlock().setType(Material.PRISMARINE);
                    parkourManager.addBlock(blockLocation2);
                    Location blockLocation3 = blockLocation2.clone();
                    blockLocation3.add(2, 0, 0);
                    blockLocation3.getBlock().setType(Material.PRISMARINE);
                    parkourManager.addBlock(blockLocation3);

                    parkourManager.startParkour(player);
                    break;
                case REDSTONE_BLOCK:
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }
}
