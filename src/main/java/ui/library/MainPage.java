package ui.library;

import backend.controllers.*;
import backend.externalservices.DataStoreInterface;
import backend.externalservices.HibernateDB;
import ui.library.login.LoginPage;
import ui.library.login.SignUpPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener, displayPage, UiObserver{

    private JPanel mainPanel;
    DataStoreInterface dataBase = new HibernateDB(true);
    DataController libraryItemData = new LibraryItemController(dataBase);
    DataController userData = new UserDataController(dataBase);
    DataController contributorData = new ContributorController(dataBase);

    UiObserverable loginController = new LoginController();

    displayPage homeScreen = new HomeScreen((LibraryItemController) libraryItemData);
    displayPage loginPage = new LoginPage((ActionListener) loginController);
    displayPage signUpPage = new SignUpPage();

    MainJFrame parentFrame;
    public MainPage(MainJFrame parentFrame){
        this.parentFrame = parentFrame;
        mainPanel = loginPage.getPanel();
        this.loginController.registerUiObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public JPanel getPanel() {
        return getMainPanel();
    }

    @Override
    public void performAction(Object source) {
        if (source== loginController){
            System.out.println("logging in yo!");
            mainPanel = homeScreen.getPanel();
            parentFrame.performAction( source);
        }

    }
}
