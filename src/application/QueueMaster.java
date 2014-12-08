package application;

import java.util.Map;

public class QueueMaster implements Watcher {
	private Map players; 
	
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
