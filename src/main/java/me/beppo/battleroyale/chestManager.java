package me.beppo.battleroyale;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class chestManager extends ItemStack implements Listener{

    private Main plugin;
    public  chestManager(Main plugin){
        this.plugin = plugin;
    }



    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK &&
            e.getClickedBlock().getType() == Material.REDSTONE_BLOCK){
            if(!plugin.dead.contains(p))
                if (this.plugin.brchest.containsKey(e.getClickedBlock().getLocation())){
                    p.playSound(plugin.brchest.get(e.getClickedBlock().getLocation()).getLocation(), Sound.BLOCK_NOTE_BLOCK_FLUTE, 10, 1);
                    p.openInventory(this.plugin.brchest.get(e.getClickedBlock().getLocation()));
                } else {
                    Random rnd = new Random();
                    int n = 1;
                    n = rnd.nextInt(10);
                    Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);
                    List<ItemStack> items = new ArrayList<ItemStack>();

                    items.add(new ItemStack(Material.DIAMOND));
                    items.add(new ItemStack(Material.APPLE));
                    items.add(new ItemStack(Material.BAKED_POTATO));
                    items.add(new ItemStack(Material.COOKED_CHICKEN));
                    items.add(new ItemStack(Material.WOODEN_AXE));
                    items.add(new ItemStack(Material.ARROW));
                    items.add(new ItemStack(Material.STICK));
                    items.add(new ItemStack(Material.APPLE));
                    items.add(new ItemStack(Material.BAKED_POTATO));
                    items.add(new ItemStack(Material.COOKED_CHICKEN));
                    items.add(new ItemStack(Material.WOODEN_AXE));
                    items.add(new ItemStack(Material.ARROW));
                    items.add(new ItemStack(Material.STICK));
                    items.add(new ItemStack(Material.APPLE));
                    items.add(new ItemStack(Material.BAKED_POTATO));
                    items.add(new ItemStack(Material.COOKED_CHICKEN));
                    items.add(new ItemStack(Material.WOODEN_AXE));
                    items.add(new ItemStack(Material.ARROW));
                    items.add(new ItemStack(Material.STICK));
                    items.add(new ItemStack(Material.APPLE));
                    items.add(new ItemStack(Material.BAKED_POTATO));
                    items.add(new ItemStack(Material.COOKED_CHICKEN));
                    items.add(new ItemStack(Material.WOODEN_AXE));
                    items.add(new ItemStack(Material.ARROW));
                    items.add(new ItemStack(Material.STICK));

                    items.add(new ItemStack(Material.STONE_SWORD));
                    items.add(new ItemStack(Material.STONE_SWORD));
                    items.add(new ItemStack(Material.STONE_SWORD));
                    items.add(new ItemStack(Material.STONE_SWORD));

                    items.add(new ItemStack(Material.WOODEN_SWORD));
                    items.add(new ItemStack(Material.WOODEN_SWORD));
                    items.add(new ItemStack(Material.WOODEN_SWORD));
                    items.add(new ItemStack(Material.WOODEN_SWORD));
                    items.add(new ItemStack(Material.WOODEN_SWORD));
                    items.add(new ItemStack(Material.WOODEN_SWORD));

                    items.add(new ItemStack(Material.IRON_SWORD));
                    items.add(new ItemStack(Material.GOLDEN_SWORD));
                    items.add(new ItemStack(Material.GOLDEN_SWORD));


                    items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
                    items.add(new ItemStack(Material.LEATHER_BOOTS));
                    items.add(new ItemStack(Material.LEATHER_LEGGINGS));
                    items.add(new ItemStack(Material.LEATHER_HELMET));
                    items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
                    items.add(new ItemStack(Material.LEATHER_BOOTS));
                    items.add(new ItemStack(Material.LEATHER_LEGGINGS));
                    items.add(new ItemStack(Material.LEATHER_HELMET));
                    items.add(new ItemStack(Material.LEATHER_CHESTPLATE));
                    items.add(new ItemStack(Material.LEATHER_BOOTS));
                    items.add(new ItemStack(Material.LEATHER_LEGGINGS));
                    items.add(new ItemStack(Material.LEATHER_HELMET));

                    items.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                    items.add(new ItemStack(Material.CHAINMAIL_BOOTS));
                    items.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                    items.add(new ItemStack(Material.CHAINMAIL_HELMET));

                    items.add(new ItemStack(Material.GOLDEN_BOOTS));
                    items.add(new ItemStack(Material.GOLDEN_CHESTPLATE));
                    items.add(new ItemStack(Material.GOLDEN_HELMET));
                    items.add(new ItemStack(Material.GOLDEN_LEGGINGS));
                    items.add(new ItemStack(Material.GOLDEN_BOOTS));
                    items.add(new ItemStack(Material.GOLDEN_CHESTPLATE));
                    items.add(new ItemStack(Material.GOLDEN_HELMET));
                    items.add(new ItemStack(Material.GOLDEN_LEGGINGS));

                    items.add(new ItemStack(Material.IRON_BOOTS));
                    items.add(new ItemStack(Material.IRON_LEGGINGS));

                    while(n != 0){
                        n--;
                        Random rnd2 = new Random();
                        Random rnd3 = new Random();

                        int n2 = rnd2.nextInt(27);
                        int n3 = rnd3.nextInt(items.size());

                        inv.setItem(n2, (ItemStack)items.get(n3));
                    }
                    this.plugin.brchest.put(e.getClickedBlock().getLocation(), inv);
                    p.openInventory(inv);
                    p.playSound(plugin.brchest.get(e.getClickedBlock().getLocation()).getLocation(), Sound.BLOCK_NOTE_BLOCK_FLUTE, 100, 1);
                }
            }else if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.EMERALD_BLOCK) {
            if (this.plugin.brchest.containsKey(e.getClickedBlock().getLocation())) {
                p.openInventory((Inventory) this.plugin.brchest.get(e.getClickedBlock().getLocation()));
            } else {
                Random rnd = new Random();
                Inventory inv = Bukkit.createInventory(null, InventoryType.CHEST);

                Random rnd2 = new Random();
                Random rnd3 = new Random();

                int n2 = rnd2.nextInt(27);

                inv.setItem(n2, new ItemStack(Material.ELYTRA));

                this.plugin.brchest.put(e.getClickedBlock().getLocation(), inv);
                p.openInventory(inv);
                }
            }
            else if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().equals(Material.DIAMOND_BLOCK)){
                if(!plugin.dead.contains(p)){
                    p.openInventory(plugin.deathChest.get(e.getClickedBlock().getLocation()));
                }
            }else if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType().equals(Material.GOLD_BLOCK)){
                if(this.plugin.opChest.containsKey(e.getClickedBlock().getLocation())){

                }
        }
        }
    }
