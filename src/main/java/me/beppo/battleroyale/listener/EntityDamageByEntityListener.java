package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {
    public Main plugin;
    public EntityDamageByEntityListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void EntityDamagaByEntity(EntityDamageByEntityEvent e){
        e.setCancelled(plugin.friendly);
        if(plugin.dead.contains(e.getDamager())) e.setCancelled(true);
    }
}
