package controllers.ui;

import controllers.useraccounts.SignUpManager;
import models.dataobjects.library.records.SignUpData;
import views.MainJFrame;
import views.login.SignUpPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController extends GuiController implements ActionListener {
    SignUpPage signUpPage = new SignUpPage(this);

    SignUpManager signUpManager = new SignUpManager();

    public SignUpController(MainFrameController mainFrameController, MainJFrame mainFrame) {
        super(mainFrameController, mainFrame);
        setCurrentPage(signUpPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpPage.signUpButton) {
            performSignUp();
        } else if (e.getSource() == signUpPage.haveAnAccountButton){
            parentController.switchToLogin();
        }
    }

    private void performSignUp() {
        if(true){
//            parent.signUpSuccessful();
            System.out.println("signing up");
        }
    }

    private boolean trySigningUp() {
        SignUpData signUpData = signUpPage.fetchSignUpData();
        return true;
    }
}
