package admin.controllers;

import admin.views.AdminHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeController implements ActionListener {
    AdminHome adminHome;

    public AdminHomeController(AdminHome page) {
        adminHome = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
