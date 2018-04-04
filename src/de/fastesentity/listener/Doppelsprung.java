package de.fastesentity.listener;


import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import de.fastesentity.utils.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class Doppelsprung implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.SURVIVAL) {
			if(p.getLocation().add(0, -1 , 0).getBlock().getType() != Material.AIR || p.getLocation().add(0, -1 , 0).getBlock().getType() != Material.WATER) {
				if(p.isOnGround()) {
				p.setAllowFlight(true);
				p.setFlying(false);
				p.setTotalExperience(100);	
				}	
			}	
		}
	}
	@EventHandler
	public void onDoubleJump(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		
		if(p.getGameMode() == GameMode.SURVIVAL) {
			
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(0.9D).add(new Vector(0, 0.9, 0)));
			p.playSound(p.getLocation(), Sound.LAVA_POP, 1, 1);
			Particle particle = new Particle(EnumParticle.FIREWORKS_SPARK, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 100);
	        particle.sendAll();
	
		}
	}

}