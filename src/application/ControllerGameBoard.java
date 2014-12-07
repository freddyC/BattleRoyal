package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ControllerGameBoard {
	@FXML
	private Label next_up_title;
	
	@FXML
	private VBox events_queue, action_picker, turn_queue, history;

	@FXML
	private void initialize () throws IOException {
		
	}

}
