package member.views;

import common.customevents.CustomEvent;
import common.customevents.CustomEventListener;
import common.models.*;
import library.models.ReturnLibrarian;
import library.models.libraryitems.LibraryItem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyAccount implements DisplayPage{

    private JPanel panel;
    public JButton homeButton;
    public JButton upgradeMembershipButton;
    private JPanel info;
    private JScrollPane scrollpane;

    BorrowedItemDisplay currentDisplay;
    ReturnLibrarian librarian;
    DataManager users;
    public MyAccount(ReturnLibrarian librarian, DataManager users){
        this.librarian = librarian;
        this.users = users;
    }

    @Override
    public void registerListener(ActionListener listener) {
        homeButton.addActionListener(listener);
        upgradeMembershipButton.addActionListener(listener);
    }

    //todo delete, no one is calling this.
//    @Override
//    public void receive(CustomEvent event) {
//        if(event.equals(CustomEvent.BORROWED)){
//            refresh();
//        }
//    }

    @Override
    public void refresh() {
        cleanDisplay();
        displayBorrowedItems();
    }

    public void displayBorrowedItems() {
        Member member = (Member) users.search(Session.getCurrentUser());
        if (member.hasBorrowedItems()){
            populateDisplay(member.getBorrowedItems());
        }
    }

    private void populateDisplay(List<LibraryItem> borrowedItems) {
        currentDisplay = new BorrowedItemDisplay(this, borrowedItems);
        scrollpane.setViewportView(currentDisplay.getPanel());
    }

    private void cleanDisplay() {
        if(currentDisplay!=null) {
            scrollpane.removeAll();
            scrollpane.revalidate();
            scrollpane.repaint();
        }
    }

    public void returnItem(LibraryItem item){
        Member member = (Member) users.search(Session.getCurrentUser());
        librarian.returnItem(member, item);
        refresh();
        System.out.println("trying to return");
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
