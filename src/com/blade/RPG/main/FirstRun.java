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
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Players");
			doc.appendChild(rootElement);
			
			// staff elements
			Element Player = doc.createElement("Player");
			Player.appendChild(doc.createTextNode("Player"));
			rootElement.appendChild(Player);

			// set attribute to staff element
			Player.setAttribute("UUID","UUID From Player");

			// shorten way
			// staff.setAttribute("id", "1");

			Element PlayerName = doc.createElement("PlayerName");
			PlayerName.appendChild(doc.createTextNode("PlayerName From Player"));
			Player.appendChild(PlayerName);

			Element XP = doc.createElement("XP");
			XP.appendChild(doc.createTextNode("XP From Player"));
			Player.appendChild(XP);

			Element RPGClass = doc.createElement("RPGClass");
			RPGClass.appendChild(doc.createTextNode("RPGClass From Player"));
			Player.appendChild(RPGClass);

			Element QuestProgress = doc.createElement("QuestProgress");
			QuestProgress.appendChild(doc.createTextNode("QuestProgress From Player"));
			Player.appendChild(QuestProgress);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder() + "/players.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

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
