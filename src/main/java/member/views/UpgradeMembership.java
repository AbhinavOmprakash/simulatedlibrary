package member.views;

import common.models.DataManager;
import member.controllers.MembershipPolicyManager;
import common.models.CurrentUser;
import common.models.Member;
import common.models.MembershipPolicy;
import common.models.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class UpgradeMembership implements displayPage {
    public JComboBox membershipPolicies;
    public JLabel fees;
    public JButton upgradeButton;
    private JPanel panel;
    public JLabel currentPolicy;
    public JButton backButton;

    DataManager policyManager = new MembershipPolicyManager();

    public UpgradeMembership(ActionListener guicontroller) {
        populateMembershipPolicies();
        setCurrentUserPolicy();

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
