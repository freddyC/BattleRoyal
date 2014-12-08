package application;

public class GameActPlayersTurn extends GameAction implements GameData, Runnable {

	public GameActPlayersTurn(String name, long waitTime) {
		super(name, waitTime);
	}

	@Override
	protected void update() {
		//	This is where updating any gui stuff goes based on the time left after each decriment
	}

	@Override
	protected void performAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
