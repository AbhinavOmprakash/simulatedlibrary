package login;

import common.models.Session;
import login.models.SessionManager;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSessionManager {
    SessionManager sessionManager = new SessionManager();

    @Test
    void memberCanBeSetInSession() {
        String userName = ObjectFactory.getMember().getUserName();
        sessionManager.start(userName);
        assertEquals(userName, sessionManager.getCurrentSession().getCurrentUser());
    }

    @Test
    void adminCanBeSetInSession() {
        String userName = ObjectFactory.getAdmin().getUserName();
        sessionManager.start(userName);
        assertEquals(userName, sessionManager.getCurrentSession().getCurrentUser());
    }
}
