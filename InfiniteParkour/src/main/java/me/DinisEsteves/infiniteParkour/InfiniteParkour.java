package me.DinisEsteves.infiniteParkour;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.DinisEsteves.infiniteParkour.Commands.StartInfiniteParkourCommand;
import me.DinisEsteves.infiniteParkour.Listeners.StartParkourMenuClick;
import me.DinisEsteves.infiniteParkour.Listeners.ParkourJumpListener;

public final class InfiniteParkour extends JavaPlugin implements Listener {
    private ParkourManager parkourManager;

    @Override
    public void onEnable() {
        parkourManager = new ParkourManager();
        this.getCommand("parkour").setExecutor(new StartInfiniteParkourCommand());
        getServer().getPluginManager().registerEvents(new StartParkourMenuClick(parkourManager), this);
        getServer().getPluginManager().registerEvents(new ParkourJumpListener(parkourManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
