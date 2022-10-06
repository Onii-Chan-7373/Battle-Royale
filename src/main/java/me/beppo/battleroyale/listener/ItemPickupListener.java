package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickupListener implements Listener {

    public Main plugin;
    public ItemPickupListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void inItemPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        if(plugin.dead.contains(p)) e.setCancelled(true);
    }
}
