package de.fastesentity.utils;



import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {

	public static ItemStack CreateItemwithID(int id, int subid, int ammount, String DisplayName, ArrayList<String> lore) {
		
		
		
		@SuppressWarnings("deprecation")
		ItemStack is = new ItemStack(id,ammount, (short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(lore);
		is.setItemMeta(im);
		
		
		
		
		return is;
	
	
	
	
	}

	public static ItemStack CreateItemwithMaterial(Material m, int subid, int ammount, String DisplayName, ArrayList<String> lore) {
		
		ItemStack is = new ItemStack(m,ammount, (short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(DisplayName);
		im.setLore(lore);
		is.setItemMeta(im);
		
		
		
		
		return is;
		
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	public static Block setBlock(int subid , int ammount , String worldname , Location locpath) {
		
		Block block = Bukkit.getServer().getWorld(worldname).getBlockAt(locpath);
		
		block.setData((byte) subid);
		block.getState().setRawData((byte) subid);
		
		
		return block;
		
		
		
	}
	


}
