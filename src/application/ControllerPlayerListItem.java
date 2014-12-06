package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ControllerPlayerListItem extends AnchorPane {
	private Character player;
	private ControllerStartupScreen startupController;	
	
	public ControllerPlayerListItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewPlayerListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}


	public void setplayer (Character p) {
		player = p;
	}

	public void setStartupController(ControllerStartupScreen controller) {
		startupController = controller;
	}

	@FXML
	protected void deleteMe () {
		startupController.removePlayer(this);
	}
}
