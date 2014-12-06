package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ControllerPlayerListItem extends AnchorPane {
	private Character player;
	private ControllerStartupScreen startupController;	
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;
	
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

	public void setplayer (Character p) {
		player = p;
		name.setText("Name: " + player.getName());
		element.setText("Element: " + player.getElement());
		hp.setText("HP: " + player.getVital(Stat.HP));
		mana.setText("Mana: " + player.getVital(Stat.Mana));
		stamina.setText("Stamina: " + player.getVital(Stat.Stamina));
		intelect.setText("Intelect: " + player.getVital(Stat.Intelect));
		speed.setText("Speed: " + player.getVital(Stat.Speed));
	}

	public void setStartupController(ControllerStartupScreen controller) {
		startupController = controller;
	}

	@FXML
	protected void deleteMe () {
		startupController.removePlayer(this);
	}
}
