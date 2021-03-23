package backend.controllers;

import backend.externalservices.DataStoreInterface;

@SuppressWarnings({"unchecked"})
public class UserDataManager extends DataManager {
    public UserDataManager() {
        super("User", "userName");
    }

}
