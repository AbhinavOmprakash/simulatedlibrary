package library.views;

import common.models.Session;
import library.models.LibraryUtils;
import library.models.MemberUtils;
import library.models.Utils;
import library.models.libraryitems.LibraryItem;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class LibraryItemPanel implements DisplayPage, ActionListener{

    private JPanel panel1;
    private JButton borrowButton;
    private JTextArea contributors;
    private JTextArea title;
    private JTextArea checkedOut;
    private JTextArea libItemType;
    private JButton infoButton;

    private final LibraryUtils libraryUtils;
    private final MemberUtils memberUtils;
    private final LibraryItem item;

    LibraryItemDisplay parent;

    public LibraryItemPanel(LibraryItemDisplay parent, LibraryItem item, Utils utils){
        this.item = item;
        this.libraryUtils = utils.libUtils;
        this.memberUtils = utils.memberUtils;

        this.title.setText(LibraryUtils.getFormattedTitle(item));
        this.contributors.setText(LibraryUtils.getFormattedContributors(item));
        this.libItemType.setText(item.getType());
        this.checkedOut.setText(LibraryUtils.constructCheckoutString(libraryUtils.isBorrowed(item)));

        this.parent = parent;
        setBorrowButton();
        registerListener(this);
    }

    private void setBorrowButton() {
        //if the item is not borrowed don't allow
        //if the use can't borrow don't allow
        if(libraryUtils.isBorrowed(item) ||
            !memberUtils.canUserBorrow(Session.getCurrentUser())){
            disableBorrowButton();
        } else{
            enableBorrowButton();
        }

    }

    private void disableBorrowButton(){
        borrowButton.setEnabled(false);
        System.out.println("disabling");
    }

    private void enableBorrowButton(){
        borrowButton.setEnabled(true);
    }

    @Override
    public void registerListener(ActionListener listener) {
        borrowButton.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==borrowButton){
            initiateBorrow();
            refresh();
        }
    }

    private void initiateBorrow() {
        parent.borrow(item);
    }

    @Override
    public void refresh(){
        setBorrowButton();
        this.checkedOut.setText(LibraryUtils.constructCheckoutString(libraryUtils.isBorrowed(item)));
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public String getIdentifier() {
        return "LibraryItemPanel";
    }



}
