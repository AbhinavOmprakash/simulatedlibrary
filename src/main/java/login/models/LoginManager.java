package login.models;

import common.models.DataManager;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class LoginManager {

    private DataManager loginDataManager;
    private SessionManager sessionManager;

    public LoginManager(DataManager loginDataManager, SessionManager sessionManager) {
        this.loginDataManager = loginDataManager;
        this.sessionManager = sessionManager;
    }

    public void login(RawLoginData enteredData) {
        LoginData storedData = getLoginData(enteredData);

        if(verifyCredentials(storedData, enteredData)){
            System.out.println("creds verified");
            forwardToSessionManager(storedData.getUserName());
        } else {
            System.out.println("creds not  verified :(");
        }
    }

    private LoginData getLoginData(RawLoginData enteredData) {
        return (LoginData)loginDataManager.search(enteredData.getUsername());
    }

    private boolean verifyCredentials(LoginData storedData, RawLoginData enteredData){
        System.out.println("\n expected pass \n"+storedData.password);
        System.out.println("\n got pass \n"+ enteredData.getPasswd());
        System.out.println(BCrypt.checkpw(enteredData.getPasswd(), storedData.password));
        return BCrypt.checkpw(enteredData.getPasswd(), storedData.password);
    }

    private void forwardToSessionManager(String username){
        sessionManager.start(username);
    }
}
