package admin;

import admin.views.AdminHome;
import admin.views.NewLibraryItem;
import admin.views.NewMembershipPolicy;
import common.MainRouter;
import common.Router;

import java.awt.event.ActionEvent;

public class AdminRouter extends Router {
    AdminHome adminHome;
    NewLibraryItem newLibraryItem;
    NewMembershipPolicy newPolicy ;

    public AdminRouter(MainRouter router,
                       AdminHome adminHome,
                       NewLibraryItem newLibraryItem,
                       NewMembershipPolicy newPolicy) {
        super(router);
        this.adminHome = adminHome;
        this.newLibraryItem = newLibraryItem;
        this.newPolicy = newPolicy;

        adminHome.registerListener(this);
        newLibraryItem.registerListener(this);
        newPolicy.registerListener(this);
    }

    @Override
    public void homeView() {
        setView(adminHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adminHome.addNewLibraryItemButton){
            setView(newLibraryItem);
        } else if(e.getSource()==adminHome.addNewPolicyButton){
            System.out.println("new policy");
            setView(newPolicy);
        } else if(e.getSource()==newLibraryItem.backButton){
            setView(adminHome);
        } else if(e.getSource()==newPolicy.backButton){
            setView(adminHome);
        } else if(e.getSource()==adminHome.addNewPolicyButton){

        }

    }
}
