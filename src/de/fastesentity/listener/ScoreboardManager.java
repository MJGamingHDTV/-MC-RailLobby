package de.fastesentity.listener;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import de.NeonnBukkit.CoinsAPI.API.CoinsAPI;
import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ScoreboardManager {
	
	public static void setBoardLOBBY(Player p) {
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
        obj.setDisplayName("§8» §6§lRailCraft.de §8«");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§a§lDeine Coins §8:                     ");
        ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§8» §7" + CoinsAPI.getCoins(p.getUniqueId().toString()));
        ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8§7");
        ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§a§lDein Rang §8:");
        ScoreboardScore s5 = null;
        if(PermissionsEx.getUser(p).inGroup("Owner")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§4§lOwner");
        }else if(PermissionsEx.getUser(p).inGroup("Admin")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§c§lAdmin");
        }else if(PermissionsEx.getUser(p).inGroup("Dev")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§b§lDev");
        }else if(PermissionsEx.getUser(p).inGroup("SrMod")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§cSrMod");
        }else if(PermissionsEx.getUser(p).inGroup("Mod")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§9Mod");
        }else if(PermissionsEx.getUser(p).inGroup("Supp")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§9§lSupp");
        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§aBuilder");
        }else if(PermissionsEx.getUser(p).inGroup("YT")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§5YouTuber");
        }else if(PermissionsEx.getUser(p).inGroup("Rail")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§aRail");
        }else if(PermissionsEx.getUser(p).inGroup("God")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§b§lGod");
        }else if(PermissionsEx.getUser(p).inGroup("Premium")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§6Premium");
        }else if(PermissionsEx.getUser(p).inGroup("default")){
        	s5 = new ScoreboardScore(scoreboard, obj, "§7Spieler");
        }
        ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§7§9 ");
        ScoreboardScore s11 = new ScoreboardScore(scoreboard, obj, "§a§lServer");
        ScoreboardScore s12 = new ScoreboardScore(scoreboard, obj, "§8» §7" + p.getServer().getServerName());

        s1.setScore(7);
        s2.setScore(6);
        s3.setScore(5);
        s4.setScore(4);
        s5.setScore(3);
        s6.setScore(2);
        s11.setScore(1);
        s12.setScore(0);

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
        PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(s11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(s12);

        sendPacket(removePacket, p);
        sendPacket(createPacket, p);
        sendPacket(display, p);

        sendPacket(pa1, p);
        sendPacket(pa2, p);
        sendPacket(pa3, p);
        sendPacket(pa4, p);
        sendPacket(pa5, p);
        sendPacket(pa6, p);
        sendPacket(pa11, p);
        sendPacket(pa12, p);
    }

    private static void sendPacket(@SuppressWarnings("rawtypes") Packet packet, Player p) {
        ((CraftPlayer )p).getHandle().playerConnection.sendPacket(packet);
    }
    
    public static org.bukkit.scoreboard.Scoreboard board;

    public static Team getTeamNormal(org.bukkit.scoreboard.Scoreboard board, Player p){

        if( PermissionsEx.getUser(p).inGroup("Owner")){
            return board.getTeam("a");
        }else if(PermissionsEx.getUser(p).inGroup("Admin")){
            return board.getTeam("b");
        }else if( PermissionsEx.getUser(p).inGroup("Dev")){
            return board.getTeam("c");
        }else if(PermissionsEx.getUser(p).inGroup("SrMod")){
            return board.getTeam("d");
        }else if(PermissionsEx.getUser(p).inGroup("Mod")){
            return board.getTeam("e");
        }else if(PermissionsEx.getUser(p).inGroup("Supp")){
            return board.getTeam("f");
        }else if(PermissionsEx.getUser(p).inGroup("Builder")){
            return board.getTeam("g");
        }else if(PermissionsEx.getUser(p).inGroup("YT")){
            return board.getTeam("h");
        }else if(PermissionsEx.getUser(p).inGroup("Premium+")){
            return board.getTeam("i");
        }else if(PermissionsEx.getUser(p).inGroup("Rail")){
            return board.getTeam("j");
        }else if(PermissionsEx.getUser(p).inGroup("God")){
            return board.getTeam("k");
        }else if(PermissionsEx.getUser(p).inGroup("Premium")){
            return board.getTeam("l");
        }
        return board.getTeam("m");
    }
	
	
	public static void setStandardTablist(Player p){

	        board = Bukkit.getScoreboardManager().getNewScoreboard();

	        Team Owner = board.registerNewTeam("a");
	        Team Admin = board.registerNewTeam("b");
	        Team Dev = board.registerNewTeam("c");
	        Team SrMod = board.registerNewTeam("d");
	        Team Mod = board.registerNewTeam("e");
	        Team Supp = board.registerNewTeam("f");
	        Team Builder = board.registerNewTeam("g");
	        Team YouTuber = board.registerNewTeam("h");
	        Team PremiumP = board.registerNewTeam("i");
	        Team Rail = board.registerNewTeam("j");
	        Team God = board.registerNewTeam("k");
	        Team Premium = board.registerNewTeam("l");
	        Team Spieler = board.registerNewTeam("m");

	        Spieler.setPrefix("§7");
	        Premium.setPrefix("§6Premi §8» §7");
	        God.setPrefix("§bGod §8» §7");
	        Rail.setPrefix("§aRail §8» §7");
	        PremiumP.setPrefix("§ePremi+ §8» §7");
	        YouTuber.setPrefix("§5YT §8» §7");
	        Builder.setPrefix("§a§lBuilder §8» §7");
	        Supp.setPrefix("§9§lSupp §8» §7");
	        Mod.setPrefix("§c§lMod §8» §7");
	        SrMod.setPrefix("§c§lSrMod §8» §7");
	        Dev.setPrefix("§b§lDev §8» §7");
	        Admin.setPrefix("§c§lAdmin §8» §7");
	        Owner.setPrefix("§4§lOwner §8» §7");


	        for (Player all : Bukkit.getOnlinePlayers()) {
	            Team playerTeam = ScoreboardManager.getTeamNormal(board, all);
	            if (playerTeam.hasEntry(all.getName())) continue;
	            playerTeam.addEntry(all.getName());
	        }
	        
	        p.setScoreboard( Bukkit.getScoreboardManager().getNewScoreboard() );
	        p.setScoreboard( board );

	}

}
