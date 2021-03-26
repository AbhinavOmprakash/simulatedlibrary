package member.controllers;

import common.controllers.GuiController;
import common.controllers.MainFrameController;
import common.models.CurrentUser;
import common.models.DataManager;
import common.models.Member;
import common.models.MembershipPolicy;
import common.views.MainJFrame;
import member.views.UpgradeMembership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings({"rawtypes, unchecked"})
public class UpgradeMembershipController extends GuiController implements ActionListener{
    UpgradeMembership upgradeMembership = new UpgradeMembership(this);
    DataManager policyManager = new MembershipPolicyManager();
    UpgradeMembershipManager upgradeMembershipManager = new UpgradeMembershipManager();

    public UpgradeMembershipController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(upgradeMembership);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==upgradeMembership.upgradeButton){
            upgradeMembership();
            updateDisplayedPolicy();

        } else if(e.getSource()==upgradeMembership.membershipPolicies){
            changeDisplayedFees();

        } else if(e.getSource()==upgradeMembership.backButton){
            parentController.switchToMyAccount();
        }
    }

    private void updateDisplayedPolicy() {
        Member member = (Member) CurrentUser.getCurrentUser();
        upgradeMembership.currentPolicy.setText(member.getMembershipLevel().getPolicy());
    }

    private void upgradeMembership() {
        Member member = (Member) CurrentUser.getCurrentUser();
        upgradeMembershipManager.upgradeMember(member, getSelectedPolicy());
    }

    private void changeDisplayedFees() {
        Double fees = getFeesForMembership();
        upgradeMembership.fees.setText(String.valueOf(fees));
    }

    private Double getFeesForMembership() {
        MembershipPolicy policy = getSelectedPolicy();
        return policy.membershipFees;
    }

    private MembershipPolicy getSelectedPolicy() {
        Object policyName = upgradeMembership.membershipPolicies.getSelectedItem();
        List results = policyManager.search(String.valueOf(policyName));
        return (MembershipPolicy) results.get(0);
    }
}
