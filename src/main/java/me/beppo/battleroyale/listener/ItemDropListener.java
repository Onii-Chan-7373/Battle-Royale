package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {
    public Main plugin;
    public ItemDropListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e){
        if(plugin.dead.contains(e.getPlayer())) e.setCancelled(true);
    }
}
