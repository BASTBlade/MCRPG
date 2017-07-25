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
		File file = new File(server.getDataFolder()+ "/players.xml");
		if(file.exists()){
			loadPlayerData(server);
			return false;
		}
		else{
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
	
				return true;
				
			} 
			catch (ParserConfigurationException pce) {
				server.getLogger().info(pce.getMessage());
				return false;
			} 
			catch (TransformerException tfe) {
				server.getLogger().info(tfe.getMessage());
				return false;
			}
		}
	}

	private static void loadPlayerData(JavaPlugin server) {
		// TODO Auto-generated method stub
		
	}
}
