package ui.library.myaccount;

import backend.controllers.BorrowedItemsDataManager;
import backend.controllers.UserDataManager;
import backend.dataobjects.library.CurrentUser;
import backend.dataobjects.library.Member;
import ui.library.DataObserver;
import ui.library.MainPage;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyAccount implements displayPage, ActionListener, DataObserver {

    private JPanel panel1;
    private JPanel info;
    private JScrollPane borrowedItemspane;
    private JButton homeButton;

    private MainPage parent;

    BorrowedItemDisplay currentDisplay;

    private Member user;
    public MyAccount(MainPage parent){
        this.parent = parent;
        this.user = (Member) CurrentUser.getCurrentUser();
        this.homeButton.addActionListener(this);
        BorrowedItemsDataManager.getInstanceOf().registerListener(this);
        displayBorrowedItems();
    }

    private void displayBorrowedItems() {
        if(userHasBorrowedItems()){
            populateDisplay();
        }
    }
    private boolean userHasBorrowedItems() {
        List items = user.getBorrowedItems();
        return !items.isEmpty();
    }

    private void populateDisplay() {
        System.out.println("displaying items");
        currentDisplay = new BorrowedItemDisplay(user.getBorrowedItems());
        borrowedItemspane.setViewportView(currentDisplay.getPanel());
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

    @Override
    public void performAction() {
        displayBorrowedItems();
    }
}
