package application;

import java.util.ArrayList;
import java.util.List;

public class ModelStarter {
	private static ModelStarter instance = null;
	private List<Character> players;
	
	protected ModelStarter () {
		// this is to keep it a singleton
		players = new ArrayList <Character> ();
	}
	
	public static ModelStarter getInstance () {
		if (instance == null) {
			instance = new ModelStarter();
		}
		return instance;
	}
	
	public List<Character> getPlayers () {
		return players;
	}
	
	public void addPlayer (Character player) {
		players.add(player);
	}
}
