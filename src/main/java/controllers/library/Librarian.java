package controllers.library;

import controllers.DataManager;
import models.dataobjects.libraryitems.LibraryItem;

import java.util.ArrayList;

// To Do find a better name for class
@SuppressWarnings({"rawtypes", "unchecked"})
public class Librarian {
    DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();

    public boolean isBorrowed(LibraryItem item){
        ArrayList results = borrowedItems.search(item.getId());
        return !results.isEmpty();
    }
}