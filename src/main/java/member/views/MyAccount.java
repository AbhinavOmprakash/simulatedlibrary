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
