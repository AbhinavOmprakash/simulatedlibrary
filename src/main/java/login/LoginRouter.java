package login;

import common.MainRouter;
import common.Router;
import common.Views;
import login.views.ForgottenPassword;
import login.views.LoginPage;

import java.awt.event.ActionEvent;

public class LoginRouter extends Router {
    LoginPage loginPage;
    ForgottenPassword forgottenPasswordPage;

    public LoginRouter(MainRouter router,
                       LoginPage loginPage,
                       ForgottenPassword forgottenPasswordPage) {
        super(router);
        this.loginPage = loginPage;
        this.forgottenPasswordPage = forgottenPasswordPage;
        loginPage.registerListener(this);
        forgottenPasswordPage.registerListener(this);
    }

    @Override
    public void homeView() {
        setView(loginPage);
        System.out.println("setting login page");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== loginPage.signUpButton){
            parentRouter.changeView(Views.SIGN_UP);

        } else if (e.getSource()==loginPage.forgottenPassword){
            setView(forgottenPasswordPage);

        } else if (e.getSource()==forgottenPasswordPage.backButton){
            setView(loginPage);
        }
    }
}
