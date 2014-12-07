package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


public class ControllerStartupScreen implements Watcher {
	private StageController stage;
	private ModelPlayers ms;
	private List <ControllerPlayerListItem> playersList;
	private ObservableList<ControllerPlayerListItem> obsPlayersList;
	
	
	@FXML
	private ListView players_list;
		
	@FXML
	private void initialize () throws IOException {
		stage = StageController.getInstance();
		ms = ModelPlayers.getInstance();
		ms.subscribe(this);
		resetLists();
		renderList();
		
//		for (int i = 0; i < 5; ++i) {
//			Character p = new Character();
//			p.setName("" + i);
//			p.setElement(Element.Fire);
//			p.updateAllVitals(i, i, i, i, i);
//			ms.addPlayer(p);
//		}
	}
	
	@FXML
	private void startCreatingNewPlayer() throws IOException {
		stage.changeView("ViewCreateUser.fxml");
	}
	
	@FXML
	private void startGame() {
	}
	
	public void removePlayer(ControllerPlayerListItem playerLI) {
		ms.removePlayer(playerLI.getPlayer());
	}

	@Override
	public void fire(String watchedName) {
		resetLists();
		renderList();
	}

	private void renderList () {
		List<Character> players = ms.getPlayers();
		for (Character player : players) {
			ControllerPlayerListItem playerLI = new ControllerPlayerListItem();
			playerLI.setplayer(player);
			playerLI.setStartupController(this);
			playersList.add(playerLI);
		}		
	}
	
	private void resetLists() {
		playersList = new ArrayList <ControllerPlayerListItem> ();
		obsPlayersList = FXCollections.observableList(playersList);
		players_list.setItems(obsPlayersList);
	}
}
