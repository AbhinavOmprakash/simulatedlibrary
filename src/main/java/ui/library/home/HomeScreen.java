package ui.library.home;

import backend.controllers.DataManager;
import backend.controllers.LibraryItemManager;
import ui.library.MainPage;
import ui.library.displayPage;
import ui.library.home.displayresults.LibraryItemDisplay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class HomeScreen<V> implements ActionListener, displayPage {
    private JPanel panel;
    private JButton searchButton;
    private JTextField searchField;
    private JScrollPane searchResults;
    private JPanel searchBox;
    private JButton myAccountButton;
    private JButton logoutButton;
    private DataManager libraryItemManager = new LibraryItemManager();

    LibraryItemDisplay currentDisplay;
    MainPage parent;

    public HomeScreen(MainPage parent) {
        this.parent = parent;
        searchButton.addActionListener(this);
        logoutButton.addActionListener(this);
        myAccountButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource = e.getSource();

        if (actionSource == searchButton) {
            searchAndDisplayResults();
        }
        else if (actionSource == logoutButton) {
            parent.changeToLogin();
        } else if (actionSource == myAccountButton){
            parent.changeToMyAccount();
        }
    }

    private void searchAndDisplayResults(){
        // TO DO uncomment in production
//        ArrayList<V> results = performSearch();
        ArrayList<V> results = libraryItemManager.fetchAll();
        displaySearchResults(results);
    }

    private ArrayList<V> performSearch(){
        String query = searchField.getText();
        return libraryItemManager.search(query);
    }

    private void displaySearchResults(ArrayList<V> results){

        for (Object result: results){
            System.out.println(result.toString());
        }
        cleanUpCurrentDisplay();
        currentDisplay = new LibraryItemDisplay(results);
        searchResults.setViewportView(currentDisplay.getPanel());
    }

    private void cleanUpCurrentDisplay(){
        if(currentDisplay != null){
            currentDisplay.cleanup();
        }
    }

    @Override
    public JPanel getPanel() {
        // hack to refresh the screen
        return panel;
    }
}
