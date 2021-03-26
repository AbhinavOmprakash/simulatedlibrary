package library.views;

import common.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class HomeScreen implements displayPage {
    private JPanel panel;
    private JTextField searchField;
    private JScrollPane searchResults;
    private JPanel searchBox;

    public JButton logoutButton;
    public JButton searchButton;
    public JButton myAccountButton;

    LibraryItemDisplay currentDisplay;

    public HomeScreen(ActionListener guiController) {
        searchButton.addActionListener(guiController);
        logoutButton.addActionListener(guiController);
        myAccountButton.addActionListener(guiController);
    }

    public void displaySearchResults(ArrayList results){

        for (Object result: results){
            System.out.println(result.toString());
        }
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
