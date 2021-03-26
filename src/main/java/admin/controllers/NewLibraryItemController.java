package admin.controllers;
import common.controllers.GuiController;
import common.controllers.MainFrameController;
import common.views.MainJFrame;
import admin.views.NewLibraryItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewLibraryItemController extends GuiController implements ActionListener {
    NewLibraryItem newLibraryItem = new NewLibraryItem(this);
    
    public NewLibraryItemController(MainFrameController parentController, MainJFrame mainFrame) {
        super(parentController, mainFrame);
        setCurrentPage(newLibraryItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newLibraryItem.addItemButton){
            createNewItem();
        }
    }

    private void createNewItem() {
    }
}
