package signup.views;

import common.factory.FactoryGui;
import common.factory.RawData;
import common.models.DataManager;
import common.models.MembershipPolicy;
import signup.controllers.SignUpGuiController;
import signup.models.RawSignUpData;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SignUpPage implements DisplayPage, FactoryGui {

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

    SignUpGuiController guiController;
    DataManager policyData;

    public SignUpPage(DataManager policyData) {
        this.policyData = policyData;
        populateMembershipPolicies();
    }

    @Override
    public void registerListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
        haveAnAccountButton.addActionListener(listener);
    }

    @Override
    public void refresh() {
        firstName.setText("");
        lastName.setText("");
        userName.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

    @Override
    public JButton getCreateButton() {
        return signUpButton;
    }

    @Override
    public RawData getRawData() {
        return new RawSignUpData(
                firstName.getText(), lastName.getText(),
                userName.getText(), passwordField1.getPassword(),
                (String) membershipPolicies.getSelectedItem()
        );
    }

    private void populateMembershipPolicies() {
        Object[] allPolicies = policyData.fetchAll().toArray();
        for (Object p : allPolicies){
            MembershipPolicy policy = (MembershipPolicy) p;
            membershipPolicies.addItem(policy.getName());
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "signUpPage";
    }
}
