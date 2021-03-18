package backend.controllers;

import ui.library.UiObserver;

public interface UiObserverable {
    public void registerUiObserver(UiObserver o);
    public void removeUiObserver(UiObserver o);

    public void notifyObservers();
}
