package library.views;

import common.customevents.CustomEvent;
import common.customevents.CustomEventListener;
import common.customevents.EventCotroller;
import common.models.DisplayPage;
import common.models.Session;
import library.models.BorrowLibrarian;
import library.models.Utils;
import library.models.libraryitems.LibraryItem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class HomeScreen implements DisplayPage, CustomEventListener {
    private JPanel panel;
    private JTextField searchField;
    private JScrollPane searchResults;
    private JPanel searchBox;

    public JButton logoutButton;
    public JButton searchButton;
    public JButton myAccountButton;

    LibraryItemDisplay currentDisplay;
    Utils utils;
    BorrowLibrarian librarian;

    public HomeScreen(Utils utils, BorrowLibrarian librarian) {
        this.utils = utils;
        this.librarian = librarian;
        EventCotroller.getInstanceOf().registerListener(this);
    }

    @Override
    public void registerListener(ActionListener listener) {
        searchButton.addActionListener(listener);
        logoutButton.addActionListener(listener);
        myAccountButton.addActionListener(listener);
    }

    public void displaySearchResults(ArrayList results){
        currentDisplay = new LibraryItemDisplay(this, results, utils);
        searchResults.setViewportView(currentDisplay.getPanel());
    }

    public void borrow(LibraryItem item){
        String username = Session.getCurrentUser();
        librarian.borrowItem(username, item);
    }

    @Override
    public void receive(CustomEvent event) {
        if(event.equals(CustomEvent.BORROWED)){
            refresh();
            System.out.println("refreshing children");
        }
    }

    @Override
    public void refresh() {
        if(currentDisplay != null){
            currentDisplay.refresh();
        }
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "HomeScreen";
    }

    public JTextField getSearchField() {
        return searchField;
    }


}
