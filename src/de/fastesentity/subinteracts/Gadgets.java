package de.fastesentity.subinteracts;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import de.fastesentity.utils.ItemCreator;
import de.fastesentity.utils.Var;

public class Gadgets implements Listener{

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		if (e.getInventory().getName().contains("§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»")) {
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§8«§a§lGadgets§8»")) {
				
				
				ArrayList<String> lore1 = new ArrayList<>();
				lore1.add("§8- §7Sprengt den Boden weg");
				lore1.add("§8- §7Katapultiert Spieler");
				lore1.add("§8- §7Alle 3 Sekunden benutzbar");
				
				ArrayList<String> lore2 = new ArrayList<>();
				lore2.add("§8- §7Zieht dich hinterher");
				lore2.add("§8- §7Kein Cooldown");

				
				
				
				
				e.getWhoClicked().sendMessage(Var.prefix + "§7Dieses Feature ist noch in der §c§lBETA §7Phase.");
				
				Inventory inv = Bukkit.createInventory(null, 27, "§8«§a§lGadgets§8»");
				inv.setItem(0, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(1, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(2, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(3, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(4, ItemCreator.CreateItemwithMaterial(Material.EMERALD, 0, 1, "§8«§a§lGadgets§8»", null));
				inv.setItem(5, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(6, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(7, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(8, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(9, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(17, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				
				
				inv.setItem(11, ItemCreator.CreateItemwithMaterial(Material.TNT, 0, 1, "§4§lT§f§lN§4§lT", lore1));
				inv.setItem(15, ItemCreator.CreateItemwithMaterial(Material.FISHING_ROD, 0, 1, "§9§lEnderHaken",lore2));
				
				inv.setItem(18, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(19, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(20, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(21, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(23, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(22, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(24, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(25, ItemCreator.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 15, 1, "§a", null));
				inv.setItem(26, ItemCreator.CreateItemwithMaterial(Material.BARRIER, 15, 1, "§cGadgets entfernen", null));
				e.getWhoClicked().openInventory(inv);
				
				
				
		        
			}
		}
	}
	
	
	@EventHandler
	public void onClick1(InventoryClickEvent e) {
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
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§a§lGadgets§8»")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cT§fN§cT")) {

					p.getInventory().setItem(4, ItemCreator.CreateItemwithMaterial(Material.TNT, 0, 1, "§4§lT§f§lN§4§lT", null));
					p.sendMessage(Var.prefix + "§7Gadgets : §4§lT§f§lN§4§lT §7wurde ausgerüstet.");
					
					
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
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§a§lGadgets§8»")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§9§lEnderHaken")) {

					p.getInventory().setItem(4, ItemCreator.CreateItemwithMaterial(Material.FISHING_ROD, 0, 1, "§9§lEnderHaken", null));
					p.sendMessage(Var.prefix + "§7Gadget : §9§lEnderHaken §7wurde ausgerüstet.");
					
					
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
			} else if(e.getClickedInventory().getName().equalsIgnoreCase("§8«§a§lGadgets§8»")) {
				if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cGadgets entfernen")) {

					p.getInventory().setItem(5, null);
					p.sendMessage(Var.prefix + "§7Alle Gadgets wurden §c§lentfernt§7.");
					
				}	
			}	
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}

	
}