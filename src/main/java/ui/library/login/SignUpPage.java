package ui.library.login;

import backend.controllers.MembershipPolicyManager;
import backend.controllers.SignUpManager;
import backend.dataobjects.library.records.SignUpData;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SignUpPage implements displayPage, ActionListener {

    private JPanel panel;
    private JPanel SignUpPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton haveAnAccountButton;
    private JSpinner membershipSpinner;
    private JLabel membershipPolicy;

    EntryPage parent;

    SignUpManager signUpManager = new SignUpManager();
    MembershipPolicyManager policyManager = new MembershipPolicyManager();

    public SignUpPage(EntryPage parent) {
        this.parent  = parent;
        signUpButton.addActionListener(this);
        haveAnAccountButton.addActionListener(this);
//        populateSpinner();
    }

    private void populateSpinner(){
        SpinnerListModel policies = new SpinnerListModel(getAllPolicies());
        membershipSpinner.setValue((Object) policies);
        System.out.println("populated");
    }

    private Object[] getAllPolicies(){
        ArrayList  policies = policyManager.fetchAll();
        // for dev
        if (policies.isEmpty()) {
            return new Object[]{"basic"};
        }else {
            return policies.toArray();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==signUpButton){
            performSignUp();
        }
        if (e.getSource()==haveAnAccountButton){
            parent.changeToLoginPage();
        }

    }

    private void performSignUp() {
        if(true){
            parent.signUpSuccessful();
        }
    }

    private boolean trySigningUp() {
        SignUpData signUpData = fetchSignUpData();
        return true;
    }

    private SignUpData fetchSignUpData() {
        return null;
    }

    public JPanel getPanel() {
        return panel;
    }


}
