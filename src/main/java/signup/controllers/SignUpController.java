package signup.controllers;

import member.models.MembershipPolicyManager;
import signup.models.RawSignUpData;
import signup.models.SignUpData;
import signup.models.SignUpManager;
import signup.views.SignUpPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class SignUpController implements ActionListener {
    SignUpManager signUpManager = new SignUpManager();
    SignUpPage page;
    MembershipPolicyManager policyManager = new MembershipPolicyManager();

    public SignUpController(SignUpPage page) {
        this.page = page;
    }

    public Object[] getAllPolicies(){
        ArrayList policies = policyManager.fetchAll();
        return policies.toArray();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == page.signUpButton) {
            performSignUp();
        }
    }

    private void performSignUp() {
        RawSignUpData rawSignUpData = page.fetchSignUpData();
        signUpManager.signUp(new SignUpData(rawSignUpData));
    }

}
