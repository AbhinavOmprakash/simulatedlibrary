package views.login;

import views.MainPage;

import javax.swing.*;

public class EntryPage extends JPanel {
    private JPanel panel;

    LoginPage loginPage = new LoginPage(this);
    SignUpPage signUpPage = new SignUpPage(this);
    ForgottenPassword forgottenPassword = new ForgottenPassword(this);

    MainPage parent;

    public EntryPage(MainPage parent) {
        add(loginPage.getPanel());
        this.parent = parent;
    }

    public void changeToSignUpForm() {
        removeAll();
        add(signUpPage.getPanel());
        refresh();
    }

    public void changeToLoginPage() {
        removeAll();
        add(loginPage.getPanel());
        refresh();
    }

    public void changeToForgottenPassword(){
        removeAll();
        add(forgottenPassword.getPanel());
        refresh();

    }

    private void refresh() {
        repaint();
        revalidate();
    }

    // find better name
    public void loginSuccessful() {
        parent.changeToHome();
    }

    public void signUpSuccessful() {
        parent.changeToHome();
    }

}
