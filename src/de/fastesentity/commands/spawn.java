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

public class spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("spawn")) {
			
			if(sender instanceof Player){
				Player p = (Player)sender;
					if(args.length == 0) {
						p.teleport(LocationUtil.get("rail.lobby", Main.getPlugin(Main.class)));
						p.sendMessage(Var.preab + "§7Du wurdest zum §6Spawn §7teleportiert.");
						
						Particle particle = new Particle(EnumParticle.CLOUD, p.getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 10000);
				        particle.sendAll();
						
						
					}else{
						p.sendMessage(Var.notfind);
					}
			}
		}
		return false;
	}
}