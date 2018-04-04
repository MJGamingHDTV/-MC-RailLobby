package de.fastesentity.commands;

import de.fastesentity.utils.Var;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {

	static ArrayList<Player> vanish = new ArrayList<Player>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (p.hasPermission("rail.vanish")) {
			if (vanish.contains(p)) {
				p.sendMessage(Var.prefix + "§7Vanish wurde §cdeaktiviert§7.");
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.showPlayer(p);
					vanish.remove(p);
				}
			} else {
				vanish.add(p);
				p.sendMessage(Var.prefix + "Vanish wurde §aaktiviert§7.");
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (all.hasPermission("rail.vanish")) {
						all.showPlayer(p);
					} else {
						all.hidePlayer(p);
					}
				}
			}
		} else {
			p.sendMessage(Var.noperm);
		}
		return false;
	}

}