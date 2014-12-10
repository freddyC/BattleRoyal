package application;

public class ActionTurn extends Action {
	private Player player;
	private long totalTime;
	
	
	public void setPlayer (Player p) {
		player = p;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public ActionTurn(String name, long waitTime, Player p) {
		super("turn - " + name, waitTime);
		player = p;
		totalTime = waitTime;
	}

	@Override
	protected void update() {
		//	This is where updating any gui stuff goes based on the time left after each decriment
	}
	
	@Override
	protected void performAction() {
		TurnMaster.playerReadyToChoose(this);
	}

	public long getTotalTime() {
		return totalTime;
	}

	public int compare(ActionTurn me, ActionTurn them) {
		return (int) (me.getPrepTimeLeft() - them.getPrepTimeLeft());
	}
}
