package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class InteractListener implements Listener {
    public Main plugin;
    public InteractListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(plugin.dead.size() != 0)
            if(p.getItemInHand().getType() == Material.COMPASS)
                if(plugin.dead.contains(p)){
                    if((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
                        Inventory inv = Bukkit.createInventory(null, 27, "Spectate Players");
                        if(p.getItemInHand().getType() != Material.AIR)
                        if(p.getItemInHand().getType() == Material.COMPASS){
                            int n = 0;
                            for(Player all: Bukkit.getOnlinePlayers()){
                                if(!plugin.dead.contains(all)){
                                ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                                SkullMeta meta = (SkullMeta) head.getItemMeta();
                                meta.setOwningPlayer(all);
                                meta.setDisplayName(all.getDisplayName());
                                head.setItemMeta(meta);
                                inv.setItem(n, head);
                                n++;
                                }
                            }
                            p.openInventory(inv);
                        }
                    }
                }
    }
}
