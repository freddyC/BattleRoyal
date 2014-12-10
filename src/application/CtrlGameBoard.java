package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CtrlGameBoard {
	CtrlTurnList turnsCtrl;
	
	@FXML
	private Label next_up_title;

	@FXML
	private ListView<CtrlTurnListItem> turn_queue;
	

	
	@FXML
	private void initialize () throws IOException {
		System.out.println("INIT FOR CTRL GAME BOARD");
		turnsCtrl = new CtrlTurnList (turn_queue);
	}
}
