package application;

public class Loop implements Runnable{
	private GameLoop gl;
	private final long DELAY = 150;
	
	public Loop (GameLoop g) {
		gl = g;
	}
	
	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		while (true) {
			if (gl.isNotPaused()) {
				gl.updateTimeLeft (System.currentTimeMillis() - lastTime);	
			}
			lastTime = System.currentTimeMillis();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
