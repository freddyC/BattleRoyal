package application;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CtrlPlayerListItem extends CtrlListItem {
	private StageStartup parent;	
	
	public CtrlPlayerListItem(Player player) {
		super(player,"ViewPlayerListItem.fxml");
		hydrate();
	}
	
	@FXML
	Label name, element, hp, mana, stamina, intelect, speed;

	public void hydrate () {
		name.setText("" + 				((Player) data).getName());
		element.setText("Element: " + 	((Player) data).getElement());
		hp.setText("HP: " + 			((Player) data).getVital(EnumStat.HP));
		mana.setText("Mana: " + 		((Player) data).getVital(EnumStat.Mana));
		stamina.setText("Stamina: " + 	((Player) data).getVital(EnumStat.Stamina));
		intelect.setText("Intelect: " + ((Player) data).getVital(EnumStat.Intelect));
		speed.setText("Speed: " + 		((Player) data).getVital(EnumStat.Speed));
	}

	public void setStartupController(StageStartup controller) {
		parent = controller;
	}

	@FXML
	protected void deleteMe () {
		parent.removeFromList(this);
	}
}
