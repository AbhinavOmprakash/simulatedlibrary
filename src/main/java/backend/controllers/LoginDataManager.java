package backend.controllers;

import backend.externalservices.DataStoreInterface;

public class LoginDataManager extends DataManager {
    public LoginDataManager() {
        super("LoginData", "username");
    }
}
