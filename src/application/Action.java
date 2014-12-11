package application;

public abstract class Action extends Watched implements GameData, Runnable {
	protected long prepTimeLeft;
	protected String name;
	
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
			System.out.println("perform action --> " + name);
			GameLoop.removeAction(name);
			performAction();
		} else {
			update();
		}
	}
	
	public void setPrepTime (long p) {
		prepTimeLeft = p;
	}
	
	public long getPrepTimeLeft () {
		return prepTimeLeft;
	}
		
	public void decrament (long elapsedTime) {
		prepTimeLeft -= elapsedTime;
	}

	public String getActionName() {
		return name;
	}
}
