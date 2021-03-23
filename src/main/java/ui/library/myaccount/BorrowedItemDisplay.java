package ui.library.myaccount;

import backend.libraryitems.LibraryItem;
import ui.library.displayPage;
import ui.library.home.displayresults.LibraryItemPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BorrowedItemDisplay<V> implements displayPage {
    private JPanel displayPanel;
    private JPanel items;
    public BorrowedItemDisplay(List<V> libraryItems) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0,5)));

        for ( V libItem: libraryItems){
            BorrowedItemPanel item = new BorrowedItemPanel((LibraryItem) libItem);
            displayPanel.add(item.getPanel());
        }
    }

    @Override
    public JPanel getPanel() {
        return displayPanel;
    }
}
