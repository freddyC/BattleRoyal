package application;

import java.util.ArrayList;
import java.util.List;

public class UtilWatched {
	private List<UtilWatcher> watchers;
	private String name;
	
	UtilWatched (String n) {
		watchers = new ArrayList<UtilWatcher> ();
		name = n;
	}

	void subscribe (UtilWatcher w) {
		watchers.add(w);
	}
	
	void unsubscribe (UtilWatcher w) {
		watchers.remove(w);
	}
	
	void fire () {
		System.out.println("[FIRE] " + name);
		for (UtilWatcher w : watchers) {
			w.fire(name);
		}
	}
}
