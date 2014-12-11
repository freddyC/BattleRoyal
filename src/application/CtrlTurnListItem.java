package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class CtrlTurnListItem extends CtrlListItem implements Watcher{
	private Player player;
	private ActionTurn turn;

	public CtrlTurnListItem (ActionTurn t) {
		super(t.getPlayer(), "ViewTurnListItem.fxml");
		player = t.getPlayer();
		turn = t;
		hydrate();
		name.setText(player.getName());
		GameLoop.subscribe(this);
		element.setText(player.getElement().toString());
	}
	
	@FXML
	Label name, element;
	
	@FXML
	private ProgressBar hp_bar, time_bar;

	public void hydrate () {
		updateHpProgress();
		updateTimeProgress();
	}

	private void updateHpProgress () {
		hp_bar.setProgress(
				(player.getVital(EnumStat.HP) - player.getVital(EnumStat.MissingHP)) / 
				player.getVital(EnumStat.HP)
			);
	}
	
	private void updateTimeProgress () {
		turn = player.getTurn();
		double left = turn.getPrepTimeLeft();
		double total = turn.getTotalTime();
		
		double prog = (1 - (left / total));
		if (prog < 0) {
			prog = 0;
		}
		if (prog > 1) {
			prog = 1;
		}
		time_bar.setProgress(prog);
	}

	@Override
	public void fire(String watchedName) {
		hydrate();
	}
}
