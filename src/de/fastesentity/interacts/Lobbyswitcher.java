package de.fastesentity.interacts;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import cloud.timo.TimoCloud.api.TimoCloudAPI;
import cloud.timo.TimoCloud.api.objects.ServerGroupObject;
import cloud.timo.TimoCloud.api.objects.ServerObject;
import de.fastesentity.main.Main;
import de.fastesentity.utils.Var;

public class Lobbyswitcher implements Listener {

	Inventory inv = Bukkit.createInventory(null, 9, "§8«§f§lLobby-Switcher§8»");

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8«§f§lLobby-Switcher§8»")) {
					p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1, 1);
					ServerGroupObject go = TimoCloudAPI.getUniversalInstance().getServerGroup("Lobby");
					int i = go.getServers().size();
					int size = i;
					if (size == 1) {
						p.sendMessage(Var.prefix + "§7Derzeit sind keine weiteren Lobby-Server online!");
					} else {
						String curServer = p.getServer().getServerName();
						while (size > 0) {
							ServerObject so = TimoCloudAPI.getUniversalInstance().getServer("Lobby-" + size);
							int c = so.getOnlinePlayerCount();
							this.Inv("Lobby-" + size, c, size, curServer);
							size--;
							p.openInventory(inv);
							p.updateInventory();
						}
					}
				}
			}
		} catch (NullPointerException e2) {
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getWhoClicked() == null)
			return;
		Player p = (Player) e.getWhoClicked();
		try {
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Lobby")) {
				String[] lobby = e.getCurrentItem().getItemMeta().getDisplayName().split("-");
				System.out.println(lobby[1]);
				String server = "Lobby-" + lobby[1];
				String[] splitserver = p.getServer().getServerName().split("-");
				int serverid = Integer.parseInt(splitserver[1]);
				int lobbyid = Integer.parseInt(lobby[1]);
				if (lobbyid == serverid) {
					p.sendMessage(Var.prefix + "§7Du bist bereits mit diesem Server verbunden!");
				} else {
					p.sendMessage(Var.prefix + "§7Du betrittst nun den Server §6§lLobby-" + lobby[1]);
					p.closeInventory();
					ByteArrayDataOutput out = ByteStreams.newDataOutput();
			        out.writeUTF("Connect");
			        out.writeUTF(server);
			        p.sendPluginMessage(Main.plugin, "BungeeCord", out.toByteArray());
				}
			}
		} catch (NullPointerException e2) {
		}
	}

	@SuppressWarnings("deprecation")
	private void Inv(String name, int online, int where, String curServer) {
		String[] name2 = curServer.split("-");
		int size2 = Integer.parseInt(name2[1]);
		ItemStack emer = new ItemStack(351, 1, (short) 10);
		ItemMeta emerm = emer.getItemMeta();
		emerm.setDisplayName("§a" + name);
		String o = "§7Online Spieler : §6" + online;
		ArrayList<String> list = new ArrayList<String>();
		list.add(o);
		list.add("§7Server im §6§lOnlineModus§7.");
		if (size2 == where) {
			list.add("§cDerzeit verbunden!");
		} else {
			list.add("§aKlicke zum verbinden!");
		}
		emerm.setLore(list);
		emer.setItemMeta(emerm);
		where--;
		inv.setItem(where, emer);
	}
}
