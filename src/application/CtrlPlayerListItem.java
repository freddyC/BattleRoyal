package application;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CtrlPlayerListItem extends CtrlListItem {
	private CtrlStartupScreen parent;	
	
	public CtrlPlayerListItem(GameCharacter player) {
		super(player,"ViewPlayerListItem.fxml");
	}
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;

	public void hydrate () {
		name.setText("" + 				((GameCharacter) data).getName());
		element.setText("Element: " + 	((GameCharacter) data).getElement());
		hp.setText("HP: " + 			((GameCharacter) data).getVital(GameStat.HP));
		mana.setText("Mana: " + 		((GameCharacter) data).getVital(GameStat.Mana));
		stamina.setText("Stamina: " + 	((GameCharacter) data).getVital(GameStat.Stamina));
		intelect.setText("Intelect: " + ((GameCharacter) data).getVital(GameStat.Intelect));
		speed.setText("Speed: " + 		((GameCharacter) data).getVital(GameStat.Speed));
	}

	public void setStartupController(CtrlStartupScreen controller) {
		parent = controller;
	}

	@FXML
	protected void deleteMe () {
		parent.removeFromList(this);
	}
}
