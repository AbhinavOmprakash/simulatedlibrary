package member.controllers;

import common.models.CurrentUser;
import common.models.DataManager;
import common.models.Member;
import common.models.MembershipPolicy;
import member.models.MembershipPolicyManager;
import member.models.UpgradeMembershipManager;
import member.views.UpgradeMembership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings({"rawtypes, unchecked"})
public class UpgradeMembershipController implements ActionListener{

    UpgradeMembership upgradeMembership;
    DataManager policyManager = new MembershipPolicyManager();
    UpgradeMembershipManager upgradeMembershipManager = new UpgradeMembershipManager();

    // todo refactor, class seems to be doing too much.
    public UpgradeMembershipController(UpgradeMembership page) {
        upgradeMembership = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==upgradeMembership.upgradeButton){
            upgradeMembership();
            updateDisplayedPolicy();
        } else if(e.getSource()==upgradeMembership.membershipPolicies){
            changeDisplayedFees();
        }
    }

    private void updateDisplayedPolicy() {
        Member member = (Member) CurrentUser.getCurrentUser();
        upgradeMembership.currentPolicy.setText(member.getMembershipLevel().getPolicy());
    }
    //todo consider extracting the following 2 methods to another class.
    private void upgradeMembership() {
        Member member = (Member) CurrentUser.getCurrentUser();
        upgradeMembershipManager.upgradeMember(member, getSelectedPolicy());
    }

    private MembershipPolicy getSelectedPolicy() {
        Object policyName = upgradeMembership.membershipPolicies.getSelectedItem();
        List results = policyManager.search(String.valueOf(policyName));
        return (MembershipPolicy) results.get(0);
    }

    private void changeDisplayedFees() {
        Double fees = getFeesForMembership();
        upgradeMembership.fees.setText(String.valueOf(fees));
    }

    private Double getFeesForMembership() {
        MembershipPolicy policy = getSelectedPolicy();
        return policy.membershipFees;
    }

}
