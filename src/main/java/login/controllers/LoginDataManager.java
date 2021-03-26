package login.controllers;

import common.DataManager;

public class LoginDataManager extends DataManager {
    public LoginDataManager() {
        super("LoginData", "username");
    }
}
