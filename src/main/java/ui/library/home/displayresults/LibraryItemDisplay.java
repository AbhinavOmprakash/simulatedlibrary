package ui.library.home.displayresults;

import backend.dataobjects.libraryitems.LibraryItem;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class LibraryItemDisplay<V> implements displayPage {
    private JPanel displayPanel;
    private JPanel items;
    ArrayList<LibraryItemPanel> panels = new ArrayList<>(); // required for cleanup()

    public LibraryItemDisplay(ArrayList<V> libraryItems) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        for (V libItem : libraryItems) {
            LibraryItemPanel item = new LibraryItemPanel((LibraryItem) libItem);
            displayPanel.add(item.getPanel());
            panels.add(item);
        }
    }
    public void cleanup(){
        for (LibraryItemPanel panel: panels){
            panel.unregisterSelf();
        }
        panels = new ArrayList<LibraryItemPanel>();
    }

    @Override
    public JPanel getPanel() {
        return displayPanel;
    }
}