package views.admin;

import views.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminHome implements displayPage {
    private JPanel panel;
    private JButton addNewLibraryItemButton;
    private JButton addNewPolicyButton;
    private JButton viewAllLibraryItemsButton;
    private JButton viewAllPoliciesButton;

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
