package library.views;

import library.models.BorrowIncharge;
import common.models.CurrentUser;
import common.models.Member;
import library.models.libraryitems.LibraryItem;
import common.models.DataObserver;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryItemDisplay<V> implements DisplayPage, DataObserver {
    private JPanel displayPanel;
    private JPanel items;
    ArrayList<LibraryItemPanel> panels = new ArrayList<>(); // required for disabling and enabling buttons

    public LibraryItemDisplay(ArrayList<V> libraryItems) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        Member currentMember = (Member) CurrentUser.getCurrentUser();
        currentMember.registerListener(this);

        for (V libItem : libraryItems) {
            LibraryItemPanel item = new LibraryItemPanel((LibraryItem) libItem);
            displayPanel.add(item.getPanel());
            panels.add(item);
        }
    }

    @Override
    public void performAction() {
        // observes changes to Member
        updateBorrowButtons();
    }

    private void updateBorrowButtons() {
        if(BorrowIncharge.userCanBorrow((Member) CurrentUser.getCurrentUser())){
            enableBorrow();
        } else {
            disableBorrow();
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


    @Override
    public JPanel getPanel() {
        return displayPanel;
    }

    @Override
    public String getIdentifier() {
        return "LibraryItemDisplay";
    }

    @Override
    public void registerListener(ActionListener listener) {}

}