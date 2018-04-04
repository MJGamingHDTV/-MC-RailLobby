package de.fastesentity.commands;


import de.fastesentity.utils.Var;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Fly implements CommandExecutor{

    public static boolean Build = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        if(p.hasPermission("rail.fly")){
            if(Build){
                Build = false;
                p.sendMessage(Var.prefix + "§7Der Flymodus wurde §cdeaktiviert§7.");
                p.setAllowFlight(false);
                
            } else {
            	
                Build = true;
                p.sendMessage(Var.prefix + "Der Flymodus wurde §aaktiviert§7.");
                p.setAllowFlight(true);
                
            }
        } else {
            p.sendMessage(Var.noperm);
        }
        return false;
    }

}