package views.login;

import controllers.useraccounts.MembershipPolicyManager;
import controllers.useraccounts.SignUpManager;
import models.dataobjects.library.membershiplevels.MembershipPolicy;
import models.dataobjects.library.records.SignUpData;
import views.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SignUpPage implements displayPage {

    private JPanel panel;
    private JPanel SignUpPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JSpinner membershipSpinner;
    private JLabel membershipPolicy;
    private JComboBox membershipPolicies;

    public JButton signUpButton;
    public JButton haveAnAccountButton;

    MembershipPolicyManager policyManager = new MembershipPolicyManager();

    ActionListener guicontroller;

    public SignUpPage(ActionListener guicontroller) {
        this.guicontroller = guicontroller;

        signUpButton.addActionListener(guicontroller);
        haveAnAccountButton.addActionListener(guicontroller);
        populateMembershipPolicies();
    }

    private void populateMembershipPolicies() {
        Object[] allPolicies = getAllPolicies();
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
        return null;
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "signUpPage";
    }


}
