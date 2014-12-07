package application;

import java.util.ArrayList;
import java.util.List;

public class ModelPlayers {
	private static ModelPlayers instance = null;
	private List<Character> players;
	private Watched playersCount;
	
	protected ModelPlayers () {
		// this is to keep it a singleton
		players = new ArrayList <Character> ();
		playersCount = new Watched("playersCount");
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
	
	public void subscribe (Watcher w) {
		playersCount.subscribe(w);
	}
	
	public void unsubscribe (Watcher w) {
		playersCount.unsubscribe(w);
	}
	
	public void addPlayer (Character player) {
		players.add(player);
		playersCount.fire();
	}
	
	public void removePlayer (Character player) {
		players.remove(player);
		playersCount.fire();
	}
}
