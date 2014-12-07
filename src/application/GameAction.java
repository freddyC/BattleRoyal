package application;

public abstract class GameAction {
	private long prepTimeLeft;
	private GameLoop gl;
	
//	To be overwritten
	protected abstract void update();
	protected abstract void performAction();
	
	public GameAction (long waitTime) {
		prepTimeLeft = waitTime;
		gl = GameLoop.getInstance();
	}
	
	public void setPrepTime (long p) {
		prepTimeLeft = p;
	}
	
	public void decrament (long elapsedTime) {
		prepTimeLeft -= elapsedTime;
		if (prepTimeLeft <= 0) {
			this.performAction();
			gl.removeAction(this);
		} else {
			update();
		}
	}
}
