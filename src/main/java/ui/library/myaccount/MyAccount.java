package ui.library.myaccount;

import backend.dataobjects.library.CurrentUser;
import backend.dataobjects.library.Member;
import ui.library.MainPage;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyAccount implements displayPage, ActionListener {

    private JPanel panel1;
    private JPanel info;
    private JScrollPane borrowedItemspane;
    private JButton homeButton;

    private MainPage parent;

    private Member user;
    public MyAccount(MainPage parent){
        this.parent = parent;
        this.user = (Member) CurrentUser.getCurrentUser();
        diplayBorrowedItems();
        this.homeButton.addActionListener(this);
    }

    private void diplayBorrowedItems() {
        if(UserHasBorrowedItems()){
            populateDisplay();
        }
    }

    private void populateDisplay() {
        BorrowedItemDisplay borrowedItems = new BorrowedItemDisplay(user.getBorrowedItems());
        borrowedItemspane.setViewportView(borrowedItems.getPanel());
    }

    private boolean UserHasBorrowedItems() {
        return !(this.user.getBorrowedItems().isEmpty());
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==homeButton){
            parent.changeToHome();
        }
    }
}
