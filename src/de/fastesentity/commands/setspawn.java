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

public class setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (command.getName().equalsIgnoreCase("setspawn")) {
			Player p = (Player) sender;
			if (p.isOp()) {
				if (sender instanceof Player) {
					if (args.length == 0) {

						Main.getInstance().getConfig().set("rail.lobby", p.getLocation());
						Main.getInstance().saveConfig();

						LocationUtil.save("rail.lobby", p.getLocation(), Main.getPlugin(Main.class));

						p.sendMessage(Var.prefix + "§7Server-Spawn erfolgreich gesetzt.");

						Particle particle = new Particle(EnumParticle.FLAME, p.getLocation().add(0, 2.25, 0), true,
								0.25f, 0.25f, 0.25f, 0, 10000);
						particle.sendAll();
					} else {
						p.sendMessage(Var.notfind);
					}
				} else {
					p.sendMessage(Var.noperm);
				}
			} else {
				p.sendMessage(Var.noperm);
			}
		}
		return false;
	}
}
