package application;

import java.util.ArrayList;
import java.util.List;

public class GameLoop {
	private static GameLoop instance = null;
	private List<Action> actions;
	private long currentTime, lastTime;
	private boolean paused;
	
	
	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}
	

	public GameLoop() {
		paused = false;
		actions = new ArrayList<Action> ();
	}
	
	private void startLoop(long now) throws InterruptedException {
		if (actions.size() == 0 || paused) return;
		currentTime = now;
		lastTime = lastTime == 0 ? now : lastTime;
		act(lastTime - now);
		startLoop(System.currentTimeMillis());
	}
	
	private void act(long ellapsedTime) {
		for (Action a : actions) {
			a.decrament(ellapsedTime);
		}
	}

	public void addAction (Action a) throws InterruptedException {
		actions.add(a);
		if (actions.size() == 1) {
			startLoop(System.currentTimeMillis());
		}
	}

	public void removeAction (Action a) {
		actions.remove(a);
		if (actions.size() <= 0) {
			currentTime = 0;
			lastTime = 0;
		}
	}
	
	public void pause () {
		paused = true;
	}
	
	public void resume() throws InterruptedException {
		long now = System.currentTimeMillis();
		paused = false;
		currentTime = now;
		lastTime = now;
		startLoop(now);
	}
}
