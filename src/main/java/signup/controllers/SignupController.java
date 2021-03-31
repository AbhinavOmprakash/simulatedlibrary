package signup.controllers;

import member.models.UpgradeMembershipManager;
import signup.models.SignUpData;
import signup.models.SignUpManager;

public class SignupController {
    SignUpManager signUpManager;
    UpgradeMembershipManager upgradeMembershipManager;

    public SignupController(SignUpManager signUpManager,
                            UpgradeMembershipManager upgradeMembershipManager) {
        this.signUpManager = signUpManager;
        this.upgradeMembershipManager = upgradeMembershipManager;
    }

    public void signUp(SignUpData data){
        signUpManager.signUp(data);
        if(!(data.policy.equals("Basic"))){
            upgradeMembershipManager.upgradeMember(data.userName, data.policy);
        }
    }
}
