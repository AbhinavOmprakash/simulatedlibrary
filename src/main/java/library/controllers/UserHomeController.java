package library.controllers;

import common.models.DataManager;
import common.models.LogoutManager;
import library.models.LibraryUtils;
import library.models.Utils;
import library.views.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings({"unchecked, rawtypes"})
public class UserHomeController implements ActionListener {
    private final DataManager libraryItemManager;

    HomeScreen userHome;
    LibraryUtils libraryUtils;

    public UserHomeController(DataManager libraryItemManager,
                              HomeScreen userHome,
                              Utils utils) {
        this.libraryItemManager = libraryItemManager;
        this.userHome = userHome;
        this.libraryUtils = utils.libUtils;

        userHome.registerListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == userHome.searchButton){
            searchAndDisplayResults();
        } if (e.getSource() == userHome.logoutButton){
            LogoutManager.logout();
        }
    }

    private void searchAndDisplayResults(){
        // TODO uncomment in production
        ArrayList<Object> results = performSearch();
        userHome.displaySearchResults(results);
    }

    private ArrayList performSearch(){
        String query = userHome.getSearchField().getText();
        if(query.equals("")){
            return libraryItemManager.fetchAll();
        } else {
            return libraryItemManager.fuzzySearch(query);
        }
    }

}
