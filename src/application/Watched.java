package application;

import java.util.ArrayList;
import java.util.List;

public class Watched {
	private List<Watcher> watchers;
	private String name;
	
	Watched (String n) {
		watchers = new ArrayList<Watcher> ();
		name = n;
	}

	void subscribe (Watcher w) {
		watchers.add(w);
	}
	
	void unsubscribe (Watcher w) {
		watchers.remove(w);
	}
	
	void fire () {
		System.out.println("[FIRE] " + name);
		for (Watcher w : watchers) {
			w.fire(name);
		}
	}
}
