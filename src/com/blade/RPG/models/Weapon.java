package com.blade.RPG.models;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

// This is the class for weapons in the RPG gamemode. There will be a file where people can add weapons with a certain layout which will be imported in the gamemode.
// These weapons are able to be used whilst playing.
public class Weapon {
	private static Map<Enchantment,Integer> weaponEnchantments;
	private String weaponLore;
	private String weaponName;
	private ItemStack weapon;
	private Integer weaponValue;
	
	
	public Weapon(Material mat){
		setWeapon(mat);
	}
	
	
	public boolean setLore(List<String> lore){
		this.weapon.getItemMeta().setLore(lore);
		return true;
	}
	
	public ItemStack getWeapon() {
		return weapon;
	}

	public void setWeapon(Material weapon) {
		this.weapon = new ItemStack(weapon,1);
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public String getWeaponLore() {
		return weaponLore;
	}

	public void setWeaponLore(String weaponLore) {
		this.weaponLore = weaponLore;
	}

	public static Map<Enchantment,Integer> getWeaponEnchantments() {
		return weaponEnchantments;
	}

	public void setWeaponEnchantments(Map<Enchantment,Integer> weaponEnchantments) {
		Weapon.weaponEnchantments = weaponEnchantments;
	}

	public Integer getWeaponValue() {
		return weaponValue;
	}

	public void setWeaponValue(Integer weaponValue) {
		this.weaponValue = weaponValue;
	}
	
	
	public static boolean RemoveWeapon(JavaPlugin server, Weapon weapon){
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try{
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.parse(new File(server.getDataFolder()+ "/weapons.xml"));
			NodeList nl = doc.getElementsByTagName("name");
			for(int i = 0; i <= nl.getLength(); i++){
				Node node = (Node) nl.item(i);
				Element e = (Element)node;
				if(e.getAttribute("name").equalsIgnoreCase(weapon.getWeaponName())){
					e.removeChild(node);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/weapons.xml"));
							
			transformer.transform(source, result);
		}
		catch(Exception e){
			server.getLogger().info(e.getMessage());
		}
		return true;
	}
	public static boolean AddWeapon(JavaPlugin server,Weapon weapon){
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try{
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.parse(new File(server.getDataFolder()+ "/weapons.xml"));
			Element mainRootElement = doc.getDocumentElement();
			// Create the Monster Attribute.
			Element Weapon = doc.createElement("Weapon");
			mainRootElement.appendChild(Weapon);
			// Set the Custom name for Monster.
			Weapon.setAttribute("WeaponName",weapon.getWeaponName());

			// Create the Monster Level field.
			Element MaterialID = doc.createElement("MaterialID");
			MaterialID.appendChild(doc.createTextNode(weapon.getWeapon().getType() +""));
			Weapon.appendChild(MaterialID);
						
			// Create the Monster Level field.
			Element Value = doc.createElement("Value");
			Value.appendChild(doc.createTextNode(weapon.getWeaponValue() + ""));
			Weapon.appendChild(Value);
			
			Element Lore = doc.createElement("Lore");
			Lore.appendChild(doc.createTextNode(weapon.weaponLore));
			Weapon.appendChild(Lore);
			
			// Create the Monster Level field.
			Element Enchantments = doc.createElement("Enchantments");
			Iterator<Entry<Enchantment, Integer>> it = getWeaponEnchantments().entrySet().iterator();
			while (it.hasNext()) {
			    Entry<Enchantment, Integer> e = it.next();
				Enchantments.appendChild(doc.createTextNode(e.getKey().getName()+ "-" + e.getValue() + " "));
			}
			Weapon.appendChild(Enchantments);
									

						// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(server.getDataFolder()+ "/weapons.xml"));
							
			transformer.transform(source, result);

		}
		catch(Exception e){
			server.getLogger().info(e.getMessage());
			return false;
		}
		return true;
	}
}
