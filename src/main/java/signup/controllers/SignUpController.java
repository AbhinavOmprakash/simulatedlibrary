package signup.controllers;

import common.controllers.GuiController;
import common.controllers.MainFrameController;
import signup.models.SignUpData;
import common.views.MainJFrame;
import signup.models.SignUpManager;
import signup.views.SignUpPage;

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
            parentController.switchToHomePage();
            System.out.println("signing up");
        }
    }

    private boolean trySigningUp() {
        SignUpData signUpData = signUpPage.fetchSignUpData();
        signUpManager.signUp(signUpData);
        return true;
    }
}
