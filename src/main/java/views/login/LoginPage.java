package views.login;

import models.dataobjects.library.records.LoginData;
import views.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPage implements displayPage {

    private JPanel panel1;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel LoginPanel;

    public JButton loginButton;
    public JButton forgottenPassword;
    public JButton signUpButton;


    ActionListener guiController;
    public LoginPage(ActionListener guiController){
        this.guiController = guiController;
        forgottenPassword.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        forgottenPassword.addActionListener(guiController);
        loginButton.addActionListener(guiController);
        signUpButton.addActionListener(guiController);
    }

    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public String getIdentifier() {
        return "loginPage";
    }

    public LoginData fetchLoginDetails(){
        return new LoginData(usernameField.getText(), passwordField.getPassword());
    }
     public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

}
