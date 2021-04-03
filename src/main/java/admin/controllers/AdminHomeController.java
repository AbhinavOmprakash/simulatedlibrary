package admin.controllers;

import admin.views.AdminHome;
import common.models.LogoutManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeController implements ActionListener {
    AdminHome page;

    public AdminHomeController(AdminHome page) {
        this.page = page;
        page.registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== page.logOutButton){
            LogoutManager.logout();
        }

    }
}
