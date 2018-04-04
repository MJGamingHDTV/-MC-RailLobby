package de.fastesentity.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.fastesentity.main.Main;
import de.fastesentity.utils.ItemCreator;
import de.fastesentity.utils.LocationUtil;
import de.fastesentity.utils.Title;
import de.fastesentity.utils.Var;

public class Join implements Listener {
	

	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);

		p.sendMessage(Var.prefix + "Willkommen auf §6RailCraft.de§7.");
		Title.sendActionBar(p, Var.prefix + "Willkommen auf §6RailCraft.de§7.");
		p.getInventory().clear();

		p.getInventory().setItem(0,ItemCreator.CreateItemwithMaterial(Material.COMPASS, 0, 1, "§8«§7§lNavigator§8»", null));
		p.getInventory().setItem(1,ItemCreator.CreateItemwithMaterial(Material.BLAZE_ROD, 0, 1, "§8«§6§lVerstecken§8»", null));
		
		//p.getInventory().setItem(3, ItemCreator.CreateItemwithMaterial(Material.BOOK, 0, 1, "§8«§5§lEinstellungen§8»", null));
		
		
		// SLOT 5 SIND GADGETS
		
		p.getInventory().setItem(6, ItemCreator.CreateItemwithMaterial(Material.CHEST, 0, 1, "§8«§6§lB§5§lo§4§ln§3§lu§2§ls§8»", null));
		p.getInventory().setItem(7, ItemCreator.CreateItemwithMaterial(Material.NETHER_STAR, 0, 1, "§8«§f§lLobby-Switcher§8»", null));
		
		
		p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));

		Tablist.setPrefix(p);
		ScoreboardManager.setBoardLOBBY(p);
	}
}
