package controllers.ui;

import controllers.DataManager;
import controllers.useraccounts.MembershipPolicyManager;
import models.dataobjects.library.membershiplevels.MembershipPolicy;
import views.MainJFrame;
import views.myaccount.UpgradeMembership;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

@SuppressWarnings({"rawtypes, unchecked"})
public class UpgradeMembershipController extends GuiController implements ActionListener{
    UpgradeMembership upgradeMembership = new UpgradeMembership(this);
    DataManager policyManager = new MembershipPolicyManager();

    public UpgradeMembershipController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(upgradeMembership);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==upgradeMembership.upgradeButton){
            System.out.println("upgrading!!!!!!!!!!!");
        }
        if(e.getSource()==upgradeMembership.membershipPolicies){
            changeDisplayedFees();
        }
    }

    private void changeDisplayedFees() {
        Double fees = getFeesForMembership();
        upgradeMembership.fees.setText(String.valueOf(fees));
    }

    private Double getFeesForMembership() {
        Object policyName = upgradeMembership.membershipPolicies.getSelectedItem();
        List results = policyManager.search(String.valueOf(policyName));
        MembershipPolicy policy = (MembershipPolicy) results.get(0);
        return policy.membershipFees;
    }
}
