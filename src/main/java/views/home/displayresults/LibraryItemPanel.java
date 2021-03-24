package views.home.displayresults;

import controllers.library.BorrowIncharge;
import controllers.library.BorrowedItemsDataManager;
import models.dataobjects.library.CurrentUser;
import controllers.library.Librarian;
import models.dataobjects.library.Member;
import models.dataobjects.libraryitems.LibraryItem;
import views.DataObserver;
import views.LibItemDataFormatter;
import views.displayPage;

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
    private final BorrowIncharge borrowIncharge = new BorrowIncharge();
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
        borrowIncharge.letUserBorrow(currentUser, item);
    }

    @Override
    public void performAction() {
        refreshCheckedOutStatus();
    }

    private void refreshCheckedOutStatus() {
        this.checkedOut.setText(LibItemDataFormatter.constructCheckoutString(librarian.isBorrowed(item)));
    }

    public void disableBorrowButton(){
        borrowButton.setEnabled(false);
    }

    public void enableBorrowButton(){
        borrowButton.setEnabled(true);
    }
}
