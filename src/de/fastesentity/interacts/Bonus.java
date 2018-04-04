package de.fastesentity.interacts;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.fastesentity.utils.ItemCreator;

public class Bonus implements Listener{

	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getPlayer().isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		try {
				if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
					if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {
						Inventory inv = Bukkit.createInventory(null, 27, "§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»");
						inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(9, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(17, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						
						
						inv.setItem(11, ItemCreator.CreateItemwithMaterial(Material.ENDER_CHEST, 0, 1, "§8«§6Truhen§8»", null));
						inv.setItem(13, ItemCreator.CreateItemwithMaterial(Material.EMERALD, 0, 1, "§8«§a§lGadgets§8»", null));
						inv.setItem(15, ItemCreator.CreateItemwithMaterial(Material.DIAMOND_CHESTPLATE, 0, 1, "§8«§6Rewards§8»", null));
						
						inv.setItem(18, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(19, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(20, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(21, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(23, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(22, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(24, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(25, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						inv.setItem(26, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
						e.getPlayer().openInventory(inv);
					}
				}
		} catch (NullPointerException e2) {
			// TODO: handle exceptione
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() == null)return;
		Player p = (Player) e.getWhoClicked();
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		try {
			if(e.getClickedInventory() == e.getWhoClicked().getInventory()) {	
				e.setCancelled(true);
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {		
					if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a")) {				
						e.getWhoClicked().closeInventory();
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {					 
						e.getWhoClicked().closeInventory();
					}else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {
						e.getWhoClicked().closeInventory();
					}
				}
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}
	
	@EventHandler
	public void onClick2(InventoryClickEvent e) {
		if(e.getWhoClicked() == null)return;
		Player p = (Player) e.getWhoClicked();	
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		try {
			if(e.getClickedInventory() == e.getWhoClicked().getInventory()) {	
				e.setCancelled(true);
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8«§6Truhen§8»")) {

					Inventory inv = Bukkit.createInventory(null, 27, "§8«§6Truhen§8»");
					
					inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					
					
					inv.setItem(9, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(12, ItemCreator.CreateItemwithMaterial(Material.CHEST, 15, 0, "§aNormale Truhe", null));
					inv.setItem(14, ItemCreator.CreateItemwithMaterial(Material.ENDER_CHEST, 15, 0, "§b§lUltrachests", null));
					inv.setItem(17, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					
					inv.setItem(18, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(19, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(20, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(21, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(22, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(23, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(24, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(25, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(26, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));	
					e.getWhoClicked().openInventory(inv);
				}	
			}	
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}
	@EventHandler
	public void onClick3(InventoryClickEvent e) {
		if(e.getWhoClicked() == null)return;
		Player p = (Player) e.getWhoClicked();	
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		try {
			if(e.getClickedInventory() == e.getWhoClicked().getInventory()) {	
				e.setCancelled(true);
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8«§6Rewards§8»")) {

					Inventory inv = Bukkit.createInventory(null, 27, "§8«§6Rewards§8»");
					
					ArrayList<String> lore1 = new ArrayList<>();
					lore1.add("§7Kann alle 24 Std. abgeholt");
					lore1.add("§7werden.");
					
					ArrayList<String> lore2 = new ArrayList<>();
					lore2.add("§7Kann alle 7 Tage abgeholt");
					lore2.add("§7werden.");
					
					inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					
					
					inv.setItem(9, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(12, ItemCreator.CreateItemwithMaterial(Material.IRON_INGOT, 0, 1, "§a§lTäglicher Bonus",lore1));
					inv.setItem(14, ItemCreator.CreateItemwithMaterial(Material.GOLD_INGOT, 0, 1, "§a§lWöchentlicher Bonus", lore2));
					inv.setItem(17, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					
					inv.setItem(18, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(19, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(20, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(21, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(22, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(23, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(24, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(25, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));
					inv.setItem(26, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§c", null));	
					e.getWhoClicked().openInventory(inv);
				}	
			}	
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}
}
