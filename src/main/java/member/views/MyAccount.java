package member.views;

import library.models.BorrowedItemsDataManager;
import common.CurrentUser;
import member.models.Member;
import common.DataObserver;
import common.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyAccount implements displayPage, ActionListener, DataObserver {

    private JPanel panel1;
    private JPanel info;
    private JScrollPane borrowedItemspane;
    public JButton homeButton;
    public JButton upgradeMembershipButton;

    BorrowedItemDisplay currentDisplay;
    private Member user;

    public MyAccount(ActionListener guiController){
        this.user = (Member) CurrentUser.getCurrentUser();

        homeButton.addActionListener(guiController);
        upgradeMembershipButton.addActionListener(guiController);

        BorrowedItemsDataManager.getInstanceOf().registerListener(this);
        displayBorrowedItems();
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
        System.out.println("displaying items");
        currentDisplay = new BorrowedItemDisplay(user.getBorrowedItems());
        borrowedItemspane.setViewportView(currentDisplay.getPanel());
    }

    private void cleanDisplay() {
        System.out.println("cleaning items");
        borrowedItemspane.removeAll();
        borrowedItemspane.repaint();
        borrowedItemspane.revalidate();
    }


    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public String getIdentifier() {
        return "MyAccount";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void performAction() {
        displayBorrowedItems();
    }
}
