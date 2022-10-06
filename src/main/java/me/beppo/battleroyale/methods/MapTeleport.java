package me.beppo.battleroyale.methods;

import me.beppo.battleroyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MapTeleport {
    Main plugin;
    public MapTeleport(Main plugin){
        this.plugin = plugin;
    }
    public void mapteleport(){

        plugin.xpid = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                MapTeleport.this.plugin.exp -= 1;

                for (Player all : Bukkit.getOnlinePlayers()){
                    all.setLevel(MapTeleport.this.plugin.exp);
                }
                if(MapTeleport.this.plugin.exp == 10){
                    Bukkit.broadcastMessage(MapTeleport.this.plugin.prefix + "The game will start in 10 seconds");
                }
                if(MapTeleport.this.plugin.exp == 0){
                    if(Bukkit.getOnlinePlayers().toArray().length > 1){
                        Bukkit.getScheduler().cancelTask(MapTeleport.this.plugin.xpid);
                        MapTeleport.this.plugin.exp = 120;
                        for (Player all : Bukkit.getOnlinePlayers()){
                            all.teleport(all.getLocation().add(0, 200, 0));
                            all.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                            all.setGliding(true);
                        }
                    }
                }
            }
        },0L, 20L);
    }
}
