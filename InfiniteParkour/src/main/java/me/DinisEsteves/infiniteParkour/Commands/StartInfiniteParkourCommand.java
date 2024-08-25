package me.DinisEsteves.infiniteParkour.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StartInfiniteParkourCommand implements CommandExecutor {
    public Inventory createMenu(Player player) {

        Inventory menu = Bukkit.createInventory(player, 9, ChatColor.BLACK + "Start Infinite Parkour?");

        // Buttons
        ItemStack no = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemStack yes = new ItemStack(Material.EMERALD_BLOCK, 1);

        ItemMeta noMeta = no.getItemMeta();
        noMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "No");
        no.setItemMeta(noMeta);

        ItemMeta yesMeta = yes.getItemMeta();
        yesMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Yes");
        yes.setItemMeta(yesMeta);

        menu.setItem(2, no);
        menu.setItem(6, yes);



        return menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player player) {
                Inventory menu = createMenu(player);
                player.openInventory(menu);
                return true;
            } else {
                sender.sendMessage("This command can only be executed by a player.");
                return false;
            }
    }
}



