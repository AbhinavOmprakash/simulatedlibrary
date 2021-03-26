package member.views;

import library.models.ReturnIncharge;
import common.CurrentUser;
import member.models.Member;
import library.models.libraryitems.LibraryItem;
import library.models.libraryitems.LibItemDataFormatter;
import common.displayPage;

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
