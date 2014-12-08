package application;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class GameLoop implements Runnable {
	private static Thread loopThread;
	private static ConcurrentHashMap<String, Action> actions = new ConcurrentHashMap<String, Action>();
	private long lastTime, DELAY = 500;
	private static boolean isPaused = false;
	private static boolean isRunning = false;
	
	private static class InstanceHolder {
		public static GameLoop instance = new GameLoop();
	}
	
	public static GameLoop getInstance() {
		return InstanceHolder.instance;
	}
	
	
	private GameLoop() {
//	Don't instantiate me
	}
	
	private void updateTimeLeft (long elapsedTime) {
		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			 actions.get(i.next()).decrament(elapsedTime);
		}
		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			new Thread(actions.get(i.next())).start();
		}
			
	}

	public static void addAction (Action a) throws InterruptedException {
		actions.put(a.getActionName(), a);
		if (!isRunning) {
			loopThread = new Thread(getInstance());
			loopThread.start();
		}
	}

	public static void removeAction (String key) {
		actions.remove(key);
	}
	
	public static void pause () {
		isPaused = true;
	}
	
	public static void resume() throws InterruptedException {
		isPaused = false;
		loopThread = new Thread(getInstance());
		loopThread.start();
	}
	
	@Override
	public void run() {
		lastTime = System.currentTimeMillis();
		isRunning = true;
		while (actions.size() > 0 && !isPaused) {
			
			updateTimeLeft (System.currentTimeMillis() - lastTime);
			lastTime = System.currentTimeMillis();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isRunning = false;
	}
}
