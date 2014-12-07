package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	CtrlStage stage;
	
	@Override
	public void start(Stage startupStage) throws IOException {
		stage = CtrlStage.getInstance();
		stage.setStage(startupStage);
		stage.loadIt("ViewStartupScreen.fxml");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
