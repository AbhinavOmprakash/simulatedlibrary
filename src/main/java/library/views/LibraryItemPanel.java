package library.views;

import library.models.BorrowIncharge;
import library.models.BorrowedItemsDataManager;
import common.models.CurrentUser;
import library.models.Librarian;
import common.models.Member;
import library.models.libraryitems.LibraryItem;
import common.models.DataObserver;
import library.models.libraryitems.LibItemDataFormatter;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryItemPanel implements DisplayPage, ActionListener{

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

        setBorrowButton();
    }

    private void setBorrowButton() {
        System.out.println("setBorrowButton?");
        if(librarian.isBorrowed(item)){
            disableBorrowButton();
        } else{
            enableBorrowButton();
        }
    }

    public void disableBorrowButton(){
        borrowButton.setEnabled(false);
        System.out.println("disabling");
    }

    public void enableBorrowButton(){
        borrowButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==borrowButton){
            initiateBorrow();
            refreshStatus();
        }
    }

    //todo move to a controller
    private void initiateBorrow() {
        Member currentUser = (Member) CurrentUser.getCurrentUser();
        borrowIncharge.letUserBorrow(currentUser, item);
    }

    private void refreshStatus() {
        this.checkedOut.setText(LibItemDataFormatter.constructCheckoutString(librarian.isBorrowed(item)));
        setBorrowButton();
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public String getIdentifier() {
        return "LibraryItemPanel";
    }

    @Override
    public void registerListener(ActionListener listener) {

    }

}
