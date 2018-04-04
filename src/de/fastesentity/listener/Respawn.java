package de.fastesentity.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.fastesentity.main.Main;
import de.fastesentity.utils.LocationUtil;
import de.fastesentity.utils.Particle;
import net.minecraft.server.v1_8_R3.EnumParticle;


public class Respawn implements Listener {

	
	@EventHandler(priority=EventPriority.HIGH)
	public void onRespawn(PlayerRespawnEvent e) {
			
		Player p = e.getPlayer();		
		p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));
		Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
        particle.sendAll();
		
	}
}


