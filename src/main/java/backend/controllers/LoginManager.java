package backend.controllers;

import backend.library.CurrentUser;
import backend.library.User;
import backend.library.records.LoginData;

public class LoginManager {
    LoginDataManager loginData = new LoginDataManager();
    UserDataManager userdata = new UserDataManager();

    public boolean login(LoginData enteredData){
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

    private User getUserFromDB(LoginData data) {
        return (User) userdata.search("abhi").get(0);
    }

    private boolean verifyLoginData(LoginData enteredData) {
        LoginData storedData = (LoginData) this.loginData.search(enteredData.getUsername()).get(0);
        return storedData.equals(enteredData);
    }


}