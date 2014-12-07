package application;

import java.util.HashMap;

public class Vitals {
	private HashMap<Stat, Integer> vitals;
	
	public Vitals () {
		vitals = new HashMap<Stat, Integer> ();
		vitals.put(Stat.HP, 250);
		vitals.put(Stat.Mana, 100);
		vitals.put(Stat.Stamina, 100);
		vitals.put(Stat.Intelect, 75);
		vitals.put(Stat.Speed, 75);
	}
	
	public int getVital (Stat vital) {
		return vitals.get(vital);
	}
	
	public void increaseVital (Stat vital, int increase) {
		vitals.put(vital, vitals.get(vital) + increase);
	}
	
	public void decreaseVital (Stat vital, int increase) {
		vitals.put(vital, vitals.get(vital) - increase);
	}

	public void updateAllVitals(int hp, int mana, int stamina, int intelect, int speed) {
		increaseVital(Stat.HP, hp);
		increaseVital(Stat.Mana, mana);
		increaseVital(Stat.Stamina, stamina);
		increaseVital(Stat.Intelect, intelect);
		increaseVital(Stat.Speed, speed);
	}
}
