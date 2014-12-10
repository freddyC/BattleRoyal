package application;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CtrlPlayerListItem extends CtrlListItem {
	private CtrlStartupScreen parent;	
	
	public CtrlPlayerListItem(Player player) {
		super(player,"ViewPlayerListItem.fxml");
		hydrate();
	}
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;

	public void hydrate () {
		name.setText("" + 				((Player) data).getName());
		element.setText("Element: " + 	((Player) data).getElement());
		hp.setText("HP: " + 			((Player) data).getVital(EStat.HP));
		mana.setText("Mana: " + 		((Player) data).getVital(EStat.Mana));
		stamina.setText("Stamina: " + 	((Player) data).getVital(EStat.Stamina));
		intelect.setText("Intelect: " + ((Player) data).getVital(EStat.Intelect));
		speed.setText("Speed: " + 		((Player) data).getVital(EStat.Speed));
	}

	public void setStartupController(CtrlStartupScreen controller) {
		parent = controller;
	}

	@FXML
	protected void deleteMe () {
		parent.removeFromList(this);
	}
}
