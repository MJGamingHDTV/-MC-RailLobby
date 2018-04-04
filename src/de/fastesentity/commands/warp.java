package de.fastesentity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.main.Main;
import de.fastesentity.utils.LocationUtil;
import de.fastesentity.utils.Particle;
import de.fastesentity.utils.Var;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class warp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("warp")) {
			
			if(sender instanceof Player){
				Player p = (Player)sender;
				
					if(args.length == 0) {
						
						p.sendMessage(Var.preab + "§7Verfügbare Warps:");
						p.sendMessage(" §7- spawn");
						p.sendMessage(" §7- bedwars");
						p.sendMessage(" §7- gungame");
						p.sendMessage(" §7- knockbackffa");
						p.sendMessage(" §7- citybuild");
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("bedwars")){  
						
						p.teleport(LocationUtil.get("rail.bedwars", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zu §6Bedwars §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
				        
					}else if(args.length == 1 && args[0].equalsIgnoreCase("gungame")){  
						
						p.teleport(LocationUtil.get("rail.gungame", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zu §6GunGame §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
				        
					}else if(args.length == 1 && args[0].equalsIgnoreCase("knockbackffa")){  
						
						p.teleport(LocationUtil.get("rail.knockbackffa", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zu §6KBFFA §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
				        
					}else if(args.length == 1 && args[0].equalsIgnoreCase("citybuild")){  
						
						p.teleport(LocationUtil.get("rail.citybuild", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zu §6Citybuild §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
				        
				        
					}else if(args.length == 1 && args[0].equalsIgnoreCase("spawn")){  
						
						p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zum §6Spawn §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
						
						
					}else{
						p.sendMessage(Var.preab + "§7Der Command oder der Warp-Punkt konnte nicht gefunden werden.");
					}
			}
		}
		return false;
	}
}
