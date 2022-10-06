package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
    public Main plugin;
    public EntityDamageListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void EntityDamage(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING){e.setCancelled(true);}
        e.setCancelled(plugin.friendly);
    }
}
