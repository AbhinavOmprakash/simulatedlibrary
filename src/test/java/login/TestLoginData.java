package login;

import login.models.LoginData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoginData {
    @Test
    void LoginDataDoesNotModifyInputData() {
        String username = "username";
        String password = "password";
        LoginData data = new LoginData(username, password);
        assertEquals(username, data.userName);
        assertEquals(password, data.password);
    }

}
