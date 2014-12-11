package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class StageGameBoard {
	CtrlTurnList turnsCtrl;
	CtrlEventsList eventsCtrl;
	
	@FXML
	private Label next_up_title;

	@FXML
	private ListView<CtrlTurnListItem> turn_queue;
	
	@FXML
	private ListView<CtrlEventListItem> events_queue;
	
	
	@FXML
	private void initialize () throws IOException {
		turnsCtrl = new CtrlTurnList (turn_queue);
		eventsCtrl = new CtrlEventsList(events_queue);
	}
}
