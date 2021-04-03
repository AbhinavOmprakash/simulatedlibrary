package member.controllers;

import common.models.*;
import member.models.MembershipUpgrader;
import member.views.UpgradeMembership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpgradePageController implements ActionListener, ItemListener {

    UpgradeMembership page;
    DataManager policyManager;
    DataManager users;
    MembershipUpgrader membershipUpgrader;

    public UpgradePageController(UpgradeMembership page,
                                 DataManager policyManager,
                                 DataManager users,
                                 MembershipUpgrader membershipUpgrader) {
        this.page = page;
        this.policyManager = policyManager;
        this.users = users;
        this.membershipUpgrader = membershipUpgrader;

        page.registerListener(this);
        page.registerItemEventListenere(this);
        updateDisplayedPolicy();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== page.upgradeButton){
            upgradeMembership();
            updateDisplayedPolicy();
        } else if(e.getSource()== page.membershipPolicies){
            changeDisplayedFees();
        }
    }

    private void updateDisplayedPolicy() {
        Member member = getMember();
        page.currentPolicy.setText(member.getMembershipLevel().getPolicy());
    }

    private Member getMember(){
        return (Member) users.search(Session.getCurrentUser());
    }

    private void upgradeMembership() {
        Member member = getMember();
        membershipUpgrader.upgrade(member, getSelectedPolicy());
    }

    private MembershipPolicy getSelectedPolicy() {
        Object policyName = page.membershipPolicies.getSelectedItem();
        Object results = policyManager.search(String.valueOf(policyName));
        return (MembershipPolicy) results;
    }

    private void changeDisplayedFees() {
        Double fees = getFeesForMembership();
        page.fees.setText(String.valueOf(fees));
    }

    private Double getFeesForMembership() {
        MembershipPolicy policy = getSelectedPolicy();
        return policy.membershipFees;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED){
            changeDisplayedFees();
        }
    }
}
