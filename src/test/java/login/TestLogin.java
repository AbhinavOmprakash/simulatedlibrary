package login;

import common.models.Session;
import login.models.LoginData;
import login.models.LoginDataManager;
import login.models.LoginManager;
import login.models.RawLoginData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLogin {

    LoginManager manager;
    LoginData memberLogin = ObjectFactory.getMemberlogin();
    RawLoginData rawLoginData = ObjectFactory.getRawMemberlogin();

    @BeforeEach
    public void setUp() {
        LoginDataManager mockDataManager = mock(LoginDataManager.class);
        when(mockDataManager.search(rawLoginData.getUsername())).thenReturn(memberLogin);
        manager = new LoginManager(mockDataManager);
    }


    @Test
    void ShouldForwardToSessionManager(){
        manager.login(rawLoginData);
        assertEquals(memberLogin.username, Session.getCurrentUser());
    }
}
