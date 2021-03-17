package ui.library;

import backend.libraryitems.LibraryItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryItemDisplay<V> {
    private JPanel displayPanel;
    private JPanel items;

    public LibraryItemDisplay(ArrayList<V> searchResults) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0,5)));

        for ( V result: searchResults){
            ItemPanel item = new ItemPanel((LibraryItem) result);
            displayPanel.add(item.getPanel1());
        }
    }

    public JPanel getDisplayPanel() {
        return displayPanel;
    }
}
