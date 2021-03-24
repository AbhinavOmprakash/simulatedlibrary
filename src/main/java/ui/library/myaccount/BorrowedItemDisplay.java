package ui.library.myaccount;

import backend.dataobjects.libraryitems.LibraryItem;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.*;
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
