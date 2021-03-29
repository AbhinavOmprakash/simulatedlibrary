package login.views;

import common.Router;
import login.controllers.LoginController;
import common.models.DisplayPage;
import login.models.RawLoginData;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPage implements DisplayPage {

    private JPanel panel1;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel LoginPanel;

    public JButton loginButton;
    public JButton forgottenPassword;
    public JButton signUpButton;

    ActionListener controller;
    public LoginPage(Router router){
        controller = new LoginController(this);
        forgottenPassword.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        registerListener(router);
        registerListener(controller);
    }

    @Override
    public void registerListener(ActionListener listener) {
        forgottenPassword.addActionListener(listener);
        loginButton.addActionListener(listener);
        signUpButton.addActionListener(listener);
    }

    public RawLoginData fetchLoginDetails(){
        return new RawLoginData(usernameField.getText(), passwordField.getPassword());
    }


    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public String getIdentifier() {
        return "LoginPage";
    }

}
