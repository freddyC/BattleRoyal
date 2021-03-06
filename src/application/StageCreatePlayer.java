package application;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import application.EnumElement;

public class StageCreatePlayer {
	
	private final int MAX_POINTS = 250;
	private List <EnumElement> els = new ArrayList <EnumElement> ();
	private ObservableList<EnumElement> elements = FXCollections.observableList(els);
	private CtrlStage stage;
	private int points;
	
	@FXML
	private Label warning_label;
	
	@FXML
	private Slider hp_slider, mana_slider, stamina_slider, intelect_slider, speed_slider;
	
	@FXML
	private ProgressBar attribute_indicator_progress;
	
	@FXML
	private ChoiceBox<EnumElement> elemental_selecter;
		
	@FXML
	TextField name_field;
	
	@FXML
	private void initialize () throws IOException {
		stage = CtrlStage.getInstance();
		setupSlider(hp_slider);
		setupSlider(mana_slider);
		setupSlider(stamina_slider);
		setupSlider(intelect_slider);
		setupSlider(speed_slider);
		updatePoints();
		
		els.add(EnumElement.Fire);
		els.add(EnumElement.Water);
		els.add(EnumElement.Earth);
		els.add(EnumElement.Wind);

		elemental_selecter.setItems(elements);
		elemental_selecter.setValue(EnumElement.Fire);
	}
	
	private void updatePoints() {
		points =  (int) hp_slider.getValue()
				+ (int) mana_slider.getValue()
				+ (int) stamina_slider.getValue()
				+ (int) + intelect_slider.getValue()
				+ (int) + speed_slider.getValue();
		attribute_indicator_progress.setProgress((double)points / (double)MAX_POINTS);
	}

	private void setupSlider (Slider slider) {
		slider.setMin(0);
		slider.setMax(100);
		slider.setValue(25);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(25);
		slider.setBlockIncrement(10);
		slider.valueProperty().addListener((observable, oldValue, newValue) -> {
			updatePoints();
			if (points > MAX_POINTS) {
				slider.setValue((double) oldValue);
			}
		});
	}
	
	@FXML
	private void savePlayer() throws IOException, InterruptedException {
		if (!allFilledOut()) {
			warning_label.setVisible(true);
		} else {
			createUser();
			stage.changeView("ViewStartupScreen.fxml");	
		}
	}
	
	private void createUser() throws InterruptedException {
		Player player = new Player();
		player.setElement( (EnumElement) elemental_selecter.getValue());
		player.updateAllVitals((int) hp_slider.getValue()
							 , (int) mana_slider.getValue()
							 , (int) stamina_slider.getValue()
							 , (int) intelect_slider.getValue()
							 , (int) speed_slider.getValue() 
							 );
		player.setName(name_field.getText());
		Players ms = Players.getInstance();
		ms.addPlayer(player);
	}

	private boolean allFilledOut () {
		if (points < 195) return false;
		if (name_field.getText().equals("")) return false;
		return true;
	}
}
