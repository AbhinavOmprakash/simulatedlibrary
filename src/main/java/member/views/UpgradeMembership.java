package member.views;

import common.Router;
import common.models.DataManager;
import member.controllers.UpgradeMembershipController;
import member.models.MembershipPolicyManager;
import common.models.CurrentUser;
import common.models.Member;
import common.models.MembershipPolicy;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class UpgradeMembership implements DisplayPage {
    public JComboBox membershipPolicies;
    public JLabel fees;
    public JButton upgradeButton;
    private JPanel panel;
    public JLabel currentPolicy;
    public JButton backButton;

    DataManager policyManager = new MembershipPolicyManager();
    ActionListener controller;

    public UpgradeMembership(Router router) {
        controller = new UpgradeMembershipController(this);
        populateMembershipPolicies();
        setCurrentUserPolicy();
        registerListener(controller);
        registerListener(router);
    }

    @Override
    public void registerListener(ActionListener listener) {
        upgradeButton.addActionListener(listener);
        membershipPolicies.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    private void setCurrentUserPolicy() {
        Member user = (Member) CurrentUser.getCurrentUser();
        currentPolicy.setText(user.getMembershipLevel().getPolicy());
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

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "upgradeMembership";
    }
}
