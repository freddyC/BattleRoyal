package application;

import java.util.List;

public interface Watcher {
	void fire(String watchedName);
}
