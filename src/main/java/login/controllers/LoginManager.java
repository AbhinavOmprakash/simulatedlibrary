package login.controllers;

import common.CurrentUser;
import common.User;
import member.controllers.UserDataManager;
import login.models.LoginData;

public class LoginManager {
    LoginDataManager loginData = new LoginDataManager();
    UserDataManager userdata = UserDataManager.getInstanceOf();

    public boolean login(LoginData enteredData){
        //todo change in production
        if(true){
            changeUser(enteredData);
            return true;
        } else {
            return false;
        }
    }

    private void changeUser(LoginData data) {
        User user = getUserFromDB(data);
        CurrentUser.changeUser(user);
    }

    //todo modify in production
    private User getUserFromDB(LoginData data) {
        return (User) userdata.search("abhi").get(0);
    }

    private boolean verifyLoginData(LoginData enteredData) {
        LoginData storedData = (LoginData) this.loginData.search(enteredData.getUsername()).get(0);
        return storedData.equals(enteredData);
    }


}
