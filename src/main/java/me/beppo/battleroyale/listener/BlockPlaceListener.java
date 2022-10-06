package me.beppo.battleroyale.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        if(!e.getPlayer().hasPermission("br.build"))
        e.setCancelled(!e.getBlockPlaced().getType().equals(Material.COBWEB));
    }
}
