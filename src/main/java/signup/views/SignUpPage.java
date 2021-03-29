package signup.views;

import common.Router;
import member.models.MembershipPolicyManager;
import common.models.MembershipPolicy;
import signup.controllers.SignUpController;
import signup.models.RawSignUpData;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SignUpPage implements DisplayPage {

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

    SignUpController controller;

    public SignUpPage(Router router) {
        controller = new SignUpController(this);

        registerListener(router);
        registerListener(controller);
        populateMembershipPolicies();
    }

    @Override
    public void registerListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
        haveAnAccountButton.addActionListener(listener);
    }

    private void populateMembershipPolicies() {
        Object[] allPolicies = controller.getAllPolicies();
        for (Object p : allPolicies){
            MembershipPolicy policy = (MembershipPolicy) p;
            membershipPolicies.addItem(policy.getName());
        }
    }

    public RawSignUpData fetchSignUpData() {
        return  new RawSignUpData(firstName.getText(), lastName.getText(),
                userName.getText(), passwordField1.getPassword(),
                (String) membershipPolicies.getSelectedItem());
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "signUpPage";
    }
}
