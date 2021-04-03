package signup;

import member.controllers.UpgradeMembershipController;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;
import signup.models.SignUpData;

import static org.mockito.Mockito.*;

public class TestSignupController {
//
//    SignUpManager signUpManager = mock(SignUpManager.class);
//    UpgradeMembershipController upgradeMembershipController = mock(UpgradeMembershipController.class);
//    SignupController signupController = new SignupController(signUpManager, upgradeMembershipController);
//
//    @Test
//    void upgradeWontBeCalledIfSignupWithBasicPolicy() {
//        SignUpData basicData = ObjectFactory.getBasicSignUpData();
//        signupController.signUp(basicData);
//        verify(signUpManager, times(1)).signUp(basicData);
//        verify(upgradeMembershipController, times(0)).upgradeMember(
//                                                                anyString(), anyString());
//    }
//
//    @Test
//    void upgradeIsCalledIfSignupWithOtherPolicy() {
//        SignUpData nonBasicData= ObjectFactory.getGoldSignUpData();
//        signupController.signUp(nonBasicData);
//        verify(signUpManager, times(1)).signUp(nonBasicData);
//        verify(upgradeMembershipController, times(1)).upgradeMember(
//                                                                anyString(), anyString());
//    }
}
