package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {
    public Main plugin;
    public PlayerLeaveListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        e.setQuitMessage(plugin.prefix + e.getPlayer().getName() + " left the game");
    }
}
