package application;

public abstract class Action extends Watched implements GameData, Runnable {
	private long prepTimeLeft;
	String name;
	
//	To be overwritten
	protected abstract void update();
	protected abstract void performAction();
	
	public Action (String nameId, long waitTime) {
		super("action - " + nameId);
		name = nameId;
		prepTimeLeft = waitTime;
		setPrepTime(waitTime);
	}
	
	@Override
	public void run() {
		if (prepTimeLeft <= 0) {
			performAction();
			GameLoop.removeAction(name);
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
