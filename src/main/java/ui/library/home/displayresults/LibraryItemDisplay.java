package ui.library.home.displayresults;

import backend.libraryitems.LibraryItem;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryItemDisplay<V> implements displayPage {
    private JPanel displayPanel;
    private JPanel items;

        public LibraryItemDisplay(ArrayList<V> libraryItems) {
            displayPanel = new JPanel();
            displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
            displayPanel.add(Box.createRigidArea(new Dimension(0,5)));

            for ( V libItem: libraryItems){
                LibraryItemPanel item = new LibraryItemPanel((LibraryItem) libItem);
                displayPanel.add(item.getPanel1());
            }
        }



    @Override
    public JPanel getPanel() {
        return displayPanel;
    }
}