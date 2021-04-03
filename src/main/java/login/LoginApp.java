package login;

import common.App;
import common.Dependency;
import common.models.DataManager;
import common.models.Member;
import login.controllers.LoginController;
import login.models.LoginData;
import login.models.LoginManager;
import login.models.SessionManager;
import login.views.ForgottenPassword;
import login.views.LoginPage;

public class LoginApp extends App {

    @Override
    protected void initializeObjects(Dependency dependency) {
        // data managers
        DataManager loginData = new DataManager(dependency.dataBase, new LoginData());
        DataManager users = new DataManager(dependency.dataBase, new Member());

        // models
        SessionManager sessionManager = new SessionManager(users);
        LoginManager loginManager = new LoginManager(loginData, sessionManager);

        // views
        LoginPage loginPage = new LoginPage();
        ForgottenPassword forgottenPasswordPage = new ForgottenPassword();

        //Router
        router = new LoginRouter(dependency.router, loginPage,forgottenPasswordPage);

        //register views
        addView(loginPage);
        addView(forgottenPasswordPage);

        // controllers
        LoginController loginController = new LoginController(loginManager, loginPage);
    }
}
