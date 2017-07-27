package com.blade.RPG.main;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.blade.RPG.models.Weapon;


public class Main extends JavaPlugin implements Listener{
	
	PluginDescriptionFile pdfFile = this.getDescription();
	public final Logger logger = Logger.getLogger("Minecraft");
	public void onDisable(){
		logMessage("plugin disabled!");
	}
	@Override
	public void onEnable(){
		logMessage("An attempt has been made to load the plugin.");
		getServer().getPluginManager().registerEvents(this, this);
		if(Initiate()){
			logMessage("All data succesfully loaded.");
		}
		test();
	}

	private void test() {
		ItemStack item = new ItemStack(Material.BOW,1);
		item.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
		item.addEnchantment(Enchantment.ARROW_FIRE, 1);
		item.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		Weapon wep = new Weapon(item.getType());
		wep.setWeaponLore("Test lore hhh");
		wep.setWeaponName("Test weapon name");
		wep.setWeaponValue(500);
		wep.setWeaponEnchantments(item.getEnchantments());
		Weapon.AddWeapon(this, wep);
	}
	private void logMessage(String message){
		this.logger.info("["+pdfFile.getName()+"]" + message);
	}
	private boolean Initiate() {
		if(FirstRun.checkFirstRun(this)){
			logMessage("First run initiated.");
			return true;
		}
		else{
			if(loadScoreBoards()){
				if(loadNPCS()){
					if(loadItems()){
						if(loadPlayerData()){
							return true;
							
						}else{
							return false;
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
			return false;
			}
		}
	}
	private boolean loadPlayerData() {
		return true;
	}
	private boolean loadItems() {
		return true;
	}
	private boolean loadNPCS() {
		return true;
	}
	private boolean loadScoreBoards() {
		return true;
	}
	/*@EventHandler
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		return true;
	}*/
}
