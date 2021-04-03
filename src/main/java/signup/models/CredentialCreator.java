package signup.models;

import common.factory.CleanData;
import common.factory.Factory;
import login.models.LoginData;
import login.models.RawLoginData;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class CredentialCreator implements Factory<LoginData> {

    //todo delete
    public static LoginData createNewCredential(RawLoginData data){
        String hashedPass = BCrypt.hashpw(data.getPasswd(),BCrypt.gensalt());
        return new LoginData(data.getUsername(), hashedPass);
    }

    //todo delete
    public static LoginData createNewCredential(String userName, String password) {
        String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt());
        return new LoginData(userName, hashedPass);
    }

    @Override
    public LoginData create(CleanData cleanData) {
        SignUpData data = (SignUpData) cleanData;
        String hashedPass = BCrypt.hashpw(data.password, BCrypt.gensalt());
        return new LoginData(data.userName, hashedPass);
    }
}
