package login.controllers;

import common.models.DataManager;

public class LoginDataManager extends DataManager {
    public LoginDataManager() {
        super("LoginData", "username");
    }
}
