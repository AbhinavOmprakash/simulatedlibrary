package login.models;

import common.models.CurrentUser;
import common.models.User;
import member.controllers.UserDataManager;

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
