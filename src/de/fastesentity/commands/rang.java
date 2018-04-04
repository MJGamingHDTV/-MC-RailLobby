package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Particle;
import de.fastesentity.utils.Title;
import de.fastesentity.utils.Var;
import net.minecraft.server.v1_8_R3.EnumParticle;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class rang implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String name = args[0];
        Player user = Bukkit.getPlayer(name);
        String rang = args[1];
        PermissionUser player = PermissionsEx.getUser(name);
        if(sender.hasPermission("rail.rang")) {
            if(args.length == 2) {
                player.addGroup(rang);
                sender.sendMessage("§7[§6§lRang§7] §7Du hast dem Spieler §6" + user.getName() + " §7den Rang §6" + rang + " §7erfolgreich gegeben");
                Bukkit.broadcastMessage(Var.prefix + "§7Der Spieler §6" + user.getName()  + " §7hat den Rang §6"+ rang + " §7erhalten");
                if(user != null) {
                	
                	
                	Title.sendTitle(user.getPlayer(), 2, 20, 2, "§a§lErfolgreich!", null);
                	try {
						Thread.sleep(750);
					} catch (InterruptedException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
                	Particle particle = new Particle(EnumParticle.HEART, user.getPlayer().getLocation().add(0,2.25,0), true, 0.25f, 0.25f, 0.25f, 0, 1000);
                    particle.sendAll();
					Title.sendTitle(user.getPlayer(), 2, 20, 2, "§7&lAusloggen.", null);
					try {
						Thread.sleep(750);
					} catch (InterruptedException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					Title.sendTitle(user.getPlayer(), 2, 20, 2, "§7&lAusloggen..", null);
					try {
						Thread.sleep(750);
					} catch (InterruptedException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					Title.sendTitle(user.getPlayer(), 2, 20, 2, "§7&lAusloggen...", null);
					try {
						Thread.sleep(750);
					} catch (InterruptedException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
                    
                    user.kickPlayer("§7[§6§lRang§7] §7Du hast einen neuen Rang erhalten!(§c§l" + rang + "§7)");
                }
            } else {
                sender.sendMessage("§7[§6§lRang§7] §cNutze: §7/rang <Name> <Rang>");
            }
        } else {
          sender.sendMessage("§7[§6§lRang§7] §cDazu hast du keine Rechte");
        }
        return true;
    }
}