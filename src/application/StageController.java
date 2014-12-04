package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageController {
	
	private static StageController instance = null;
	private static Parent current;
	private static Stage rootStage;
	
	protected StageController() throws IOException {
		// only here to keep this a singleton
   }

   public static StageController getInstance() throws IOException {
      if(instance == null) {
         instance = new StageController();
      }
      return instance;
   }
   
   public void setStage (Stage stage) {
	   rootStage = stage;
   }
   
   public void loadIt (String file) {
	   try {
			current = FXMLLoader.load(getClass().getResource(file));
			rootStage.setScene(new Scene(current, 1200, 800));
			rootStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	   
	public void changeView (String file) {
		loadIt(file);
	}
}
