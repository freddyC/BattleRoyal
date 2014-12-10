package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public abstract class CtrlListItem extends AnchorPane {
	protected GameData data;
	public abstract void hydrate ();
	
	public CtrlListItem (GameData d, String view) {
		loadView(view);
		data = d;
	}
	
	private void loadView (String view) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
	}
	
	public GameData getGameData () {
		return data;
	}
}
