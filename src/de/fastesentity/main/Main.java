package de.fastesentity.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.fastesentity.commands.ClearChat;
import de.fastesentity.commands.Fly;
import de.fastesentity.commands.Tageszeit;
import de.fastesentity.commands.Vanish;
import de.fastesentity.commands.broadcast;
import de.fastesentity.commands.kreload;
import de.fastesentity.commands.pay;
import de.fastesentity.commands.rang;
import de.fastesentity.commands.setspawn;
import de.fastesentity.commands.setwarp;
import de.fastesentity.commands.spawn;
import de.fastesentity.commands.tpall;
import de.fastesentity.commands.warp;
import de.fastesentity.gadgets.Enterhaken;
import de.fastesentity.gadgets.TntGadget;
import de.fastesentity.interacts.Bonus;
import de.fastesentity.interacts.Compass;
import de.fastesentity.interacts.Lobbyswitcher;
import de.fastesentity.interacts.Verstecken;
import de.fastesentity.listener.Cancel;
import de.fastesentity.listener.Chat;
import de.fastesentity.listener.Doppelsprung;
import de.fastesentity.listener.Join;
import de.fastesentity.listener.Quit;
import de.fastesentity.listener.Respawn;
import de.fastesentity.listener.Tablist;
import de.fastesentity.subinteracts.CompassInteract;
import de.fastesentity.subinteracts.Gadgets;
import de.fastesentity.utils.Var;

public class Main extends JavaPlugin {

	public static Main instance;
	public static Main plugin;

	public static File file = new File("plugins/LobbyRail", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	
	public static ArrayList<String> build = new ArrayList<>();
	


	File folder = new File("plugins/LobbyRail");

	@Override
	public void onEnable() {

		Tablist.loadTablist();
		instance = this;
		plugin = this;
		
		Main.build.clear();

		init();
		System.out.println(Var.prefix + "Erfolgreich gestartet!");

		if (!Main.file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
			}
		}

		if (!folder.exists()) {
			folder.mkdir();
			System.out.println(Var.prefix + "Lobby-Ordner angelegt!");

		}
	}
	
	public void onDisable() {
		Tablist.unloadTablist();
	}

	private void init() {

		this.getCommand("setspawn").setExecutor(new setspawn());
		this.getCommand("rang").setExecutor(new rang());
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("day").setExecutor(new Tageszeit());
		this.getCommand("night").setExecutor(new Tageszeit());
		this.getCommand("clearchat").setExecutor(new ClearChat());
		this.getCommand("broadcast").setExecutor(new broadcast());
		this.getCommand("warp").setExecutor(new warp());
		this.getCommand("setwarp").setExecutor(new setwarp());
		this.getCommand("spawn").setExecutor(new spawn());
		this.getCommand("tpall").setExecutor(new tpall());
		this.getCommand("vanish").setExecutor(new Vanish());
		this.getCommand("pay").setExecutor(new pay());
		this.getCommand("kreload").setExecutor(new kreload());
		this.getCommand("build").setExecutor(new de.fastesentity.commands.build());

		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new TntGadget(), this);
		pm.registerEvents(new Verstecken(), this);
		pm.registerEvents(new Respawn(), this);
		pm.registerEvents(new Compass(), this);
		pm.registerEvents(new Gadgets(), this);
		pm.registerEvents(new Bonus(), this);
		pm.registerEvents(new Enterhaken(), this);
		pm.registerEvents(new Doppelsprung(), this);
		pm.registerEvents(new CompassInteract(), this);
		pm.registerEvents(new Cancel(), this);
		pm.registerEvents(new Lobbyswitcher(), this);

	}

	public static Main getPlugin() {
		return plugin;
	}

	public static Main getInstance() {
		return instance;
	}

}
