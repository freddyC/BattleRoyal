package application;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class GameLoop {
	private static ConcurrentHashMap<String, Action> actions = new ConcurrentHashMap<String, Action>();
	private static boolean wasStarted = false;
	private static boolean isNotPaused = true;
	private static Thread glThread;
	private static Watched ticker;
	
	private static class InstanceHolder {
		public static GameLoop instance = new GameLoop();
	}
	
	public static GameLoop getInstance() {
		return InstanceHolder.instance;
	}
	
	public static void subscribe (Watcher w) {
		getInstance().ticker.subscribe(w);
	}
	
	public static void unsubscribe (Watcher w) {
		getInstance().ticker.unsubscribe(w);
	}
	
	private GameLoop() {
		ticker = new Watched ("time-ticker");
	}
	
	public void updateTimeLeft (long elapsedTime) {
		new Thread(ticker.fireAsync()).start();
		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			actions.get(i.next()).decrament(elapsedTime);
		}

		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			new Thread(actions.get(i.next())).start();
		}
			
	}

	public static void addAction (Action a) {
		actions.put(a.getActionName(), a);
		if (!wasStarted) {
			glThread = new Thread(new Loop(getInstance()));
			glThread.start();
			wasStarted = true;
		}
	}

	public synchronized static void removeAction (String key) {
		actions.remove(key);
	}
	
	public static void pause () {
		isNotPaused = false;
	}
	
	public static void resume() {
		isNotPaused = true;
	}
	

	public boolean isNotPaused() {
		return isNotPaused;
	}
}
