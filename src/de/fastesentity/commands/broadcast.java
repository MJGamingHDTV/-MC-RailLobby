package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Var;

public class broadcast implements CommandExecutor{

	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 Player p = (Player)sender;
		 if(command.getName().equalsIgnoreCase("broadcast")) {
			 if(p.hasPermission("rail.bc")){
			    StringBuilder message = new StringBuilder("");
			    for (String part : args) {
			        if (!message.toString().equals(""))
			            message.append(" ");
			 
			        message.append(part);
			    }
			 
			    Bukkit.getServer().broadcastMessage(Var.prefix + message.toString());
			}
		 }else{
			 p.sendMessage(Var.noperm);
		 }
		return false;
	     }
	
	
}
