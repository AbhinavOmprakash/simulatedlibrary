package controllers.ui;

import views.MainJFrame;
import views.myaccount.MyAccount;

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
        }

    }
}
