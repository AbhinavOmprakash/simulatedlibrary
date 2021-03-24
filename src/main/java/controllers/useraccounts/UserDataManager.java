package controllers.useraccounts;

import controllers.DataManager;

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
