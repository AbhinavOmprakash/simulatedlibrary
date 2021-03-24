package backend.controllers;

import ui.library.DataObserver;

public interface DataObservable {
    void registerListener(DataObserver listener);
    void removeListener(DataObserver listener);
    void notifyObservers();
}
