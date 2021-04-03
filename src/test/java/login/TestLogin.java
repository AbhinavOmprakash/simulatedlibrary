package login;

import common.models.DataManager;
import common.models.Session;
import login.models.*;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLogin {
    LoginData memberLogin = ObjectFactory.getMemberlogin();
    RawLoginData rawLoginData = ObjectFactory.getRawMemberlogin();
    DataManager mockDataManager = mock(DataManager.class);
    SessionManager sessionManager = new SessionManager(mockDataManager);
    LoginManager manager= new LoginManager(mockDataManager, sessionManager);

    @Test
    void ShouldForwardToSessionManager(){
        when(mockDataManager.search(rawLoginData.getUsername())).thenReturn(memberLogin);
        manager.login(rawLoginData);
        String user = Session.getCurrentUser();
        assertEquals(memberLogin.userName,user);
    }
}
