package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodChangeListener implements Listener {
    public Main plugin;
    public FoodChangeListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e){
        e.setCancelled(plugin.friendly);
    }
}
