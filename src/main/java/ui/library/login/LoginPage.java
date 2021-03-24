package ui.library.login;

import backend.controllers.LoginManager;
import backend.dataobjects.library.records.LoginData;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener, displayPage {

    private JPanel panel1;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel LoginPanel;


    private JButton loginButton;
    private JButton forgottenPassword;
    private JButton signUpButton;


    LoginManager loginManager = new LoginManager();

    private EntryPage parent;

    LoginPage(EntryPage parent){
        this.parent = parent;

        forgottenPassword.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        forgottenPassword.addActionListener(this);
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
    }


    @Override
    public JPanel getPanel() {
        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            performLogin();
        }else if(e.getSource()==signUpButton){
            parent.changeToSignUpForm();
        } else if(e.getSource()==forgottenPassword){
            System.out.println("forgotten shit");
            parent.changeToForgottenPassword();
        }
    }

    private void performLogin(){
        if (tryLoggingIn()) {
            parent.loginSuccessful();
        }
    }

    private boolean tryLoggingIn() {
        LoginData enteredData = fetchLoginDetails();
        return loginManager.login(enteredData);
    }

    private LoginData fetchLoginDetails(){
        return new LoginData(usernameField.getText(),passwordField.getPassword());
    }

     public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }
}
