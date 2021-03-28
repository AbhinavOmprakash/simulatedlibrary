package login.models;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.models.CurrentUser;
import common.models.User;
import member.models.UserDataManager;

public class LoginManager {
    LoginDataManager loginData = new LoginDataManager();
    UserDataManager userdata = UserDataManager.getInstanceOf();

    public void login(rawLoginData enteredData){
        if(verifyLoginData(enteredData)){
            changeUser(enteredData);
            dispatchSignal();
        }
        changeUser(enteredData);
        dispatchSignal();
    }

    private void changeUser(rawLoginData data) {
        User user = getUserFromDB(data);
        CurrentUser.changeUser(user);
    }

    private void dispatchSignal() {
        EventCotroller.getInstanceOf().dispatch(CustomEvent.LOGGED_IN);
    }

    private User getUserFromDB(rawLoginData data) {
        return (User) userdata.search(data.getUsername()).get(0);
    }

    private boolean verifyLoginData(rawLoginData enteredData) {
        LoginData storedData = (LoginData) this.loginData.search(enteredData.getUsername()).get(0);
        return storedData.verifyPasswd(enteredData);
    }

}
