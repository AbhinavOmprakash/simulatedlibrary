package ui.library;

import backend.libraryitems.LibraryItem;
import backend.libraryitems.contributors.Contributor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemPanel{

    private JPanel panel1;
    private JLabel Title;
    private JLabel Contributor;
    private JLabel Checked_out;
    private JButton borrowButton;

    public ItemPanel(LibraryItem item){
        this.Title.setText(LibItemDataFormatter.getFormattedTitle(item));
        this.Contributor.setText(LibItemDataFormatter.getFormattedContributors(item));
        this.Checked_out.setText(LibItemDataFormatter.getFormattedCheckedOutStatus(item));
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
