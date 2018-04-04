package de.fastesentity.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Tablist {
    static Scoreboard scoreboard;

	public static void loadTablist(){
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		
        scoreboard.registerNewTeam("a").setPrefix("§4§lOwner §8» §7");
        scoreboard.registerNewTeam("b").setPrefix("§c§lAdmin §8» §7");
        scoreboard.registerNewTeam("c").setPrefix("§bDev §8» §7");
        scoreboard.registerNewTeam("d").setPrefix("§9SrMod §8» §7");
        scoreboard.registerNewTeam("e").setPrefix("§9Mod §8» §7");
        scoreboard.registerNewTeam("f").setPrefix("§eSupp §8» §7");
        scoreboard.registerNewTeam("g").setPrefix("§2Builder §8» §7");
        scoreboard.registerNewTeam("h").setPrefix("§5YT §8» §7");
        scoreboard.registerNewTeam("i").setPrefix("§aRail §8» §7");
        scoreboard.registerNewTeam("j").setPrefix("§b§lGod §8» §7");
        scoreboard.registerNewTeam("k").setPrefix("§6Premium §8» §7");
        scoreboard.registerNewTeam("l").setPrefix("§7");
        
       
	}
	
	public static void unloadTablist() {
		scoreboard.getTeams().clear();
	}
	
    public static void setPrefix(Player p) {

        String team = "";
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
            team = "a";
        } else if(PermissionsEx.getUser(p).inGroup("Admin")) {
            team = "b";
        } else if(PermissionsEx.getUser(p).inGroup("Dev")) {
            team = "c";
        } else if(PermissionsEx.getUser(p).inGroup("SrMod")) {
            team = "d";
        } else if(PermissionsEx.getUser(p).inGroup("Mod")) {
            team = "e";
        } else if(PermissionsEx.getUser(p).inGroup("Supp")) {
            team = "f";
        } else if(PermissionsEx.getUser(p).inGroup("Builder")) {
            team = "g";
        } else if(PermissionsEx.getUser(p).inGroup("YouTuber")) {
            team = "h";
        } else if(PermissionsEx.getUser(p).inGroup("Rail")) {
            team = "i";
        } else if(PermissionsEx.getUser(p).inGroup("God")) {
            team = "j";
        } else if(PermissionsEx.getUser(p).inGroup("Premium")) {
            team = "k";
        } else if(PermissionsEx.getUser(p).inGroup("default")) {
            team = "l";
        }
        scoreboard.getTeam(team).addEntry(p.getName());
        p.setDisplayName(scoreboard.getTeam(team).getPrefix() + p.getName());
        
        for(Player a : Bukkit.getOnlinePlayers()) {
		a.setScoreboard(scoreboard);
        }
    }
}