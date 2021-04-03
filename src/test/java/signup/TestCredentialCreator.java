package signup;

import common.factory.Factory;
import common.factory.RawData;
import login.models.LoginData;
import login.models.RawLoginData;
import org.junit.jupiter.api.Test;
import signup.models.CredentialCreator;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestCredentialCreator {
    @Test
    void LoginCredentialsShouldStoreHashedPassword() {
        RawData data = (RawData) new RawLoginData("ab","pass");
        Factory<LoginData> credentialCreator = new CredentialCreator();
        LoginData credentials = credentialCreator.create(data.getCompatibleData());
        assertNotEquals(((RawLoginData)data).getPasswd(), credentials.password);
    }
}
