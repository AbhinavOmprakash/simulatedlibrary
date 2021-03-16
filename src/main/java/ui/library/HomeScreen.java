package ui.library;

import backend.controllers.DataController;
import backend.controllers.LibraryItemController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class HomeScreen implements ActionListener {
    private JPanel panel;
    private JTextField textField1;
    private JButton searchButton;
    private DataController libraryItemDataController;


    public HomeScreen(LibraryItemController controller) {
        this.libraryItemDataController = controller;
        searchButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource = e.getSource();

        if (actionSource == searchButton){
            String query = textField1.getText();
            System.out.println(query);
            libraryItemDataController.search(query);

        }

    }

    public JPanel getPanel() {
        return panel;
    }
}
