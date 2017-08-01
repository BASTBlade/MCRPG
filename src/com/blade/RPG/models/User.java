package com.blade.RPG.models;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// This is the class for the player data and the RPG model which will help understand the plugin which player it is and what meta data this player has.
// This class will not be editable with a config or xml file because this will always be the same.
public class User {
	private String UUID;
	private String DisplayName;
	private int XP;
	private int rpgclass;
	private int[] questsProgress;
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getDisplayName() {
		return DisplayName;
	}
	public void setDisplayName(String displayName) {
		DisplayName = displayName;
	}
	public int getXP() {
		return XP;
	}
	public void setXP(int xP) {
		XP = xP;
	}
	public int getRpgclass() {
		return rpgclass;
	}
	public void setRpgclass(int rpgclass) {
		this.rpgclass = rpgclass;
	}
	public int[] getQuestsProgress() {
		return questsProgress;
	}
	public void setQuestsProgress(int[] questsProgress) {
		this.questsProgress = questsProgress;
	}
	
	public boolean addUser(JavaPlugin server, User user){
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try{
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.parse(new File(server.getDataFolder()+ "/players.xml"));
			Element mainRootElement = doc.getDocumentElement();
			// Create the Monster Attribute.
			Element User = doc.createElement("User");
			mainRootElement.appendChild(User);
			// Set the Custom name for Monster.
			User.setAttribute("UUID",user.getUUID());

			// Create the Monster Level field.
			Element DisplayName = doc.createElement("DisplayName");
			DisplayName.appendChild(doc.createTextNode(user.getDisplayName()));
			User.appendChild(DisplayName);
						
			// Create the Monster Level field.
			Element XP = doc.createElement("XP");
			XP.appendChild(doc.createTextNode(user.getXP() + ""));
			User.appendChild(XP);
			
			Element RPGClass = doc.createElement("RPGClass");
			RPGClass.appendChild(doc.createTextNode(user.getRpgclass() + ""));
			User.appendChild(RPGClass);
			
			Element questsProgress = doc.createElement("questsProgress");
			questsProgress.appendChild(doc.createTextNode(user.getQuestsProgress() + ""));
			User.appendChild(questsProgress);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/players.xml"));
							
			transformer.transform(source, result);

		}
		catch(Exception e){
			server.getLogger().info(e.getMessage());
			return false;
		}
		return true;
	}
	public User getUser(JavaPlugin server, Player player){
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try{
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.parse(new File(server.getDataFolder()+ "/players.xml"));
			NodeList nl = doc.getElementsByTagName("UUID");
			User user = new User();
			user.setUUID(nl.item(0).getNodeValue());
			user.setDisplayName(nl.item(1).getNodeValue());
			user.setXP(Integer.parseInt(nl.item(2).getNodeValue()));
			user.setRpgclass(Integer.parseInt(nl.item(3).getNodeValue()));
			
			//To edit still.
			//Object o = nl.item(4).getNodeValue();
			
			
			//user.setQuestsProgress(Integer.parseInt(nl.item(4).getNodeValue()));
			return user;
		}
		catch(Exception e){
			server.getLogger().info(e.getMessage());
			return null;
		}
	}
}
