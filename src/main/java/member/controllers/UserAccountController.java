package member.controllers;

import common.customevents.CustomEvent;
import common.customevents.CustomEventListener;
import common.models.DataManager;
import common.models.Member;
import common.models.Session;
import member.views.MyAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// todo consider deleting?
public class UserAccountController implements ActionListener, CustomEventListener {
    MyAccount page;
    DataManager users;

    public UserAccountController(DataManager users, MyAccount page) {
        this.users = users;
        this.page = page;
        this.page.registerListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void receive(CustomEvent event) {

    }
}
