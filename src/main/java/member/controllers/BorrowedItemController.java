package member.controllers;

import common.models.CurrentUser;
import common.models.Member;
import library.models.ReturnIncharge;
import member.views.BorrowedItemPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowedItemController implements ActionListener {

    BorrowedItemPanel page;
    public BorrowedItemController(BorrowedItemPanel page) {
        this.page = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==page.returnButton){
            ReturnIncharge.letUserReturn((Member) CurrentUser.getCurrentUser(), page.item);
        }
    }
}
