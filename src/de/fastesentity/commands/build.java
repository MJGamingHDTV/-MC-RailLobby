package de.fastesentity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.main.Main;
import de.fastesentity.utils.Var;

public class build implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("rail.build")) {
			
			if(!Main.build.contains(p.getName())) {
				Main.build.add(p.getName());
				p.sendMessage(Var.prefix + "§7Baumodus: §a§laktiviert§7.");
			} else {
				Main.build.remove(p.getName());
				p.sendMessage(Var.prefix + "§7Baumodus: §c§ldeaktiviert§7.");
			}
			
		} else {
			p.sendMessage(Var.noperm);
		}
		
		return true;
	}

}
