package ui.library;

import backend.controllers.DataController;
import backend.controllers.LibraryItemController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//public class searchBox<V> implements ActionListener {
//    private JTextField searchField;
//    private JPanel panel1;
//    private JButton searchButton;
//    private ArrayList<V> searchResults;
//
//    private DataController libraryItemDataController;
//
//    public searchBox(LibraryItemController controller){
//        this.libraryItemDataController = controller;
//        searchButton.addActionListener(this);
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object actionSource = e.getSource();
//
//        if (actionSource == searchButton) {
//            performSearch();
//        }
//    }
////        private void searchAndDisplayResults(){
////            ArrayList<V> results = performSearch();
////            displaySearchResults(results);
////        }
//
//        private void performSearch(){
//            String query = searchField.getText();
//            searchResults = libraryItemDataController.search(query);
//        }
//
//        private void displaySearchResults(ArrayList<V> results){
//            LibraryItemDisplay display = new LibraryItemDisplay(results);
//            searchResults.setViewportView(display.getDisplayPanel());
//        }
//}
