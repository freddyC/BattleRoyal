package application;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class GameLoop implements Runnable {
	private Thread loopThread;
	private ConcurrentHashMap<String, GameAction> actions;
	private long lastTime, DELAY = 500;
	private boolean isPaused, isRunning;
	
	private static class InstanceHolder {
		public static GameLoop instance = new GameLoop();
	}
	
	public static GameLoop getInstance() {
		return InstanceHolder.instance;
	}
	
	
	protected GameLoop() {
		isPaused = false;
		actions = new ConcurrentHashMap<String, GameAction>();
	}
	
	private void updateTimeLeft (long elapsedTime) {
		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			 actions.get(i.next()).decrament(elapsedTime);
		}
		for (Iterator<String> i = actions.keySet().iterator(); i.hasNext();) {
			new Thread(actions.get(i.next())).start();
		}
			
	}

	public void addAction (GameAction a) throws InterruptedException {
		actions.put(a.getActionName(), a);
		if (!isRunning) {
			if (loopThread == null) {
				loopThread = new Thread(this);
			}
			loopThread.start();
		}
	}

	public void removeAction (String key) {
		System.out.println("Hash of size " + actions.size());
		actions.remove(key);
		System.out.println("Hash of size " + actions.size());
	}
	
	public void pause () {
		isPaused = true;
	}
	
	public void resume() throws InterruptedException {
		isPaused = false;
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
