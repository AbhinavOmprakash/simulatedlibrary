package member.views;

import common.models.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class UpgradeMembership implements DisplayPage {
    public JComboBox membershipPolicies;
    public JLabel fees;
    public JButton upgradeButton;
    private JPanel panel;
    public JLabel currentPolicy;
    public JButton backButton;

    DataManager allPolicies;
    DataManager users;

    public UpgradeMembership(DataManager policies, DataManager users) {
        this.allPolicies = policies;
        this.users = users;
        populateMembershipPolicies();
    }

    @Override
    public void registerListener(ActionListener listener) {
        upgradeButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public void registerItemEventListenere(ItemListener listener){
        membershipPolicies.addItemListener(listener);
    }

    @Override
    public void refresh() {
        updateDisplayedPolicy();
        membershipPolicies.removeAllItems();
        populateMembershipPolicies();
    }

    private void updateDisplayedPolicy() {
        // todo duplicated in controller.
        Member member = getMember();
        currentPolicy.setText(member.getMembershipLevel().getPolicy());
    }

    private Member getMember(){
        return (Member) users.search(Session.getCurrentUser());
    }

    private void populateMembershipPolicies() {
        Object[] allPolicies = getAllPolicies();
        for (Object p : allPolicies){
            MembershipPolicy policy = (MembershipPolicy) p;
            membershipPolicies.addItem(policy.getName());
        }
    }

    private Object[] getAllPolicies(){
        ArrayList policies = allPolicies.fetchAll();
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
