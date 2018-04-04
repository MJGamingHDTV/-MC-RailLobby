package de.fastesentity.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import de.fastesentity.main.Main;
import de.fastesentity.utils.ItemCreator2;
import de.fastesentity.utils.Var;



public class TntGadget implements Listener {

	
	
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
	if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
		
		if(e.getMaterial() == Material.TNT) {
			
			if(e.getItem().getAmount() == 1) {
			
			TNTPrimed tnt = (TNTPrimed) Bukkit.getWorld(p.getLocation().getWorld().getName()).spawn(p.getLocation(), TNTPrimed.class);
			Vector vector = p.getEyeLocation().getDirection();
			tnt.setVelocity(vector);
			tnt.setFuseTicks(20*2);
			
			p.getInventory().setItem(5, ItemCreator2.CreateItem(Material.TNT, -3, 0, "§4§lT§f§lN§4§lT"));
			
			Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

				@Override
				public void run() {
					if(p.getInventory().getItem(5).getType() == Material.AIR || p.getInventory().getItem(5).getType() == Material.TNT) {
				
					p.getInventory().setItem(5, ItemCreator2.CreateItem(Material.TNT, -2, 0, "§4§lT§f§lN§4§lT"));
					}
					Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

						@Override
						public void run() {
							if(p.getInventory().getItem(5).getType() == Material.AIR || p.getInventory().getItem(5).getType() == Material.TNT) {
							p.getInventory().setItem(5, ItemCreator2.CreateItem(Material.TNT, -1, 0, "§4§lT§f§lN§4§lT"));
							}
							Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {

								@Override
								public void run() {
									if(p.getInventory().getItem(5).getType() == Material.AIR || p.getInventory().getItem(5).getType() == Material.TNT) {
									p.getInventory().setItem(5, ItemCreator2.CreateItem(Material.TNT, 1, 0, "§4§lT§f§lN§4§lT"));
									for (Entity e: p.getWorld().getEntities()) {
						                if (e instanceof Item || e instanceof Vehicle) {
						                    e.remove();  
						                }
						            }
									}
								}
								
							}, 20);
						}
						
					}, 20);
					
				}
				
			}, 20);
			
			} else {
				p.sendMessage(Var.prefix + "§7Dieses Item ist noch im Cooldown");
				e.setCancelled(true);
			}
		}
		
	}
	
	}
}
