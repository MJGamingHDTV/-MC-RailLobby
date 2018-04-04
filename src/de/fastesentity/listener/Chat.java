package de.fastesentity.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Chat implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player player = e.getPlayer();
		
		String Message1 = e.getMessage();
		String msg = ChatColor.translateAlternateColorCodes('&', Message1);

		Tablist.setPrefix(player);
		
            if( PermissionsEx.getUser(player).inGroup("Owner")) {
                e.setFormat("§4§lOwner §8» §7" + player.getName() + " §8» §a§l" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Admin")) {
                e.setFormat("§c§lAdmin §8» §7" + player.getName() + " §8» §b§l" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Dev")) {
                e.setFormat("§b§lDev §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("SrMod")) {
                e.setFormat("§c§lSrMod §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Mod")) {
                e.setFormat("§9§lMod §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Supp")) {
                e.setFormat("§eSupp §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Builder")) {
                e.setFormat("§2Builder §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("YT")) {
                e.setFormat("§5YT §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Rail")) {
                e.setFormat("§a§lRail §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("God")) {
                e.setFormat("§bGod §8» §7" + player.getName() + " §8» §7" + msg);
            } else if(PermissionsEx.getUser(player).inGroup("Premium")) {
                e.setFormat("§6Premium §8» §7" + player.getName() + " §8» §7" + msg);
            } else {
            	 e.setFormat("§7Spieler §8» §7" + player.getName() + " §8» §7" + Message1);
            }
	}
}
