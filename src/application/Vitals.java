package application;

import java.util.HashMap;

public class Vitals implements GameData{
	private HashMap<EnumStat, Integer> vitals;
	
	public Vitals () {
		vitals = new HashMap<EnumStat, Integer> ();
		vitals.put(EnumStat.HP, 250);
		vitals.put(EnumStat.Mana, 100);
		vitals.put(EnumStat.MissingHP, 0);
		vitals.put(EnumStat.MissingMana, 0);
		vitals.put(EnumStat.Stamina, 100);
		vitals.put(EnumStat.Intelect, 75);
		vitals.put(EnumStat.Speed, 75);
	}
	
	public int getVital (EnumStat vital) {
		return vitals.get(vital);
	}
	
	public void change (EnumStat vital, int change) {
		vitals.put(vital, vitals.get(vital) + change);
	}
	
	public void updateAllVitals(int hp, int mana, int stamina, int intelect, int speed) {
		change(EnumStat.HP, hp);
		change(EnumStat.Mana, mana);
		change(EnumStat.Stamina, stamina);
		change(EnumStat.Intelect, intelect);
		change(EnumStat.Speed, speed);
	}
}
