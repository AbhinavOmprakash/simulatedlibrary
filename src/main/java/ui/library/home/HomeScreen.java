package ui.library.home;

import backend.controllers.DataController;
import backend.controllers.LibraryItemController;
import backend.libraryitems.LibraryItem;
import com.sun.istack.NotNull;
import ui.library.displayPage;
import ui.library.home.displayresults.LibraryItemDisplay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({"rawtypes","unchecked"})
public class HomeScreen<V> implements ActionListener, displayPage {
    private JPanel panel;
    private JButton searchButton;
    private JTextField searchField;
    private JScrollPane searchResults;
    private JPanel searchBox;
    private JButton myAccountButton;
    private JButton logoutButton1;
    private LibraryItemController libraryItemDataController;

    public HomeScreen(LibraryItemController controller) {
        libraryItemDataController = controller;
        searchButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource = e.getSource();

        if (actionSource == searchButton) {
            searchAndDisplayResults();
        }
    }

    private void searchAndDisplayResults(){
        ArrayList<V> results = performSearch();
        displaySearchResults(results);
    }

    private ArrayList<V> performSearch(){
        String query = searchField.getText();
        return libraryItemDataController.search(query);
    }

    private void displaySearchResults(ArrayList<V> results){

        for (Object result: results ){
            System.out.println(result.toString());

        }


        LibraryItemDisplay display = new LibraryItemDisplay(results);
        searchResults.setViewportView(display.getPanel());
    }


    @Override
    public JPanel getPanel() {
        return panel;
    }
}
