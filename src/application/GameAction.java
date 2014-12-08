package application;

public abstract class GameAction implements GameData, Runnable {
	private long prepTimeLeft;
	private GameLoop gl;
	String name;
	
//	To be overwritten
	protected abstract void update();
	protected abstract void performAction();
	
	public GameAction (String nameId, long waitTime) {
		name = nameId;
		prepTimeLeft = waitTime;
		gl = GameLoop.getInstance();
		setPrepTime(waitTime);
	}
	
	@Override
	public void run() {
		System.out.println("Made it to the run function");
		if (prepTimeLeft <= 0) {
			performAction();
			gl.removeAction(name);
		} else {
			update();
		}
	}
	
	public void setPrepTime (long p) {
		prepTimeLeft = p;
	}
		
	public void decrament (long elapsedTime) {
		prepTimeLeft -= elapsedTime;
		System.out.println(name + ", Time Left = " + prepTimeLeft + " Elapsed Time = " + elapsedTime);
	}
	public String getActionName() {
		return name;
	}
}
