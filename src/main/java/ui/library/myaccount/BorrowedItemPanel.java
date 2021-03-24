package ui.library.myaccount;

import backend.controllers.Librarian;
import backend.dataobjects.libraryitems.LibraryItem;
import ui.library.LibItemDataFormatter;
import ui.library.displayPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowedItemPanel implements ActionListener, displayPage {
    private JTextArea titleArea;
    private JButton moreInfoButton;
    private JButton returnButton;
    private JPanel panel;

    private Librarian librarian = new Librarian();
    private final LibraryItem item;

    public BorrowedItemPanel(LibraryItem item) {
        this.item = item;
        titleArea.setText(LibItemDataFormatter.getFormattedTitle(item));
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==returnButton){
//            librarian.letUserReturn((Member) CurrentUser.getCurrentUser(), item);
//        }
        System.out.println("returned");
    }
}
