package application;

import java.util.HashMap;
import java.util.Map;

public class QueueMaster implements Watcher {
	private static Map<String, Player> players = new HashMap <String, Player> (); 
	
	//	Make it a singleton
	private static class InstanceHolder {
		public static QueueMaster instance = new QueueMaster();
	}
	
	public static QueueMaster getInstance() {
		return InstanceHolder.instance;
	}
	
	
	@Override
	public void fire(String watchedName) {
		
	}
}
