package signup;

import org.junit.jupiter.api.Test;
import setup.ObjectFactory;
import signup.models.*;

import static org.mockito.Mockito.*;

public class TestSignUpManager {
    SignUpData signUpData = ObjectFactory.getBasicSignUpData(); //test data

    Creator newMember = mock(Creator.class);
    Creator newFinAccount = mock(Creator.class);
    Creator newLogin = mock(Creator.class);
    SignUpManager signUpManager = new SignUpManager(newMember, newFinAccount, newLogin);

    @Test
    void testValidDataIsCreatedOnSignUP() {
        signUpManager.signUp(signUpData);
        verify(newMember, times(1)).create(signUpData);
        verify(newFinAccount, times(1)).create(signUpData);
        verify(newLogin, times(1)).create(signUpData);
    }
}
