package controllers.useraccounts;

import controllers.DataManager;

public class LoginDataManager extends DataManager {
    public LoginDataManager() {
        super("LoginData", "username");
    }
}
