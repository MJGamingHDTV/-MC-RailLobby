package de.fastesentity.subinteracts;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import de.fastesentity.main.Main;
import de.fastesentity.utils.LocationUtil;
import de.fastesentity.utils.Particle;
import de.fastesentity.utils.Title;
import de.fastesentity.utils.Var;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class CompassInteract implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(p.isOp() == true) {
			e.setCancelled(false);
			return;
		} else {
			e.setCancelled(true);
		}
		if (e.getInventory().getName().contains("§8«§7Navigator§8»")) {
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Spawn")) {
				
				p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));
				p.sendMessage(Var.prefix + "Du wurdet zum §6Server-Spawn §7teleportiert.");
				Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
		        particle.sendAll();
		        Title.sendActionBar(p, Var.prefix + "Du wurdet zum §6Server-Spawn §7teleportiert.");
		        
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Citybuild")) {
				
				p.teleport(LocationUtil.get("rail.citybuild", Main.getPlugin(Main.class)));
				p.sendMessage(Var.prefix + "Du wurdet zu §6Citybuild §7teleportiert.");
				Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
		        particle.sendAll();
		        Title.sendActionBar(p, Var.prefix + "Du wurdet zu §6Citybuild §7teleportiert.");
		        
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("BedWars")) {
				
				p.teleport(LocationUtil.get("rail.bedwars", Main.getPlugin(Main.class)));
				p.sendMessage(Var.prefix + "Du wurdet zu §6Bedwars §7teleportiert.");
				Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
		        particle.sendAll();
		        Title.sendActionBar(p, Var.prefix + "Du wurdet zu §6Bedwars §7teleportiert.");
		        
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("GunGame")) {
				
				p.teleport(LocationUtil.get("rail.gungame", Main.getPlugin(Main.class)));
				p.sendMessage(Var.prefix + "Du wurdet zu §6GunGame §7teleportiert.");
				Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
		        particle.sendAll();
		        Title.sendActionBar(p, Var.prefix + "Du wurdet zu §6GunGame §7teleportiert.");
		        
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("FFA")) {
				
				p.teleport(LocationUtil.get("rail.knockbackffa", Main.getPlugin(Main.class)));
			}
		}
	}
}
