package ui.library.login;

import backend.controllers.UiObserverable;
import ui.library.MainPage;
import ui.library.UiObserver;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener, displayPage {

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel LoginPanel;
    private JButton loginButton;
    private JButton forgottenPassword;

    private ActionListener loginController;

    public LoginPage( ActionListener loginController){
        forgottenPassword.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        forgottenPassword.setContentAreaFilled(false);

        this.loginController = loginController;
        loginButton.addActionListener(loginController);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    @Override
    public JPanel getPanel() {
        return getPanel1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){
            loginController.actionPerformed(e);
        }

    }
}
