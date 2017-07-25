package com.blade.RPG.models;

// This is the class for the player data and the RPG model which will help understand the plugin which player it is and what meta data this player has.
// This class will not be editable with a config or xml file because this will always be the same.
public class User {
	private String UUID;
	private String DisplayName;
	private int XP;
	private RPGClass rpgclass;
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
	public RPGClass getRpgclass() {
		return rpgclass;
	}
	public void setRpgclass(RPGClass rpgclass) {
		this.rpgclass = rpgclass;
	}
	public int[] getQuestsProgress() {
		return questsProgress;
	}
	public void setQuestsProgress(int[] questsProgress) {
		this.questsProgress = questsProgress;
	}
}
