package views.myaccount;

import controllers.library.ReturnIncharge;
import models.dataobjects.library.CurrentUser;
import models.dataobjects.library.Member;
import models.dataobjects.libraryitems.LibraryItem;
import views.LibItemDataFormatter;
import views.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowedItemPanel implements ActionListener, displayPage{
    private JTextArea titleArea;
    private JButton moreInfoButton;
    private JButton returnButton;
    private JPanel panel;

    private ReturnIncharge returnIncharge = new ReturnIncharge();
    private final LibraryItem item;

    public BorrowedItemPanel(LibraryItem item) {
        this.item = item;
        titleArea.setText(LibItemDataFormatter.getFormattedTitle(item));
        returnButton.addActionListener(this);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "BorrowedItemPanel";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==returnButton){
            returnIncharge.letUserReturn((Member) CurrentUser.getCurrentUser(), item);
            System.out.println("returned");
        }
    }

}
