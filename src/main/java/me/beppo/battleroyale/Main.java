package me.beppo.battleroyale;

import me.beppo.battleroyale.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class Main extends JavaPlugin implements Listener {

    public String prefix = "[Battle Royal] ";

    public ArrayList<Player> dead = new ArrayList<Player>();
    public ArrayList<Player> online = new ArrayList<Player>();

    public HashMap<Location, Inventory> brchest = new HashMap<Location, Inventory>();
    public HashMap<Location, Inventory> deathChest = new HashMap<Location, Inventory>();
    public HashMap<Location, Inventory> opChest = new HashMap<Location, Inventory>();

    public File file = new File("plugins/BattleRoyal", "config.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);

    public boolean joinable;
    public boolean friendly;

    public int xpid;
    public int exp;

    public int start;
    public int playersOnline;

    public boolean startIsReady;

    @Override
    public void onEnable() {
        RegisterEvents();

        startIsReady = false;

        joinable = true;
        friendly = true;

        exp = 120;
        start = 2;
        playersOnline = 0;
        BukkitRunnable runnable = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {
                if(startIsReady && exp > 0){
                    exp = 10;
                    for (Player all : Bukkit.getOnlinePlayers()){
                        all.setLevel(exp);
                        exp--;
                    }
                }else if (exp > 0){
                    for (Player all : Bukkit.getOnlinePlayers()){
                         all.setLevel(exp);
                         exp--;
                    }
                }else {
                    StartGame();
                    startIsReady = false;
                }
            }
        };
        runnable.runTaskTimer(this, 20L, 20L);

    }

    public void StartGame(){
        for (Player toShow : Bukkit.getServer().getOnlinePlayers()) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (player != toShow) {
                    player.showPlayer(toShow);
                }
            }
        }
        for (Player all : Bukkit.getOnlinePlayers()){
            all.getInventory().clear();
            all.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
            all.setAllowFlight(false);
            all.setGameMode(GameMode.SURVIVAL);
            all.teleport(all.getLocation().add(0, 30, 0));
            all.setHealth(20.0);
            all.setSaturation(20);
            friendly = false;
            joinable = true;
            dead.remove(all);
            online.add(all);
            brchest.clear();
        }
    }

    public void RegisterEvents(){
        Bukkit.getPluginManager().registerEvents(new chestManager(this), this);
        Bukkit.getPluginManager().registerEvents(new ElytraLandingListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new ItemPickupListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ItemDropListener(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new FoodChangeListener(this), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(this), this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(label.equalsIgnoreCase("battleroyal")){
            Player p = (Player)  sender;
            if(args.length == 1){
                if (args[0].equalsIgnoreCase("start")){
                    if(sender.hasPermission("br.start")){
                        for (Player all : Bukkit.getOnlinePlayers()){
                            all.teleport(all.getLocation().add(0, 20, 0));
                            all.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                            friendly = false;
                        }
                    }
                } else if (args[0].equalsIgnoreCase("setlobby")){
                    if(sender.hasPermission("br.setlobby")){
                        cfg.set("Battleroyal.Lobby.World", p.getWorld().getName());
                        cfg.set("Battleroyal.Lobby.X", p.getLocation().getX());
                        cfg.set("Battleroyal.Lobby.Y", p.getLocation().getY());
                        cfg.set("Battleroyal.Lobby.Z", p.getLocation().getZ());
                        cfg.set("Battleroyal.Lobby.Yaw", p.getLocation().getYaw());
                        cfg.set("Battleroyal.Lobby.Pitch", p.getLocation().getPitch());
                        try {
                            cfg.save(file);
                            p.sendMessage(prefix + "Die Lobby wurde gesetzt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        if(label.equalsIgnoreCase("brstart")){
            int n = 0;
            for (Player toShow : Bukkit.getServer().getOnlinePlayers()) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (player != toShow) {
                        player.showPlayer(toShow);
                    }
                }
            }
            for (Player all : Bukkit.getOnlinePlayers()){
                all.getInventory().clear();
                all.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                all.setAllowFlight(false);
                all.setGameMode(GameMode.SURVIVAL);
                all.teleport(all.getLocation().add(0, 30, 0));
                all.setHealth(20.0);
                all.setSaturation(20);
                friendly = false;
                joinable = true;
                dead.remove(all);
                online.add(all);
                brchest.clear();
            }
        }
        if(label.equalsIgnoreCase("brjoinable")){
            joinable = true;
        }
        return false;
    }
}
