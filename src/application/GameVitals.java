package application;

import java.util.HashMap;

public class GameVitals {
	private HashMap<GameStat, Integer> vitals;
	
	public GameVitals () {
		vitals = new HashMap<GameStat, Integer> ();
		vitals.put(GameStat.HP, 250);
		vitals.put(GameStat.Mana, 100);
		vitals.put(GameStat.Stamina, 100);
		vitals.put(GameStat.Intelect, 75);
		vitals.put(GameStat.Speed, 75);
	}
	
	public int getVital (GameStat vital) {
		return vitals.get(vital);
	}
	
	public void increaseVital (GameStat vital, int increase) {
		vitals.put(vital, vitals.get(vital) + increase);
	}
	
	public void decreaseVital (GameStat vital, int increase) {
		vitals.put(vital, vitals.get(vital) - increase);
	}

	public void updateAllVitals(int hp, int mana, int stamina, int intelect, int speed) {
		increaseVital(GameStat.HP, hp);
		increaseVital(GameStat.Mana, mana);
		increaseVital(GameStat.Stamina, stamina);
		increaseVital(GameStat.Intelect, intelect);
		increaseVital(GameStat.Speed, speed);
	}
}
