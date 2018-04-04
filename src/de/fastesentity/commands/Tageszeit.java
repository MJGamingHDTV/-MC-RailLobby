package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Var;

public class Tageszeit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = (Player)sender;
		if(p.hasPermission("rail.time")){
			if(command.getName().equalsIgnoreCase("day")) {
			
			p.sendMessage(Var.prefix + "§7Du hast Tag eingestellt.");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "time set 1000");
				
			
			}else if(command.getName().equalsIgnoreCase("night")) {
				
				p.sendMessage(Var.prefix + "§7Du hast Nacht eingestellt.");
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "time set 15000");
			}
		}else{
			p.sendMessage(Var.noperm);
		}
		return true;
	}
}