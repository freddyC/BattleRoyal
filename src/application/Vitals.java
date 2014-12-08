package application;

import java.util.HashMap;

public class Vitals implements GameData{
	private HashMap<StatEnum, Integer> vitals;
	
	public Vitals () {
		vitals = new HashMap<StatEnum, Integer> ();
		vitals.put(StatEnum.HP, 250);
		vitals.put(StatEnum.Mana, 100);
		vitals.put(StatEnum.Stamina, 100);
		vitals.put(StatEnum.Intelect, 75);
		vitals.put(StatEnum.Speed, 75);
	}
	
	public int getVital (StatEnum vital) {
		return vitals.get(vital);
	}
	
	public void increaseVital (StatEnum vital, int increase) {
		vitals.put(vital, vitals.get(vital) + increase);
	}
	
	public void decreaseVital (StatEnum vital, int increase) {
		vitals.put(vital, vitals.get(vital) - increase);
	}

	public void updateAllVitals(int hp, int mana, int stamina, int intelect, int speed) {
		increaseVital(StatEnum.HP, hp);
		increaseVital(StatEnum.Mana, mana);
		increaseVital(StatEnum.Stamina, stamina);
		increaseVital(StatEnum.Intelect, intelect);
		increaseVital(StatEnum.Speed, speed);
	}
}
