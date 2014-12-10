package application;

import java.util.HashMap;

public class Vitals implements GameData{
	private HashMap<EStat, Integer> vitals;
	
	public Vitals () {
		vitals = new HashMap<EStat, Integer> ();
		vitals.put(EStat.HP, 250);
		vitals.put(EStat.Mana, 100);
		vitals.put(EStat.MissingHP, 0);
		vitals.put(EStat.MissingMana, 0);
		vitals.put(EStat.Stamina, 100);
		vitals.put(EStat.Intelect, 75);
		vitals.put(EStat.Speed, 75);
	}
	
	public int getVital (EStat vital) {
		return vitals.get(vital);
	}
	
	public void increaseVital (EStat vital, int increase) {
		vitals.put(vital, vitals.get(vital) + increase);
	}
	
	public void decreaseVital (EStat vital, int increase) {
		vitals.put(vital, vitals.get(vital) - increase);
	}

	public void updateAllVitals(int hp, int mana, int stamina, int intelect, int speed) {
		increaseVital(EStat.HP, hp);
		increaseVital(EStat.Mana, mana);
		increaseVital(EStat.Stamina, stamina);
		increaseVital(EStat.Intelect, intelect);
		increaseVital(EStat.Speed, speed);
	}
}
