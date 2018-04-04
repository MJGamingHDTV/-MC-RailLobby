package de.fastesentity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.fastesentity.utils.Var;

public class kreload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("kreload")) {
			if(sender instanceof Player){
				Player p = (Player)sender;
				if (p.hasPermission("rail.admin")){
					if(args.length == 0) {
						
						for (int i = 126; i > 0; i--) {
							Bukkit.broadcastMessage("");
						}
						p.sendMessage(Var.prefix + "§7Ein Reload wird jetzt durchgeführt.");
						
					    Bukkit.broadcastMessage(Var.prefix + "§c§lDer Server muss neu gestartet werden.");
					    Bukkit.broadcastMessage(Var.prefix + "§cDieser Spielmodus wird gleich wieder verfügbar sein.");
					    Bukkit.broadcastMessage(Var.prefix + "§7Alle Commands wurden §c§ldeaktiviert§l");
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l10 Sekunden§7.");
					    try {
							Thread.sleep(5000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l5 Sekunden§7.");
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l4 Sekunden§7.");
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l3 Sekunden§7.");
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l2 Sekunden§7.");
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Reload in §6§l1 Sekunden§7.");
					    p.getWorld().save();
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.broadcastMessage(Var.prefix + "§7Ein Reload wird jetzt durchgeführt.");
					    
					    for (Player all : Bukkit.getOnlinePlayers()) {
						    all.kickPlayer(Var.prefix + "§7Wir sind gleich wieder für dich da.");
						    
						    }
					    
					    try {
							Thread.sleep(100);
						} catch (InterruptedException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					    Bukkit.shutdown();
						
						
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


