package login.models;

import common.models.Session;
import common.models.User;

public class SessionManager {

    public static void start(String userName) {
        Session.removeUser();
        Session.setUser(userName);
    }

    public static void end(String userName){
        // tbd
    }
}
