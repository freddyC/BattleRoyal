package application;

import java.util.ArrayList;
import java.util.List;

public class Players implements GameData{
	private static Players instance = null;
	private static List<Player> players = new ArrayList <Player> ();
	private Watched playersCount;
	
	protected Players () {
		// this is to keep it a singleton
		playersCount = new Watched("players count updated");
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

	public static boolean invalidName(String n) {
		for (Player player : players) {
			if (n.equals(player.getName())) {
				return true;
			}
		}
		return false;
	}
}
