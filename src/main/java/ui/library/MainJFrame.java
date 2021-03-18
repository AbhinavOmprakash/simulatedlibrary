package ui.library;

import backend.controllers.UiObserverable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame implements UiObserver {
    displayPage mainPage = new MainPage(this);

    public MainJFrame(String title) {
        super(title);
        setContentPane(mainPage.getPanel());

    }

    @Override
    public void performAction(Object source) {
        setContentPane(mainPage.getPanel());
        repaint();
        revalidate();

    }
}
