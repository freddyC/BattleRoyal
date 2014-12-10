package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class CtrlTurnList implements Watcher{
	private CtrlStage stage;
	private List <ActionTurn> turns;
	private List <CtrlTurnListItem> turnsList;
	private ObservableList<CtrlTurnListItem> obsTurnsList;
	private ListView<CtrlTurnListItem> turnsListView;
	
	public CtrlTurnList (ListView<CtrlTurnListItem> turn_queue) {
		turnsListView = turn_queue;
		turns = new ArrayList<ActionTurn> ();
		resetLists();
		renderList();
	}
	
	public void addPlayerTurns (ActionTurn turn) {
		turns.add(turn);
	}
	
	private void renderList () {
		List<Player> players = Players.getInstance().getPlayers();
		turns = new ArrayList<ActionTurn> ();
		for (Player player : players) {
			if (player.hasTurn()) {
				turns.add(player.getTurn());
			}
		}
		
		for (ActionTurn turn : turns) {
			CtrlTurnListItem turnLI = new CtrlTurnListItem(turn);
			turnsList.add(turnLI);
		}		
	}
	
	private void resetLists() {
		turnsList = new ArrayList <CtrlTurnListItem> ();
		obsTurnsList = FXCollections.observableList(turnsList);
		turnsListView.setItems(obsTurnsList);
	}

	@Override
	public void fire(String watchedName) {
		resetLists();
		renderList();
	}
}
