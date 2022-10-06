package me.beppo.battleroyale.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class ElytraLandingListener implements Listener {
    @EventHandler
    public void onElytraFly(EntityToggleGlideEvent e){
        Player p = (Player) e.getEntity();
        if(!e.isGliding()){
            p.getInventory().setChestplate(null);
        }
    }
}
