package application;

public abstract class Action {
	private long prepTimeLeft;
	private GameLoop gl;
	
	public Action () {
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
		}
	}
	
	private void performAction() {
		
	}
}
