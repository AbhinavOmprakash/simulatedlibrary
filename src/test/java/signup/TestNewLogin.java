package signup;

import common.factory.Factory;
import common.models.DataManager;
import login.models.LoginData;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import setup.ObjectFactory;
import signup.models.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestNewLogin {
//    SignUpData signUpData = ObjectFactory.getBasicSignUpData(); //test data
//
//    DataManager mockDataManager = mock(DataManager.class);
//
//    Factory<LoginData> newLogin = new (mockDataManager) {
//    ArgumentCaptor<LoginData> loginDataCaptor = ArgumentCaptor.forClass(LoginData.class);
//
//    @Test
//    void loginCredsAreProperlyCreated() {
//        // using credential creator because the way the password will be hashed can change
//        newLogin.create(signUpData);
//
//        verify(mockDataManager).addItem(loginDataCaptor.capture());
//
//        LoginData expectedLoginData = CredentialCreator.createNewCredential(signUpData.userName, signUpData.password);
//        LoginData actualLoginData = loginDataCaptor.getValue();
//
//        assertEquals(expectedLoginData.userName, actualLoginData.userName);
//        //passwords can't be tested because they are generated with a different salt everytime.
//        assertEquals(expectedLoginData.password, actualLoginData.password);
//    }


}
