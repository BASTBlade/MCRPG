package com.blade.RPG.models;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Weapon {
	private Enchantment[] weaponEnchantments;
	private List<String> weaponLore;
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

	public List<String> getWeaponLore() {
		return weaponLore;
	}

	public void setWeaponLore(List<String> weaponLore) {
		this.weaponLore = weaponLore;
	}

	public Enchantment[] getWeaponEnchantments() {
		return weaponEnchantments;
	}

	public void setWeaponEnchantments(Enchantment[] weaponEnchantments) {
		this.weaponEnchantments = weaponEnchantments;
	}

	public Integer getWeaponValue() {
		return weaponValue;
	}

	public void setWeaponValue(Integer weaponValue) {
		this.weaponValue = weaponValue;
	}
}
