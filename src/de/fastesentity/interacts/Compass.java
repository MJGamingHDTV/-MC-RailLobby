package de.fastesentity.interacts;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.fastesentity.main.Main;
import de.fastesentity.utils.LocationUtil;
import de.fastesentity.utils.Particle;
import de.fastesentity.utils.Var;
import net.minecraft.server.v1_8_R3.EnumParticle;


public class Compass implements Listener {

	private Inventory compass = Bukkit.createInventory(null, 45, "§8«§7§lNavigator§8»");

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.LEFT_CLICK_AIR
				| e.getAction() == Action.LEFT_CLICK_BLOCK | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getMaterial() == Material.COMPASS) {
				
				p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));
				Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
		        particle.sendAll();
			}
		}
	}

	private void setInvItems(Inventory inv, int place, Material item, short type, String name, ArrayList<String> lore) {
		ItemStack is = new ItemStack(item, 1, type);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		im.setLore(lore);
		is.setItemMeta(im);
		inv.setItem(place, is);
	}

}
