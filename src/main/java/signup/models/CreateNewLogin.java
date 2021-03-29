package signup.models;

import common.models.DataManager;
import login.models.LoginData;
import login.models.LoginDataManager;

@SuppressWarnings("rawtypes, unchecked")
public class CreateNewLogin {
    private static DataManager loginDataManager = new LoginDataManager();

    public static void createLoginCredentials(SignUpData data) {
        LoginData loginData = new LoginData(data.userName, data.password);
        loginDataManager.addItem(loginData);
    }

}
