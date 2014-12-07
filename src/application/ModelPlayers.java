package application;

import java.util.ArrayList;
import java.util.List;

public class ModelPlayers {
	private static ModelPlayers instance = null;
	private List<GameCharacter> players;
	private UtilWatched playersCount;
	
	protected ModelPlayers () {
		// this is to keep it a singleton
		players = new ArrayList <GameCharacter> ();
		playersCount = new UtilWatched("playersCount");
	}
	
	public static ModelPlayers getInstance () {
		if (instance == null) {
			instance = new ModelPlayers();
		}
		return instance;
	}
	
	public List<GameCharacter> getPlayers () {
		return players;
	}
	
	public void subscribeToPlayersList (UtilWatcher w) {
		playersCount.subscribe(w);
	}
	
	public void unsubscribeToPlayersList (UtilWatcher w) {
		playersCount.unsubscribe(w);
	}
	
	public void addPlayer (GameCharacter player) {
		players.add(player);
		playersCount.fire();
	}
	
	public void removePlayer (GameCharacter player) {
		players.remove(player);
		playersCount.fire();
	}
}
