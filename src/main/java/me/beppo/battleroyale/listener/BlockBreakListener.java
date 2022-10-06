package me.beppo.battleroyale.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(!e.getPlayer().hasPermission("br.break"))
        e.setCancelled(true);
    }
}
