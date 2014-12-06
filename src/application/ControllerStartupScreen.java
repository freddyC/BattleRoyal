package application;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class ControllerStartupScreen {
	StageController stage;
	ModelPlayers ms;
	
	@FXML
	private VBox players_list;
	
	@FXML
	private void initialize () throws IOException {
		stage = StageController.getInstance();
		ms = ModelPlayers.getInstance();
		List<Character> players = ms.getPlayers();
		for (int i = 0; i < players.size(); ++i) {
			addPlayerToList(players.get(i), i);
		}
	}
	
	@FXML
	private void addPlayer() throws IOException {
		stage.changeView("ViewCreateUser.fxml");
	}
	
	
	private void addPlayerToList (Character player, int i) throws IOException {
		ControllerPlayerListItem playerLI = new ControllerPlayerListItem();
		playerLI.setplayer(player);
		playerLI.setStartupController(this);
		players_list.getChildren().add(playerLI);
	}
	
	@FXML
	private void startGame() {
	}
	
	public void removePlayer(ControllerPlayerListItem playerLI) {
		players_list.getChildren().remove(playerLI);
		ms.removePlayer(playerLI.getPlayer());
	}
}
