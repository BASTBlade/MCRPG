package com.blade.RPG.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.bukkit.plugin.java.JavaPlugin;


public class FirstRun {
	public static boolean checkFirstRun(JavaPlugin server){
		if(!(new File(server.getDataFolder()+ "/players.xml").exists())){
			CreatePlayersFile(server);
		}
		if(!(new File(server.getDataFolder()+ "/weapons.xml").exists())){
			CreateWeaponsFile(server);
		}
		if(!(new File(server.getDataFolder()+ "/skills.xml").exists())){
			CreateSkillsFile(server);
		}
		if(!(new File(server.getDataFolder()+ "/quests.xml").exists())){
			CreateQuestsFile(server);
		}
		if(!(new File(server.getDataFolder()+ "/rpgclasses.xml").exists())){
			CreateRPGClassesFile(server);
		}
		if(!(new File(server.getDataFolder()+ "/monsters.xml").exists())){
			CreateMonstersFile(server);
		}
		return true;
	}

	private static void CreateMonstersFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements.
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Monsters");
			doc.appendChild(rootElement);
			
			// Create the Monster Attribute.
			Element Monster = doc.createElement("Monster");
			rootElement.appendChild(Monster);

			// Set the Custom name for Monster.
			Monster.setAttribute("Name","Name From Monster");

			// Create the Monster Level field.
			Element Level = doc.createElement("Level");
			Level.appendChild(doc.createTextNode("Level from Monster"));
			Monster.appendChild(Level);
			
			// Create the Monster Type field.
			Element MonsterType = doc.createElement("MonsterType");
			Level.appendChild(doc.createTextNode("The type of the Monster"));
			Monster.appendChild(MonsterType);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/monsters.xml"));
				
			transformer.transform(source, result);

			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	private static void CreateRPGClassesFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements.
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("RPGClasses");
			doc.appendChild(rootElement);
			
			// Create the Monster Attribute.
			Element Class = doc.createElement("Class");
			rootElement.appendChild(Class);

			// Set the Custom name for Monster.
			Class.setAttribute("Class","Class Name");

			// Create the Monster Level field.
			Element Type = doc.createElement("Type");
			Type.appendChild(doc.createTextNode("RPGClass type"));
			Class.appendChild(Type);
			

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/rpgclasses.xml"));
				
			transformer.transform(source, result);

			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	private static void CreateQuestsFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements.
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Quests");
			doc.appendChild(rootElement);
			
			// Create the Monster Attribute.
			Element Quest = doc.createElement("Quest");
			rootElement.appendChild(Quest);

			// Set the Custom name for Monster.
			Quest.setAttribute("Name","Quest Name");

			// Create the Monster Level field.
			Element Difficulty = doc.createElement("Difficulty");
			Difficulty.appendChild(doc.createTextNode("Quest Difficulty"));
			Quest.appendChild(Difficulty);
			

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/quests.xml"));
				
			transformer.transform(source, result);

			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	private static void CreateSkillsFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements.
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Skills");
			doc.appendChild(rootElement);
			
			// Create the Monster Attribute.
			Element Skill = doc.createElement("Skill");
			rootElement.appendChild(Skill);

			// Set the Custom name for Monster.
			Skill.setAttribute("SkillName","The Skills name");

			// Create the Monster Level field.
			Element Type = doc.createElement("Type");
			Type.appendChild(doc.createTextNode("Skill Type"));
			Skill.appendChild(Type);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/skills.xml"));
				
			transformer.transform(source, result);

			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	private static void CreateWeaponsFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements.
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Weapons");
			doc.appendChild(rootElement);
			
			// Create the Monster Attribute.
			Element Weapon = doc.createElement("Weapon");
			rootElement.appendChild(Weapon);

			// Set the Custom name for Monster.
			Weapon.setAttribute("WeaponName","TheWeaponName");

			// Create the Monster Level field.
			Element MaterialID = doc.createElement("MaterialID");
			MaterialID.appendChild(doc.createTextNode("The Material ID"));
			Weapon.appendChild(MaterialID);
			
			// Create the Monster Level field.
			Element Value = doc.createElement("Value");
			Value.appendChild(doc.createTextNode("The Monetary value of the Weapon"));
			Weapon.appendChild(Value);
			
			// Create the Monster Level field.
			Element Enchantments = doc.createElement("Enchantments");
			Enchantments.appendChild(doc.createTextNode("Enchantment 1"));
			Enchantments.appendChild(doc.createTextNode("Enchantment 2"));
			Enchantments.appendChild(doc.createTextNode("Enchantment 3"));
			Weapon.appendChild(Enchantments);
						

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/weapons.xml"));
				
			transformer.transform(source, result);

			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	private static void CreatePlayersFile(JavaPlugin server) {
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Players");
			doc.appendChild(rootElement);
			
			// Create the Player attribute
			Element Player = doc.createElement("Player");
			rootElement.appendChild(Player);

			// Set the UUID attribute for player.
			Player.setAttribute("UUID","UUID From Player");

			// Create the PlayerName META field.
			Element PlayerName = doc.createElement("PlayerName");
			PlayerName.appendChild(doc.createTextNode("PlayerName From Player"));
			Player.appendChild(PlayerName);

			// Create the XP META field.
			Element XP = doc.createElement("XP");
			XP.appendChild(doc.createTextNode("XP From Player"));
			Player.appendChild(XP);

			// Create the RPGClass META field.
			Element RPGClass = doc.createElement("RPGClass");
			RPGClass.appendChild(doc.createTextNode("RPGClass From Player"));
			Player.appendChild(RPGClass);

			// Create the QuestProgress META field.
			Element QuestProgress = doc.createElement("QuestProgress");
			QuestProgress.appendChild(doc.createTextNode("QuestProgress From Player"));
			Player.appendChild(QuestProgress);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/players.xml"));
				
			transformer.transform(source, result);
			
			
			
		} 
		catch (ParserConfigurationException pce) {
			server.getLogger().info(pce.getMessage());
		} 
		catch (TransformerException tfe) {
			server.getLogger().info(tfe.getMessage());
		}
		
	}

	@SuppressWarnings("unused")
	private static void loadPlayerData(JavaPlugin server) {
		// TODO Auto-generated method stub
		
	}
}
