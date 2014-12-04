package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	StageController stage;
	
	@Override
	public void start(Stage startupStage) throws IOException {
		stage = StageController.getInstance();
		stage.setStage(startupStage);
		stage.loadIt("ViewStartupScreen.fxml");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
