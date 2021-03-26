package library.controllers;

import common.models.DataManager;
import common.controllers.GuiController;
import common.controllers.MainFrameController;
import common.views.MainJFrame;
import library.models.LibraryItemManager;
import library.views.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@SuppressWarnings({"unchecked, rawtypes"})
public class UserHomeController extends GuiController implements ActionListener {
    HomeScreen userHome = new HomeScreen(this);
    private DataManager libraryItemManager = new LibraryItemManager();

    public UserHomeController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(userHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == userHome.searchButton){
            searchAndDisplayResults();

        } else if (source == userHome.myAccountButton){
            parentController.switchToMyAccount();

        } else if(source == userHome.logoutButton){
            parentController.switchToLogin();
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
