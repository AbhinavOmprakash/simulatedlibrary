package controllers.ui;

import views.MainJFrame;
import views.admin.AdminHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeController extends GuiController implements ActionListener {
    AdminHome adminHome = new AdminHome(this);
    public AdminHomeController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(adminHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adminHome.addNewLibraryItemButton){
            parentController.switchToNewLibraryItem();
        } else if(e.getSource()==adminHome.addNewPolicyButton){
            parentController.switchToNewMembershipPolicy();
        }

    }
}
