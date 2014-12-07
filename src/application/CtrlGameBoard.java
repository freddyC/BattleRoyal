package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CtrlGameBoard {
	@FXML
	private Label next_up_title;
	
	@FXML
	ListView turn_queue, action_queue, history_stack;

	@FXML
	private void initialize () throws IOException {
		
	}
}
