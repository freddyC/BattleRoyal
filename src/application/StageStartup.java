package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class StageStartup implements Watcher {
	private CtrlStage stage;
	private Players playersContainer;
	private List <CtrlPlayerListItem> playersList;
	private ObservableList<CtrlPlayerListItem> obsPlayersList;
	
	
	@FXML
	private ListView<CtrlPlayerListItem> players_list;
		
	@FXML
	private void initialize () throws IOException {
		stage = CtrlStage.getInstance();
		playersContainer = Players.getInstance();
		playersContainer.subscribeToPlayersList(this);
		resetLists();
		renderList();
	}
	
	@FXML
	private void startCreatingNewPlayer() throws IOException {
		stage.changeView("ViewCreateUser.fxml");
	}
	
	@FXML
	private void startGame() throws IOException  {
		stage.changeView("ViewGameBoard.fxml");
	}
	
	public void removeFromList(CtrlPlayerListItem playerLI) {
		playersContainer.removePlayer((Player) playerLI.getGameData());
	}

	@Override
	public void fire(String watchedName) {
		resetLists();
		renderList();
	}

	private void renderList () {
		List<Player> players = playersContainer.getPlayers();
		for (Player player : players) {
			CtrlPlayerListItem playerLI = new CtrlPlayerListItem(player);
			playerLI.setStartupController(this);
			playersList.add(playerLI);
		}		
	}
	
	private void resetLists() {
		playersList = new ArrayList <CtrlPlayerListItem> ();
		obsPlayersList = FXCollections.observableList(playersList);
		players_list.setItems(obsPlayersList);
	}
}
