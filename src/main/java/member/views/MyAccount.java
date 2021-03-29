package member.views;

import common.Router;
import common.models.CurrentUser;
import common.models.Member;
import common.models.DataObserver;
import common.models.DisplayPage;
import member.controllers.UserAccountController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyAccount implements DisplayPage, DataObserver {

    private JPanel panel;
    public JButton homeButton;
    public JButton upgradeMembershipButton;
    private JPanel info;
    private JScrollPane scrollpane;

    BorrowedItemDisplay currentDisplay;
    private Member user;

    ActionListener controller;

    public MyAccount(Router router){
        controller = new UserAccountController(this);

        registerListener(controller);
        registerListener(router);

        user = (Member) CurrentUser.getCurrentUser();
        user.registerListener(this);

        displayBorrowedItems();
    }

    @Override
    public void registerListener(ActionListener listener) {
        homeButton.addActionListener(listener);
        upgradeMembershipButton.addActionListener(listener);
    }

    private void displayBorrowedItems() {
        if(userHasBorrowedItems()){
            populateDisplay();
        } else {
            cleanDisplay();
        }
    }

    private boolean userHasBorrowedItems() {
        List items = user.getBorrowedItems();
        return !items.isEmpty();
    }

    private void populateDisplay() {
        currentDisplay = new BorrowedItemDisplay(user.getBorrowedItems());
        scrollpane.setViewportView(currentDisplay.getPanel());
    }

    private void cleanDisplay() {
        if(currentDisplay!=null) {
            System.out.println("cleaning display for no reason");
            scrollpane.remove(currentDisplay.getPanel());
            scrollpane.revalidate();
        }
    }

    @Override
    public void performAction() {
        displayBorrowedItems();
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "MyAccount";
    }

}
