package com.blade.RPG.main;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


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
			logMessage("All data succesfully loaded");
		}
	}

	private void logMessage(String message){
		this.logger.info("["+pdfFile.getName()+"]" + message);
	}
	private boolean Initiate() {
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
	private boolean loadPlayerData() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean loadItems() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean loadNPCS() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean loadScoreBoards() {
		// TODO Auto-generated method stub
		return false;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		return false;
	}
}
