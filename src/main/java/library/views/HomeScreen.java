package library.views;

import common.Router;
import common.models.DisplayPage;
import library.controllers.UserHomeController;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class HomeScreen implements DisplayPage {
    private JPanel panel;
    private JTextField searchField;
    private JScrollPane searchResults;
    private JPanel searchBox;

    public JButton logoutButton;
    public JButton searchButton;
    public JButton myAccountButton;

    LibraryItemDisplay currentDisplay;

    ActionListener controller;

    public HomeScreen(Router router) {
        controller = new UserHomeController(this);
        registerListener(router);
        registerListener(controller);
    }

    @Override
    public void registerListener(ActionListener listener) {
        searchButton.addActionListener(listener);
        logoutButton.addActionListener(listener);
        myAccountButton.addActionListener(listener);
    }

    public void displaySearchResults(ArrayList results){
        currentDisplay = new LibraryItemDisplay(results);
        searchResults.setViewportView(currentDisplay.getPanel());
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
