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
	
	PluginDescriptionFile pdfFile;
	public final Logger logger = Logger.getLogger("Minecraft");
	public void onDisable(){
		pdfFile = this.getDescription();
		logMessage("plugin disabled!");
	}
	@Override
	public void onEnable(){
		pdfFile = this.getDescription();
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
		return true;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		
		return true;
	}
}
