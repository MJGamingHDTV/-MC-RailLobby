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

public class setwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("setwarp")) {
			Player p = (Player)sender;
			if(p.isOp()){
			if(sender instanceof Player){
					if(args.length == 0) {
						
						p.sendMessage(Var.preab + "§7Du kannst folgende Warps festlegen:");
						p.sendMessage(" §7- knockbackffa");
						p.sendMessage(" §7- spawn");
						p.sendMessage(" §7- bedwars");
						p.sendMessage(" §7- gungame");
						p.sendMessage(" §7- citybuild");
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("bedwars")){								//BW
						
						Main.getInstance().getConfig().set("rail.bedwars", p.getLocation());
						Main.getInstance().saveConfig();
						LocationUtil.save("rail.bedwars", p.getLocation(), Main.getPlugin(Main.class));
						p.sendMessage(Var.prefix + "§7Bedwars erfolgreich gesetzt.");
						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("knockbackffa")){							//KBFFA
						
						Main.getInstance().getConfig().set("rail.knockbackffa", p.getLocation());
						Main.getInstance().saveConfig();
						LocationUtil.save("rail.knockbackffa", p.getLocation(), Main.getPlugin(Main.class));
						p.sendMessage(Var.prefix + "§7KnockBackFFA erfolgreich gesetzt.");
						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("gungame")){								//GUNGAME
						
						Main.getInstance().getConfig().set("rail.gungame", p.getLocation());
						Main.getInstance().saveConfig();
						LocationUtil.save("rail.gungame", p.getLocation(), Main.getPlugin(Main.class));
						p.sendMessage(Var.prefix + "§7GunGame erfolgreich gesetzt.");
						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("citybuild")){							//CITYBUILD
						
						Main.getInstance().getConfig().set("rail.citybuild", p.getLocation());
						Main.getInstance().saveConfig();
						LocationUtil.save("rail.citybuild", p.getLocation(), Main.getPlugin(Main.class));
						p.sendMessage(Var.prefix + "§7Citybuild erfolgreich gesetzt.");	
						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();
						
					}else if(args.length == 1 && args[0].equalsIgnoreCase("spawn")){								//SERVER-SPAWN
						
						Main.getInstance().getConfig().set("rail.lobby", p.getLocation());
						Main.getInstance().saveConfig();
						LocationUtil.save("rail.lobby", p.getLocation(), Main.getPlugin(Main.class));
						p.sendMessage(Var.prefix + "§7Server-Spawn erfolgreich gesetzt.");
						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();

					}else{
						p.sendMessage(Var.notfind);
					}
			}else{
				p.sendMessage(Var.noperm);
			}
			}
		}
		return false;
	}
}
