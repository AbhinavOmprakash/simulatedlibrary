package admin.views;

import common.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminHome implements displayPage {
    private JPanel panel;
    public JButton addNewLibraryItemButton;
    public JButton addNewPolicyButton;
    public JButton viewAllLibraryItemsButton;
    public JButton viewAllPoliciesButton;

    public AdminHome(ActionListener guicontroller) {
        addNewLibraryItemButton.addActionListener(guicontroller);
        addNewPolicyButton.addActionListener(guicontroller);
        viewAllLibraryItemsButton.addActionListener(guicontroller);
        viewAllPoliciesButton.addActionListener(guicontroller);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "adminHome";
    }
}
