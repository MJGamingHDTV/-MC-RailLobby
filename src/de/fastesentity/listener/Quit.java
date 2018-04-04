package de.fastesentity.listener;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class Quit implements Listener {

	
	@EventHandler(priority=EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent e) {
			
		Player p = e.getPlayer();		
		e.setQuitMessage(null);	
		Tablist.setPrefix(p);
	}
}



