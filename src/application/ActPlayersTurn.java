package application;

public class ActPlayersTurn extends Action {
	public ActPlayersTurn(String name, long waitTime) {
		super("turn - " + name, waitTime);
	}

	@Override
	protected void update() {
		//	This is where updating any gui stuff goes based on the time left after each decriment
	}

	@Override
	protected void performAction() {
		// TODO Auto-generated method stub
	}
}
