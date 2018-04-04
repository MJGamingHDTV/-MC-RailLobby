package de.fastesentity.listener;


import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.util.Vector;

import de.fastesentity.main.Main;


public class Cancel implements Listener {

	
	@EventHandler
	public void blockbreak(BlockBreakEvent e) {
		
		if(!Main.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void blockplace(BlockPlaceEvent e) {
		
		if(!Main.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
		
	}
	
	
	@EventHandler
	public void Itemmove(InventoryMoveItemEvent e)  {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void ItemMoveing() {
		
	}
	
	
	@EventHandler
	public void drop(PlayerDropItemEvent e) {
		
		if(!Main.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void pickup(PlayerPickupItemEvent e) {
		
		if(!Main.build.contains(e.getPlayer().getName())) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void damage(EntityDamageEvent e) {
		
			e.setCancelled(true);
		
	}
	
	@EventHandler
	public void food(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void explosion(ExplosionPrimeEvent e) {
		
		if(e.getEntityType() == EntityType.CREEPER) {
			e.setCancelled(true);
			e.getEntity().remove();
		} else {
			e.setRadius(0);
			
			for(Player all: Bukkit.getOnlinePlayers()) {
				
				
				
				if(all.getLocation().distance(e.getEntity().getLocation()) < 5) {
					all.setVelocity(new Vector(all.getLocation().getX() - e.getEntity().getLocation().getX(), 1.1, all.getLocation().getZ() - e.getEntity().getLocation().getZ()));
				}
			
			}
			
			
			FallingBlock block = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation(), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block.setVelocity(new Vector(0, 1 , 0));
			
			
			FallingBlock block1 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0.5, 0, 0), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block1.setVelocity(Vector.getRandom());
			
			FallingBlock block2 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(-0.5, 0, 0), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block2.setVelocity(Vector.getRandom());
			
			FallingBlock block3 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0, 0, 0.5), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block3.setVelocity(Vector.getRandom());
			
			FallingBlock block4 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0, 0, -0.5), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block4.setVelocity(Vector.getRandom());
			
			FallingBlock block5 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0.5, 0, 0), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block5.setVelocity(Vector.getRandom());
			
			FallingBlock block6 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(-0.5, 0, 0), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block6.setVelocity(Vector.getRandom());
			
			FallingBlock block7 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0, 0, 0.5), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block7.setVelocity(Vector.getRandom());
			
			FallingBlock block8 = Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).spawnFallingBlock(e.getEntity().getLocation().add(0, 0, -0.5), e.getEntity().getLocation().add(0, -1, 0).getBlock().getType(), (byte) 1);
			block8.setVelocity(Vector.getRandom());
			
		}
	}
	
	
	@EventHandler
	public void blockform(EntityChangeBlockEvent e)  {
		
			e.setCancelled(true);
		
	}
	
	
	@EventHandler
	public void spawn(CreatureSpawnEvent e) {
		
		if(e.getSpawnReason() == SpawnReason.NATURAL || e.getSpawnReason() == SpawnReason.CHUNK_GEN) {
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void wetter(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
	
	
}