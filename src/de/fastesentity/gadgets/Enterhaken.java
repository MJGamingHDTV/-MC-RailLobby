package de.fastesentity.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

@SuppressWarnings("deprecation")
public class Enterhaken implements Listener {

	@EventHandler
	public void fish(PlayerFishEvent e) {
		
		Player p = e.getPlayer();
		Fish h = e.getHook();
		
		if((e.getState().equals(PlayerFishEvent.State.IN_GROUND)) || (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)) || (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT))) {
			if((Bukkit.getWorld(p.getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.AIR) || (Bukkit.getWorld(p.getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - (int) 0.5, h.getLocation().getBlockZ()).getType() != Material.AIR)) {
				if(Bukkit.getWorld(p.getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.STATIONARY_WATER) {
					
					Location pl = p.getLocation();
					Location hl = e.getHook().getLocation();
					
					pl.setY(pl.getY() + 0.5D);
					p.teleport(pl);
					
					double g = -0.08D;
					double d = hl.distance(pl);
					double t = d;
					double vector_x = (1.0D + 0.07D * t) * (hl.getX() - pl.getX()) / t;
					double vector_y = (1.0D + 0.03D * t) * (hl.getY() - pl.getY()) / t - 0.5D * g * t;
					double vector_z = (1.0D + 0.07D * t) * (hl.getZ() - pl.getZ()) / t;
					
					Vector vector = p.getVelocity();
					vector.setX(vector_x);
					vector.setY(vector_y);
					vector.setZ(vector_z);
					p.setVelocity(vector);
					
					e.getPlayer().getItemInHand().setDurability((short) 0);
					
					p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
				}
			}
		}	
	}
}
