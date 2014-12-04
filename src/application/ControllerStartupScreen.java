package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ControllerStartupScreen {
	StageController stage;
	
	@FXML
	private VBox players_list;
	
	@FXML
	private void initialize () throws IOException {
		stage = StageController.getInstance();
		ModelStarter ms = ModelStarter.getInstance();
		List<Character> players = ms.getPlayers();
		for (Character p : players) {
			createPlayer(p);
		}
	}
	
	@FXML
	private void addPlayer() throws IOException {
		System.out.println("Create Player");
		stage.changeView("ViewCreateUser.fxml");
	}
	
	private void createPlayer (Character player) {
		players_list.getChildren().add(new Button("test"));
	}
	
	private void startGame() {
		
	}
	
}
