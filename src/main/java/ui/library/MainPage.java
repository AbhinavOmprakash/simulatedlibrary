package ui.library;

import backend.controllers.*;
import backend.externalservices.DataStoreInterface;
import backend.externalservices.HibernateDB;
import ui.library.home.HomeScreen;
import ui.library.login.EntryPage;
import ui.library.myaccount.MyAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressWarnings({"rawtypes"})
public class MainPage extends JPanel{

    private JPanel mainPanel;
    DataManager contributorData = new ContributorManager();

    JPanel entryPage;

    displayPage homeScreen;

    JPanel currentPage;

    MainJFrame parentFrame;
    public MainPage(MainJFrame parentFrame){
        super(new GridLayout(1,1));
        this.entryPage = new EntryPage(this);
        this.homeScreen = new HomeScreen(this);
        this.parentFrame = parentFrame;
        add(entryPage);
    }

    private void refresh(){
        repaint();
        revalidate();
    }

    public void changeToHome(){
        removeAll();
        add(homeScreen.getPanel());
        refresh();
    }

    public void changeToLogin(){
        removeAll();
        add(entryPage);
        refresh();
    }

    public void changeToMyAccount() {
        removeAll();
        add(new MyAccount(this).getPanel());
        refresh();
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }

}
