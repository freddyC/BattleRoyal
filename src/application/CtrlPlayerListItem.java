package application;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CtrlPlayerListItem extends AnchorPane {
	private GameCharacter player;
	private CtrlStartupScreen startupController;	
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;
	
	public CtrlPlayerListItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewPlayerListItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public GameCharacter getPlayer() {
		return player;
	}

	public void setplayer (GameCharacter p) {
		player = p;
		name.setText("Name: " + player.getName());
		element.setText("Element: " + player.getElement());
		hp.setText("HP: " + player.getVital(GameStat.HP));
		mana.setText("Mana: " + player.getVital(GameStat.Mana));
		stamina.setText("Stamina: " + player.getVital(GameStat.Stamina));
		intelect.setText("Intelect: " + player.getVital(GameStat.Intelect));
		speed.setText("Speed: " + player.getVital(GameStat.Speed));
	}

	public void setStartupController(CtrlStartupScreen controller) {
		startupController = controller;
	}

	@FXML
	protected void deleteMe () {
		startupController.removePlayer(this);
	}
}
