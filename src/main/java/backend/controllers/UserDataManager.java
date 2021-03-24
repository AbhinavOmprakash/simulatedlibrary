package backend.controllers;

import backend.externalservices.DataStoreInterface;

@SuppressWarnings({"unchecked"})
public class UserDataManager extends DataManager {
    private static UserDataManager instance;

    private UserDataManager() {
        super("User", "userName");
    }

    public static UserDataManager getInstanceOf(){
        if(instance==null){
            instance = new UserDataManager();
        }
        return instance;
    }

}
