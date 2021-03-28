package login.controllers;

import login.models.LoginManager;
import login.models.rawLoginData;
import login.views.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    LoginManager loginManager = new LoginManager();
    LoginPage loginPage;

    public LoginController(LoginPage page) {
        loginPage = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == loginPage.loginButton) {
            performLogin();
        } else if(source == loginPage.signUpButton)  {
            parentController.switchToSignUp();
        }
    }

    private void performLogin(){
        if (tryLoggingIn()) {
            parentController.switchToHomePage();
            System.out.println("logging in");
        }
    }

    private boolean tryLoggingIn() {
        LoginData enteredData = loginPage.fetchLoginDetails();
        return loginManager.login(enteredData);
    }

}
