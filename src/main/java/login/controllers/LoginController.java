package login.controllers;

import login.models.LoginManager;
import login.models.RawLoginData;
import login.views.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    LoginManager manager;
    LoginPage loginPage;

    public LoginController(LoginManager manager, LoginPage loginPage) {
        this.manager = manager;
        this.loginPage = loginPage;
        loginPage.registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == loginPage.loginButton) {
            performLogin();
        }
    }

    private void performLogin(){
        RawLoginData enteredData = loginPage.fetchLoginDetails();
        System.out.println(" \n performing login \n");
        System.out.println(" \n username \n"+enteredData.getUsername());
        System.out.println(" \n pass \n"+enteredData.getPasswd());
        manager.login(enteredData);
    }

}
