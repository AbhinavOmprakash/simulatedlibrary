package controllers.ui;

import controllers.useraccounts.LoginManager;
import models.dataobjects.library.records.LoginData;
import views.MainJFrame;
import views.login.LoginPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController extends GuiController implements ActionListener {
    LoginManager loginManager = new LoginManager();
    LoginPage loginPage = new LoginPage(this);

    public LoginController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(loginPage);
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
