package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Var;

public class tpall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("tpall")) {
			if(sender instanceof Player){
				Player pl = (Player)sender;
				if (pl.hasPermission("rail.tpall")){
					if(args.length == 0) {
						
					    for (Player p : Bukkit.getOnlinePlayers()) {
					    p.teleport(pl.getLocation());
					    p.sendMessage(Var.prefix + "Du wurdest zu §6" + pl.getName() + " §7teleportiert.");	
					    }
						pl.sendMessage(Var.prefix + "§6Alle Spieler §7wurden zu dir Teleportiert.");
						
						
						}else{
							pl.sendMessage(Var.notfind);	
						}	
					}else{
						pl.sendMessage(Var.noperm);
					}
			}
		}	
		
		return false;
	}
}


