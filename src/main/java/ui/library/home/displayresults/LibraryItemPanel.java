package ui.library.home.displayresults;

import backend.controllers.BorrowedItemsDataManager;
import backend.dataobjects.library.CurrentUser;
import backend.controllers.Librarian;
import backend.dataobjects.library.Member;
import backend.dataobjects.libraryitems.LibraryItem;
import ui.library.DataObserver;
import ui.library.LibItemDataFormatter;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryItemPanel implements displayPage, ActionListener, DataObserver {

    private JPanel panel1;
    private JButton borrowButton;
    private JTextArea contributors;
    private JTextArea title;
    private JTextArea checkedOut;
    private JTextArea libItemType;
    private JButton infoButton;

    private final Librarian librarian = new Librarian();
    private final LibraryItem item;

    public LibraryItemPanel(LibraryItem item){
        this.item = item;
        this.title.setText(LibItemDataFormatter.getFormattedTitle(item));
        this.contributors.setText(LibItemDataFormatter.getFormattedContributors(item));
        this.libItemType.setText(item.getType());
        this.checkedOut.setText(LibItemDataFormatter.constructCheckoutString(librarian.isBorrowed(item)));
        this.borrowButton.addActionListener(this);
        BorrowedItemsDataManager.getInstanceOf().registerListener(this);
    }

    public void unregisterSelf(){
        BorrowedItemsDataManager.getInstanceOf().removeListener(this);
    }
    @Override
    public JPanel getPanel() {
        return panel1;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==borrowButton){
            System.out.println("borrowed");
            initiateBorrow();
        }
    }

    private void initiateBorrow() {
        Member currentUser = (Member) CurrentUser.getCurrentUser();
        librarian.letUserBorrow(currentUser, item);
    }
    @Override

    public void performAction() {
        refreshCheckedOutStatus();
    }

    private void refreshCheckedOutStatus() {
        this.checkedOut.setText(LibItemDataFormatter.constructCheckoutString(librarian.isBorrowed(item)));
    }
}
