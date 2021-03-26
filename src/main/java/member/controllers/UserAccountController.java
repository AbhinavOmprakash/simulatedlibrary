package member.controllers;

import common.GuiController;
import common.MainFrameController;
import common.MainJFrame;
import member.views.MyAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccountController extends GuiController implements ActionListener {
    MyAccount userAccount = new MyAccount(this);
    public UserAccountController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(userAccount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==userAccount.homeButton){
            parentController.switchToHomePage();
        } else if (e.getSource()==userAccount.upgradeMembershipButton){
            parentController.switchToUpgradeMembership();
        }

    }
}
