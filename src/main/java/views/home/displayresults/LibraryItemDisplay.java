package views.home.displayresults;

import controllers.BorrowIncharge;
import models.dataobjects.library.CurrentUser;
import models.dataobjects.library.Member;
import models.dataobjects.libraryitems.LibraryItem;
import views.DataObserver;
import views.displayPage;

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

        Member currentMember = (Member) CurrentUser.getCurrentUser();
        currentMember.registerListener(this);

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
        // observers changes to Member
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