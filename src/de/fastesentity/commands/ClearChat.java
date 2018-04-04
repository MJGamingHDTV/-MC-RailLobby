package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Var;

public class ClearChat implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("clearchat")) {
			if(sender instanceof Player){
				Player p = (Player)sender;
				if (p.hasPermission("rail.clearchat")){
					if(args.length == 0) {
						for (int i = 126; i > 0; i--) {
							Bukkit.broadcastMessage("");
						}
						Bukkit.broadcastMessage(Var.prefix + "§7Der Chat wurde von §6" + p.getName() + " §7gecleart.");
						
					}else{
						p.sendMessage(Var.prefix + "§7Bitte benutze nur §6/clearchat");
					}
				}else{
					p.sendMessage(Var.noperm);
				}
			}
		}	
		return false;
	}
}
