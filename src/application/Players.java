package application;

import java.util.ArrayList;
import java.util.List;

public class Players implements GameData{
	private static Players instance = null;
	private List<Player> players;
	private Watched playersCount;
	
	protected Players () {
		// this is to keep it a singleton
		players = new ArrayList <Player> ();
		playersCount = new Watched("playersCount");
	}
	
	public static Players getInstance () {
		if (instance == null) {
			instance = new Players();
		}
		return instance;
	}
	
	public List<Player> getPlayers () {
		return players;
	}
	
	public void subscribeToPlayersList (Watcher w) {
		playersCount.subscribe(w);
	}
	
	public void unsubscribeToPlayersList (Watcher w) {
		playersCount.unsubscribe(w);
	}
	
	public void addPlayer (Player player) {
		players.add(player);
		playersCount.fire();
	}
	
	public void removePlayer (Player player) {
		players.remove(player);
		playersCount.fire();
	}
}
