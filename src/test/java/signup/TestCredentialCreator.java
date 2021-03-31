package signup;

import login.models.LoginData;
import login.models.RawLoginData;
import org.junit.jupiter.api.Test;
import signup.models.CredentialCreator;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCredentialCreator {
    @Test
    void LoginCredentialsShouldStoreHashedPassword() {
        RawLoginData data = new RawLoginData("ab","pass");
        LoginData credentials =  CredentialCreator.createNewCredential(data);
        assertNotEquals(data.getPasswd(), credentials.password);
    }
}
