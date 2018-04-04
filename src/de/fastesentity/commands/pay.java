package de.fastesentity.commands;


import de.fastesentity.utils.Var;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class pay implements CommandExecutor{

    public static boolean Build = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        p.sendMessage(Var.prefix + "§7Dieser Befehl ist in der Lobby nich verfügbar.");
        return false;
    }

}