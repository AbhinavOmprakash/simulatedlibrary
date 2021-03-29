package login;

import login.models.LoginData;
import login.models.LoginManager;
import login.models.RawLoginData;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestLogin {

    @Test
    void loginManagerShouldAcceptTheseCreds() {
        LoginData memberLogin = ObjectFactory.getMemberlogin();
        String userName = memberLogin.username;
        char[] pass ="aww".toCharArray();
        RawLoginData enteredCredentials = new RawLoginData(userName, pass );
        assertTrue(LoginManager.verifyCredentials(memberLogin, enteredCredentials));
    }

    @Test
    void loginManagerShouldDenyTheseCreds() {
        LoginData memberLogin = ObjectFactory.getMemberlogin();
        String userName = memberLogin.username;
        char[] pass ="wrongPassword".toCharArray();
        RawLoginData enteredCredentials = new RawLoginData(userName, pass);
        assertFalse(LoginManager.verifyCredentials(memberLogin, enteredCredentials));
    }

}
