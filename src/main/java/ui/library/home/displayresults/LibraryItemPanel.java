package ui.library.home.displayresults;

import backend.library.CurrentUser;
import backend.library.Librarian;
import backend.library.Member;
import backend.libraryitems.LibraryItem;
import ui.library.LibItemDataFormatter;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryItemPanel implements displayPage, ActionListener {

    private JPanel panel1;
    private JButton borrowButton;
    private JTextArea contributors;
    private JTextArea title;
    private JTextArea checkedOut;
    private JTextArea libItemType;
    private JButton infoButton;

    private final Librarian librarian = new Librarian();
    private final LibraryItem item;

    public LibraryItemPanel(LibraryItem item){
        this.item = item;
        this.title.setText(LibItemDataFormatter.getFormattedTitle(item));
        this.contributors.setText(LibItemDataFormatter.getFormattedContributors(item));
        this.libItemType.setText(item.getType());
        this.checkedOut.setText(LibItemDataFormatter.getFormattedCheckedOutStatus(item));

        this.borrowButton.addActionListener(this);
    }

    public JPanel getPanel1() {
        return panel1;
    }


    @Override
    public JPanel getPanel() {
        return getPanel1();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==borrowButton){
            System.out.println("borrowed");
            Member currentUser = (Member) CurrentUser.getCurrentUser();
            librarian.letUserBorrow(currentUser, item);
        }

    }
}
