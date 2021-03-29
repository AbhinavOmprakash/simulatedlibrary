package login;

import common.models.Session;
import login.models.SessionManager;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSessionManager {

    @Test
    void memberCanBeSetInSession() {
        String userName = ObjectFactory.getMember().getUserName();
        SessionManager.start(userName);
        assertEquals(userName, Session.getCurrentUser());
    }

    @Test
    void adminCanBeSetInSession() {
        String userName = ObjectFactory.getAdmin().getUserName();
        SessionManager.start(userName);
        assertEquals(userName, Session.getCurrentUser());
    }
}
