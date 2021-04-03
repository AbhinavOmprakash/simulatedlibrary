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

    MyAccount parent;

    public BorrowedItemDisplay(MyAccount parent, List<Object> borrowedItems) {
        this.parent = parent;

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0,5)));

        displayBorrowedItems(borrowedItems);
    }

    private void displayBorrowedItems(List<Object> borrowedItems){
        for ( Object libItem: borrowedItems){
            BorrowedItemPanel item = new BorrowedItemPanel(this, (LibraryItem) libItem);
            displayPanel.add(item.getPanel());
            panels.add(item);
        }
    }

    public void returnItem(LibraryItem item){
        parent.returnItem(item);
    }

    @Override
    public void registerListener(ActionListener listener) {
        // no action listeners
    }

    @Override
    public void refresh() {

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
