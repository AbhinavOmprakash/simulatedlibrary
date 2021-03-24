package backend.controllers;

import views.DataObserver;

public interface DataObservable {
    void registerListener(DataObserver listener);
    void removeListener(DataObserver listener);
    void notifyObservers();
}
