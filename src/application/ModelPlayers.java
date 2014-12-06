package application;

import java.util.ArrayList;
import java.util.List;

public class ModelPlayers {
	private static ModelPlayers instance = null;
	private List<Character> players;
	
	protected ModelPlayers () {
		// this is to keep it a singleton
		players = new ArrayList <Character> ();
	}
	
	public static ModelPlayers getInstance () {
		if (instance == null) {
			instance = new ModelPlayers();
		}
		return instance;
	}
	
	public List<Character> getPlayers () {
		return players;
	}
	
	public void addPlayer (Character player) {
		players.add(player);
	}
	
	public void removePlayer (Character player) {
		players.remove(player);
	}
}
