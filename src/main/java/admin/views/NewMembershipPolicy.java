package admin.views;

import admin.models.PolicyDataAdapter;
import common.Router;
import common.factory.FactoryGui;
import common.factory.RawData;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewMembershipPolicy implements DisplayPage, FactoryGui {
    private JTextField policyName;
    public JButton createPolicyButton;
    private JPanel panel;
    public JButton backButton;
    private JTextField fees;
    private JTextField overdue;
    private JTextField borrowLimit;
    private JTextField discounts;
    private JTextField membershipPeriod;

    public NewMembershipPolicy(){
    }

    @Override
    public void registerListener(ActionListener listener) {
        createPolicyButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    @Override
    public void refresh() {

    }

    @Override
    public JButton getCreateButton() {
        return createPolicyButton;
    }

    @Override
    public RawData getRawData() {
        return new PolicyDataAdapter(policyName.getText(),
                fees.getText(),
                overdue.getText(),
                borrowLimit.getText(),
                discounts.getText(),
                membershipPeriod.getText());
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
