package member.controllers;

import member.views.MyAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccountController implements ActionListener {

    MyAccount page;

    public UserAccountController(MyAccount page) {
        this.page = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
