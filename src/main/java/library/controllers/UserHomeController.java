package library.controllers;

import common.models.DataManager;
import common.models.LogoutManager;
import library.models.LibraryItemManager;
import library.views.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings({"unchecked, rawtypes"})
public class UserHomeController implements ActionListener {
    private final DataManager libraryItemManager = new LibraryItemManager();

    HomeScreen userHome;
    public UserHomeController(HomeScreen page) {
        userHome = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userHome.searchButton){
            searchAndDisplayResults();
        } if (e.getSource() == userHome.logoutButton){
            LogoutManager.logout();
        }
    }

    private void searchAndDisplayResults(){
        // TODO uncomment in production
//        ArrayList<V> results = performSearch();
        ArrayList results = libraryItemManager.fetchAll();
        userHome.displaySearchResults(results);
    }

    private ArrayList performSearch(){
        String query = userHome.getSearchField().getText();
        return libraryItemManager.search(query);
    }

}
