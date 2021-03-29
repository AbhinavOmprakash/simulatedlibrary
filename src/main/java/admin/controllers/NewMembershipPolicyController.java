package admin.controllers;

import admin.models.PolicyDataAdapter;
import admin.models.factories.PolicyFactory;
import common.Router;
import admin.views.NewMembershipPolicy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMembershipPolicyController implements ActionListener {
    NewMembershipPolicy policyPage ;

    public NewMembershipPolicyController(NewMembershipPolicy policyPage) {
        this.policyPage = policyPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==policyPage.createPolicyButton){
            createNewPolicy();
        }
    }

    private void createNewPolicy() {
        PolicyDataAdapter rawData = policyPage.fetchRawData();
        PolicyFactory.createNewPolicy(rawData.getCompatibleData());
    }
}
