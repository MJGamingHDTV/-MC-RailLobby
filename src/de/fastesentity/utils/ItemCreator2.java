package de.fastesentity.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator2 {

	public static ItemStack CreateItem(Material m, int zahl, int SubID, String DisplayName) {
		ItemStack i = new ItemStack(m, zahl, (short) SubID);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		i.setItemMeta(im);
		
		return i;
		
	}
	
	public static ItemStack CreateItemLore(Material m, int zahl, int SubID, String DisplayName, ArrayList<String> lore) {
		ItemStack i = new ItemStack(m, zahl, (short) SubID);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(lore);
		i.setItemMeta(im);
		
		return i;
		
	}
	
}
