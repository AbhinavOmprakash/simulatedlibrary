package controllers.ui;

import views.MainJFrame;
import views.admin.NewMembershipPolicy;

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
