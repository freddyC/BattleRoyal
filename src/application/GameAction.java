package application;

public abstract class GameAction implements GameData{
	private long prepTimeLeft;
	private GameLoop gl;
	
//	To be overwritten
	protected abstract void update();
	protected abstract void performAction();
	
	public GameAction (long waitTime) {
		prepTimeLeft = waitTime;
		gl = GameLoop.getInstance();
		setPrepTime(waitTime);
	}
	
	public void setPrepTime (long p) {
		prepTimeLeft = p;
	}
	
	public void check() {
		if (prepTimeLeft <= 0) {
			this.performAction();
			gl.removeAction(this);
		} else {
			update();
		}
	}
	
	public void decrament (long elapsedTime) {
		prepTimeLeft -= elapsedTime;
	}
}
