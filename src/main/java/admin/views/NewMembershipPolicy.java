package admin.views;

import admin.controllers.NewMembershipPolicyController;
import admin.models.PolicyDataAdapter;
import common.Router;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewMembershipPolicy implements DisplayPage {
    private JTextField policyName;
    private JSpinner fees;
    private JSpinner overdueFees;
    private JSpinner borrowLimit;
    private JSpinner discounts;
    private JSpinner membershipPeriod;
    public JButton createPolicyButton;
    private JPanel panel;
    public JButton backButton;

    ActionListener controller;
    public NewMembershipPolicy(Router router){
        controller = new NewMembershipPolicyController(this);

        registerListener(controller);
        registerListener(router);
    }

    @Override
    public void registerListener(ActionListener listener) {
        createPolicyButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    public PolicyDataAdapter fetchRawData(){
        return new PolicyDataAdapter(policyName.getText(),
                fees.getValue(),
                overdueFees.getValue(),
                borrowLimit.getValue(),
                discounts.getValue(),
                membershipPeriod.getValue());
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "newPolicy";
    }


}
