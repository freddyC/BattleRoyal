package application;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CtrlPlayerListItem extends CtrlListItem {
	private CtrlStartupScreen parent;	
	
	public CtrlPlayerListItem(Player player) {
		super(player,"ViewPlayerListItem.fxml");
	}
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;

	public void hydrate () {
		name.setText("" + 				((Player) data).getName());
		element.setText("Element: " + 	((Player) data).getElement());
		hp.setText("HP: " + 			((Player) data).getVital(StatEnum.HP));
		mana.setText("Mana: " + 		((Player) data).getVital(StatEnum.Mana));
		stamina.setText("Stamina: " + 	((Player) data).getVital(StatEnum.Stamina));
		intelect.setText("Intelect: " + ((Player) data).getVital(StatEnum.Intelect));
		speed.setText("Speed: " + 		((Player) data).getVital(StatEnum.Speed));
	}

	public void setStartupController(CtrlStartupScreen controller) {
		parent = controller;
	}

	@FXML
	protected void deleteMe () {
		parent.removeFromList(this);
	}
}
