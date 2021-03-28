package login;

import common.Router;
import common.Views;
import common.models.DisplayPage;
import login.views.ForgottenPassword;
import login.views.LoginPage;

import java.awt.event.ActionEvent;

@SuppressWarnings("rawtypes")
public class LoginRouter extends Router {
    LoginPage loginPage = new LoginPage(this);
    ForgottenPassword forgottenPasswordPage = new ForgottenPassword(this);

    public LoginRouter(Router router) {
        super(router);
        registerView(loginPage);
        registerView(forgottenPasswordPage);
    }

    @Override
    public void homeView() {
        setView(loginPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== loginPage.signUpButton){
            parentRouter.changeView(Views.SIGN_UP);
        } else if (e.getSource()==loginPage.forgottenPassword){
            setView(forgottenPasswordPage);
        } else if (e.getSource()==forgottenPasswordPage.buttonCancel||
                    e.getSource()==forgottenPasswordPage.buttonOK){
            setView(loginPage);
        }
    }
}
