package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    public Main plugin;
    public InventoryClickListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(plugin.dead.contains(p)){
            e.setCancelled(true);
            if(p.getOpenInventory().getTitle().equals("Spectate Players")){
                p.teleport(Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName()).getLocation());
            }
        }
    }
}
