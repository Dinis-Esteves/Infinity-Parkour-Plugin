package me.DinisEsteves.infiniteParkour.Listeners;

import me.DinisEsteves.infiniteParkour.ParkourManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;

public class ParkourJumpListener implements Listener {
    private final ParkourManager parkourManager;

    public ParkourJumpListener(ParkourManager parkourManager) {
        this.parkourManager = parkourManager;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (parkourManager.isPlayerInParkour(player.getName())) {
            if (parkourManager.isNextBlock(event.getTo())) {
                parkourManager.genereteNewBlock();
                parkourManager.addScore();
            } if (player.getFallDistance() >= 5) {
                parkourManager.stopParkour(player);
            }
        }
    }
}
