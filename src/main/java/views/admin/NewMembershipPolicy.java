package views.admin;

import views.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewMembershipPolicy implements displayPage {
    private JTextField textField1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JButton createPolicyButton;
    private JPanel panel;

    public NewMembershipPolicy(ActionListener guicontroller){

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
