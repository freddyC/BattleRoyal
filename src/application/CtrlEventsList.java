	package application;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.scene.control.ListView;

public class CtrlEventsList implements Watcher {


	private List <ActionEvent> events;
	private List <CtrlEventListItem> eventsList;
	private ObservableList<CtrlEventListItem> obsEventsList;
	private ListView<CtrlEventListItem> eventsListView;
	
	public CtrlEventsList(ListView<CtrlEventListItem> events_queue) {
		eventsListView = events_queue;
		events = new ArrayList<ActionEvent> ();
		resetLists();
		renderList();			
	}
	
	public void addPlayerTurns (ActionEvent event) {
		events.add(event);
	}
	
	private void renderList () {
		
//		List<Player> players = Players.getInstance().getPlayers();
//		events = new ArrayList<ActionEvent> ();
//		
//		for (ActionEvent turn : events) {
//			CtrlEventListItem turnLI = new CtrlEventListItem(turn);
//			eventsList.add(turnLI);
//		}		
	}
	
	private void resetLists() {
//		eventsList = new ArrayList <CtrlEventListItem> ();
//		obsEventsList = FXCollections.observableList(eventsList);
//		eventsListView.setItems(obsEventsList);
	}

	@Override
	public void fire(String watchedName) {
		resetLists();
		renderList();
	}
}