package views.admin;

import views.displayPage;

import javax.swing.*;

public class AdminHome implements displayPage {
    private JPanel panel;
    private JButton addNewLibraryItemButton;
    private JButton addNewPolicyButton;
    private JButton viewAllLibraryItemsButton;
    private JButton viewAllPoliciesButton;

    @Override
    public JPanel getPanel() {
        return panel;
    }
}
