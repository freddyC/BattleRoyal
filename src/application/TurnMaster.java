package application;

import java.util.ArrayList;
import java.util.List;

public class TurnMaster {
	private List<ActionTurn> turns;
	private Watched turnChanged;
	
	private TurnMaster () {
		turns = new ArrayList<ActionTurn>();
		turnChanged = new Watched ("A player finished a turn");
	}
	
	public static void subscribe(Watcher w) {
		getInstance().turnChanged.subscribe(w);
	}

	private static class InstanceHolder {
		public static TurnMaster instance = new TurnMaster();
	}
	
	public static TurnMaster getInstance() {
		return InstanceHolder.instance;
	}
	
	private void addTurn (ActionTurn turn) {
		turns.add(turn);
		if (turns.size() == 1) {
			getChoice();
		}
	}
	
	private void getChoice() {
		// Get The Players Choice
		ActionTurn turn = turns.get(0);
		turns.remove(0);
		Player player = turn.getPlayer();
		long choiceLength = getPlayersChoice(player);
		player.queueTurn((Tools.TURN_LENGTH - player.getVital(EStat.Speed)) + choiceLength);
		turnChanged.fire();
		if (turns.size() > 0) {
			getChoice();
		}
	}		
	
	long getPlayersChoice (Player p) {
		// this function will need to be directed to the players choice interface
		// then return the length of the choice the player made i.e. if it was an attack
		// that needs to power up then it returns the time it takes for that power up
		return 5000;
	}
	
	public static void playerReadyToChoose(ActionTurn turn) {
		getInstance().addTurn (turn);
	}
}
