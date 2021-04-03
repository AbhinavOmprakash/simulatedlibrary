package member.views;

import common.models.DisplayPage;
import library.models.libraryitems.LibraryItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("rawtypes")
public class BorrowedItemPanel implements DisplayPage, ActionListener {
    private JPanel panel;
    public JButton moreInfo;
    public JButton returnButton;
    private JLabel title;
    private JLabel itemType;

    public final LibraryItem item; // todo consider moving to controller?
    private BorrowedItemDisplay parent;

    public BorrowedItemPanel(BorrowedItemDisplay parent, LibraryItem item){
        this.item = item;
        this.parent = parent;
        title.setText(item.getTitle());
        itemType.setText(item.getType());
        registerListener(this);
    }

    @Override
    public void registerListener(ActionListener listener) {
        moreInfo.addActionListener(listener);
        returnButton.addActionListener(listener);
    }

    @Override
    public void refresh() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==returnButton){
            returnItem(item);
            System.out.println("button pressed");
        }
    }

    public void returnItem(LibraryItem item){
        parent.returnItem(item);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "BorrowedItemPanel";
    }


}
