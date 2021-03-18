package backend.controllers;

import ui.library.UiObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController implements UiObserverable, ActionListener {
    private ArrayList<UiObserver> observers = new ArrayList<>();

    @Override
    public void registerUiObserver(UiObserver o) {
        observers.add(o);
    }

    @Override
    public void removeUiObserver(UiObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (UiObserver o : observers){
            o.performAction(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();

    }
}
