package views.home.search;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SearchBox {

    private JButton searchButton;
    private JPanel panel;
    private JTextField searchField;

    public SearchBox(Object parent) {
        searchButton.addActionListener((ActionListener) parent);
    }


    public JPanel getPanel() {
        return panel;
    }


    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
