package member.views;

import library.models.libraryitems.LibraryItem;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BorrowedItemDisplay<V> implements DisplayPage {
    private JPanel displayPanel;
    private ArrayList<BorrowedItemPanel> panels = new ArrayList<>(); // for cleanup()

    public BorrowedItemDisplay(List<V> borrowedItems) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0,5)));

        for ( V libItem: borrowedItems){
            BorrowedItemPanel item = new BorrowedItemPanel((LibraryItem) libItem);
            displayPanel.add(item.getPanel());
            panels.add(item);
        }
    }


    @Override
    public void registerListener(ActionListener listener) {
        // no action listeners
    }

    @Override
    public JPanel getPanel() {
        return displayPanel;
    }

    @Override
    public String getIdentifier() {
        return "BorrowedItemDisplay";
    }
}
