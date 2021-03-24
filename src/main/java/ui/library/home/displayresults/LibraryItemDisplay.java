package ui.library.home.displayresults;

import backend.controllers.BorrowIncharge;
import backend.controllers.BorrowedItemsDataManager;
import backend.dataobjects.library.CurrentUser;
import backend.dataobjects.library.Member;
import backend.dataobjects.libraryitems.LibraryItem;
import ui.library.DataObserver;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibraryItemDisplay<V> implements displayPage, DataObserver {
    private JPanel displayPanel;
    private JPanel items;
    ArrayList<LibraryItemPanel> panels = new ArrayList<>(); // required for cleanup()

    public LibraryItemDisplay(ArrayList<V> libraryItems) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        BorrowedItemsDataManager.getInstanceOf().registerListener(this);
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
        panels = new ArrayList<>();
    }

    @Override
    public JPanel getPanel() {
        return displayPanel;
    }

    @Override
    public void performAction() {
        updateBorrowButtons();
    }

    private void updateBorrowButtons() {
        if(BorrowIncharge.userCanBorrow((Member) CurrentUser.getCurrentUser())){
            enableBorrow();
            System.out.println("enabling");
        } else {
            disableBorrow();
            System.out.println("disabling");
        }
    }

    private void enableBorrow() {
        for(LibraryItemPanel panel: panels){

            panel.enableBorrowButton();
        }
    }

    private void disableBorrow() {
        for(LibraryItemPanel panel: panels){
            panel.disableBorrowButton();
        }
    }


}