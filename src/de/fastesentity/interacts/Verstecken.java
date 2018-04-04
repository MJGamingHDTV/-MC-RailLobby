package de.fastesentity.interacts;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;


import de.fastesentity.utils.ItemCreator;
import de.fastesentity.utils.Var;

public class Verstecken implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		try {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8«§6§lVerstecken§8»")) {
					
					Inventory inv = Bukkit.createInventory(null, 9, "§8«§6§lSpieler-Verstecken§8»");
					
					ArrayList<String> lore1 = new ArrayList<>();
					lore1.add("§7Zeigt alle Spieler an");
					inv.setItem(2, ItemCreator.CreateItemwithID(351, 10, 1, "§8» §aAlle Spieler anzeigen", lore1));

					
					ArrayList<String> lore2 = new ArrayList<>();
					lore2.add("§7Zeigt alle VIP´s an");
					inv.setItem(4, ItemCreator.CreateItemwithID(351, 5, 1, "§8» §5VIP´s anzeigen", lore2));
					
					
					
					ArrayList<String> lore3 = new ArrayList<>();
					lore3.add("§7Zeigt keine Spieler an");
					inv.setItem(6, ItemCreator.CreateItemwithID(351, 1, 1, "§8» §cAlle Spieler verstecken", lore3));

					e.getPlayer().openInventory(inv);
					
				}
			}

		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getWhoClicked() == null)
			return;
		Player p = (Player) e.getWhoClicked();
		try {
			if (e.getClickedInventory() == e.getWhoClicked().getInventory()) {
				e.setCancelled(true);
			} else if (e.getClickedInventory().getName().equalsIgnoreCase("§8«§6§lSpieler-Verstecken§8»")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aAlle Spieler anzeigen")) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						p.showPlayer(all);
					}
					p.sendMessage(Var.prefix + "§7Du siehst alle wieder.");
					e.getWhoClicked().closeInventory();
					
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5VIP´s anzeigen")) {
					for(Player all: Bukkit.getOnlinePlayers()) {
						p.hidePlayer(all);
						if(all.hasPermission("rail.team")) {
							p.showPlayer(all);
						}
					}
					p.sendMessage(Var.prefix + "§7Du siehst nun nur noch Teammitglieder.");
					e.getWhoClicked().closeInventory();
					
					
					
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cAlle Spieler verstecken")) {
					for (Player all : Bukkit.getOnlinePlayers()) {
						p.hidePlayer(all);
					}
					p.sendMessage(Var.prefix + "§7Du siehst nun niemanden mehr.");
					e.getWhoClicked().closeInventory();
				}
			}
		} catch (NullPointerException e2) {
			// TODO: handle exception
		}
	}

}
