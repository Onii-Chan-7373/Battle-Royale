package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements Listener {
    public Main plugin;
    public PlayerLoginListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e){
        Player p = e.getPlayer();
        if(!plugin.joinable){
            p.kickPlayer(plugin.prefix + " the game is full");
        }
    }
}
