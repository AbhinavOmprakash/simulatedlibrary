package member.views;

import common.Router;
import common.models.DisplayPage;
import library.models.libraryitems.LibraryItem;
import member.controllers.BorrowedItemController;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BorrowedItemPanel implements DisplayPage {
    private JPanel panel;
    public JButton moreInfo;
    public JButton returnButton;
    private JLabel title;
    private JLabel itemType;

    public final LibraryItem item; // todo consider moving to controller?
    BorrowedItemController controller = new BorrowedItemController(this);

    public BorrowedItemPanel(LibraryItem item){
        this.item = item;

        title.setText(item.getTitle());
        itemType.setText(item.getType());
        registerListener(controller);
    }

    @Override
    public void registerListener(ActionListener listener) {
        moreInfo.addActionListener(listener);
        returnButton.addActionListener(listener);
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
