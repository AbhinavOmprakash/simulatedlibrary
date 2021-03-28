package admin;

import admin.views.AdminHome;
import admin.views.NewLibraryItem;
import admin.views.NewMembershipPolicy;
import common.Router;

import java.awt.event.ActionEvent;

public class AdminRouter extends Router {
    AdminHome adminHome = new AdminHome(this);
    NewLibraryItem newLibraryItem = new NewLibraryItem(this);
    NewMembershipPolicy newPolicy = new NewMembershipPolicy(this);

    public AdminRouter(Router router) {
        super(router);
        registerView(adminHome);
        registerView(newLibraryItem);
        registerView(newPolicy);
    }

    @Override
    public void homeView() {
        setView(adminHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adminHome.addNewLibraryItemButton){
            System.out.println("new library item");
            setView(newLibraryItem);

        } else if(e.getSource()==adminHome.addNewPolicyButton){
            System.out.println("new policy");
            setView(newPolicy);
        } else if(e.getSource()==newLibraryItem.backButton){
            setView(adminHome);
        } else if(e.getSource()==newPolicy.backButton){
            setView(adminHome);
        }
    }
}
