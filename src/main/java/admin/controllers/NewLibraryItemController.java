package admin.controllers;

import admin.models.NewLibItemDataAdapter;
import admin.models.factories.LibraryItemFactory;
import admin.views.NewLibraryItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewLibraryItemController implements ActionListener {
    NewLibraryItem newLibraryItem;

    public NewLibraryItemController(NewLibraryItem page) {
        newLibraryItem = page;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newLibraryItem.addItemButton){
            createNewItem();
        }
    }

    private void createNewItem() {
        NewLibItemDataAdapter rawData = newLibraryItem.fetchData();
        LibraryItemFactory.createNewItem(rawData.getCompatibleData());
    }
}
