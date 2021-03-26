package admin.controllers;

import common.GuiController;
import common.MainFrameController;
import common.MainJFrame;
import admin.views.NewMembershipPolicy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMembershipPolicyController extends GuiController implements ActionListener {
    NewMembershipPolicy policyPage = new NewMembershipPolicy(this);

    public NewMembershipPolicyController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(policyPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
