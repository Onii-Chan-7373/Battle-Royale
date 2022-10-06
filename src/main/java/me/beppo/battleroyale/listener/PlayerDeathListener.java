package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class PlayerDeathListener implements Listener {
    public Main plugin;
    public PlayerDeathListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        Location deathloc = p.getLocation();
        p.setHealth(20.0);
        e.setDeathMessage(plugin.prefix + p.getName() + " died");
        Inventory lootChest = p.getInventory();
        p.spigot().respawn();
        p.teleport(deathloc);
        p.getWorld().strikeLightning(p.getLocation());
        p.setHealth(20.0);
        p.setFireTicks(0);
        p.setFoodLevel(20);
        p.setAllowFlight(true);
        plugin.online.remove(p);
        plugin.dead.add(p);
        p.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
        p.getLocation().getBlock().setType(Material.DIAMOND_BLOCK);
        plugin.deathChest.put(p.getLocation(), lootChest);
        for (Player all : Bukkit.getOnlinePlayers()){
            all.hidePlayer(p);
        }
        if(plugin.dead.size() == Bukkit.getOnlinePlayers().toArray().length -1){
            Bukkit.broadcastMessage(plugin.online.get(0).toString() + " won the game");
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player all : Bukkit.getOnlinePlayers()){
                        all.kickPlayer(plugin.prefix + "Server is restarting");
                    }
                    Bukkit.shutdown();
                }
            });
        }
    }
}
