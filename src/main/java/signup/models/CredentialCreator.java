package signup.models;

import login.models.LoginData;
import login.models.RawLoginData;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class CredentialCreator {
    public static LoginData createNewCredential(RawLoginData data){
        String hashedPass = BCrypt.hashpw(data.getPasswd(),BCrypt.gensalt());
        return new LoginData(data.getUsername(), hashedPass);
    }
}
