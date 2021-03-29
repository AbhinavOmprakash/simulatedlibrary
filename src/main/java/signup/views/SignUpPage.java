package signup.views;

import member.controllers.MembershipPolicyManager;
import common.models.MembershipPolicy;
import signup.models.SignUpData;
import common.models.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SignUpPage implements displayPage {

    private JPanel panel;
    private JPanel SignUpPanel;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField userName;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JSpinner membershipSpinner;
    private JLabel membershipPolicy;
    private JComboBox membershipPolicies;

    public JButton signUpButton;
    public JButton haveAnAccountButton;

    MembershipPolicyManager policyManager = new MembershipPolicyManager();

    public SignUpPage(ActionListener guicontroller) {
        signUpButton.addActionListener(guicontroller);
        haveAnAccountButton.addActionListener(guicontroller);
        populateMembershipPolicies();
    }

    private void populateMembershipPolicies() {
        Object[] allPolicies = controller.getAllPolicies();
        for (Object p : allPolicies){
            MembershipPolicy policy = (MembershipPolicy) p;
            membershipPolicies.addItem(policy.getName());
        }
    }

    private Object[] getAllPolicies(){
        ArrayList policies = policyManager.fetchAll();
        // for dev
        if (policies.isEmpty()) {
            return new Object[]{"basic"};
        }else {
            return policies.toArray();
        }
    }

    public SignUpData fetchSignUpData() {
        return  new SignUpData(firstName.getText(), lastName.getText(),
                userName.getText(), passwordField1.getPassword(),
                (MembershipPolicy) membershipPolicies.getSelectedItem());
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "signUpPage";
    }


}
