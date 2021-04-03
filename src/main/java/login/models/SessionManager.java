package login.models;

import admin.models.Admin;
import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.models.DataManager;
import common.models.Member;
import common.models.Session;
import common.models.User;

public class SessionManager {
    DataManager users;

    public SessionManager(DataManager users) {
        this.users = users;
    }

    public void start(String userName) {
        User user = (User) users.search(userName);
        Session.setCurrentUser(user.getUserName());
        setAccessPrivilege(user);
        EventCotroller.getInstanceOf().dispatch(CustomEvent.LOGGED_IN);

        System.out.println("dispatching login signal y'all");
    }

    private void setAccessPrivilege(User user) {
        if(user instanceof Member){
            Session.setAccessPrivilege(Member.getAccessPrivilege());
        } else{
            Session.setAccessPrivilege(Admin.getAccessPrivilege());
        }
    }

    public void end(){
        Session.removeUser();
    }
}
