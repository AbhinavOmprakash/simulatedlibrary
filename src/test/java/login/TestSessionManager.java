package login;

import common.models.DataManager;
import common.models.Session;
import login.models.SessionManager;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TestSessionManager {
    DataManager mockDB = mock(DataManager.class);
    SessionManager sessionManager = new SessionManager(mockDB);

    @Test
    void memberCanBeSetInSession() {
        String userName = ObjectFactory.getMember().getUserName();
        sessionManager.start(userName);
        assertEquals(userName, Session.getCurrentUser());
    }

    @Test
    void adminCanBeSetInSession() {
        String userName = ObjectFactory.getAdmin().getUserName();
        sessionManager.start(userName);
        assertEquals(userName, Session.getCurrentUser());
    }
}
