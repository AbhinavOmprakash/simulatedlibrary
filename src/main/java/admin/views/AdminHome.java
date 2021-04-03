package admin.views;

import admin.controllers.AdminHomeController;
import common.Router;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminHome implements DisplayPage {
    private JPanel panel;
    public JButton addNewLibraryItemButton;
    public JButton addNewPolicyButton;
    public JButton viewAllLibraryItemsButton;
    public JButton viewAllPoliciesButton;
    public JButton logOutButton;

    public AdminHome() {
    }

    public void registerListener(ActionListener listener) {
        addNewLibraryItemButton.addActionListener(listener);
        addNewPolicyButton.addActionListener(listener);
        viewAllLibraryItemsButton.addActionListener(listener);
        viewAllPoliciesButton.addActionListener(listener);
        logOutButton.addActionListener(listener);
    }

    @Override
    public void refresh() {

    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "AdminHome";
    }

}
