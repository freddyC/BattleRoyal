package application;

import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable {
	private Thread t;
	private List<GameAction> actions;
	private long lastTime, DELAY = 500;
	private boolean paused, running;
	
	private static class InstanceHolder {
		public static GameLoop instance = new GameLoop();
	}
	
	public static GameLoop getInstance() {
		return InstanceHolder.instance;
	}
	
	
	protected GameLoop() {
		paused = false;
		actions = new ArrayList<GameAction> ();
	}
	
	private void updateTimeLeft (long elapsedTime) {
		System.out.println("elapsed time = " + elapsedTime);
		for (GameAction action : actions) {
			action.decrament(elapsedTime);
		}
		for (GameAction action : actions) {
			action.check();
		}
	}

	public void addAction (GameAction a) throws InterruptedException {
		actions.add(a);
		if (!running) {
			if (t == null) {
				t = new Thread(this);
			}
			t.start();
		}
	}

	public void removeAction (GameAction a) {
		actions.remove(a);
		if (actions.size() <= 0) {
			lastTime = 0;
			t = null;
		}
	}
	
	public void pause () {
		paused = true;
	}
	
	public void resume() throws InterruptedException {
		paused = false;
		t.start();
	}
	
	@Override
	public void run() {
		lastTime = System.currentTimeMillis();
		running = true;
		while (actions.size() != 0 && !paused) {
			updateTimeLeft (System.currentTimeMillis() - lastTime);
			lastTime = System.currentTimeMillis();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		running = false;
	}
}
