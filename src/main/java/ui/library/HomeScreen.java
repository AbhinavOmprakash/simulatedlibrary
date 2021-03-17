package ui.library;

import backend.controllers.DataController;
import backend.controllers.LibraryItemController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings({"unchecked", "rawtypes"})
public class HomeScreen<V> implements ActionListener {
    private JPanel panel;
    private JTextField searchField;
    private JButton searchButton;
    private JScrollPane searchResults;
    private DataController libraryItemDataController;

    public HomeScreen(LibraryItemController controller) {
        this.libraryItemDataController = controller;
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
        LibraryItemDisplay display = new LibraryItemDisplay(results);
        searchResults.setViewportView(display.getDisplayPanel());
    }

    // getters and setters

    public JPanel getPanel() {
        return panel;
    }
}
