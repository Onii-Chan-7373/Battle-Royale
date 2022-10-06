package me.beppo.battleroyale.listener;

import me.beppo.battleroyale.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {
    public Main plugin;
    public PlayerJoinListener(Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        final Player p = e.getPlayer();
        if(plugin.joinable){
            e.setJoinMessage(plugin.prefix + p.getName() + " joined the game");
            p.getInventory().clear();
            p.getInventory().setArmorContents(null);
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setAllowFlight(false);
            plugin.online.add(p);
            plugin.playersOnline++;
            World w = Bukkit.getWorld(plugin.cfg.getString("Battleroyal.Lobby.World"));
            double x = plugin.cfg.getDouble("BattleRoyal.Lobby.X");
            double y = plugin.cfg.getDouble("BattleRoyal.Lobby.Y");
            double z = plugin.cfg.getDouble("BattleRoyal.Lobby.Z");
            //p.teleport(new Location(w, x, y, z));
            if(Bukkit.getOnlinePlayers().toArray().length == 2){
                Bukkit.broadcastMessage(plugin.prefix + "the game will start in 10 seconds");
                plugin.startIsReady = true;
            }
        }else {
            p.kickPlayer(plugin.prefix + "The game has already started");
        }
        if(plugin.playersOnline == plugin.start){
            plugin.joinable = false;
            plugin.xpid = 10;
            plugin.exp = plugin.xpid;
            for (Player player : Bukkit.getOnlinePlayers()){
                player.setExp(plugin.exp);
            }
            Bukkit.broadcastMessage(plugin.prefix + "the game will start in 10 seconds");
        }

    }
}
