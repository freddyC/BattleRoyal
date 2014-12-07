package application;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {
	private static GameLoop instance = null;
	private List<GameAction> actions;
	private long lastTime;
	private boolean paused;
	
	
	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}
	

	public GameLoop() {
		paused = false;
		actions = new ArrayList<GameAction> ();
	}
	
	private void startLoop(long now) throws InterruptedException {
		if (actions.size() == 0 || paused) return;
		lastTime = lastTime == 0 ? now : lastTime;
		updateTimeLeft (lastTime - now);
		startLoop(System.currentTimeMillis());
	}
	
	private void updateTimeLeft (long ellapsedTime) {
		for (GameAction action : actions) {
			// TODO verify that when action is ready the remove from the Action class doesn't mess up this loop 
			action.decrament(ellapsedTime);
		}
	}

	public void addAction (GameAction a) throws InterruptedException {
		actions.add(a);
		if (actions.size() == 1) {
			startLoop(System.currentTimeMillis());
		}
	}

	public void removeAction (GameAction a) {
		actions.remove(a);
		if (actions.size() <= 0) {
			lastTime = 0;
		}
	}
	
	public void pause () {
		paused = true;
	}
	
	public void resume() throws InterruptedException {
		long now = System.currentTimeMillis();
		paused = false;
		lastTime = now;
		startLoop(now);
	}
}
