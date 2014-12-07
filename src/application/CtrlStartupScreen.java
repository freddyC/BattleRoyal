package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class CtrlStartupScreen implements UtilWatcher {
	private CtrlStage stage;
	private ModelPlayers ms;
	private List <CtrlPlayerListItem> playersList;
	private ObservableList<CtrlPlayerListItem> obsPlayersList;
	
	
	@FXML
	private ListView<CtrlPlayerListItem> players_list;
		
	@FXML
	private void initialize () throws IOException {
		stage = CtrlStage.getInstance();
		ms = ModelPlayers.getInstance();
		ms.subscribeToPlayersList(this);
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
	
	public void removePlayer(CtrlPlayerListItem playerLI) {
		ms.removePlayer(playerLI.getPlayer());
	}

	@Override
	public void fire(String watchedName) {
		resetLists();
		renderList();
	}

	private void renderList () {
		List<GameCharacter> players = ms.getPlayers();
		for (GameCharacter player : players) {
			CtrlPlayerListItem playerLI = new CtrlPlayerListItem();
			playerLI.setplayer(player);
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
