package backend.controllers;

import backend.dataobjects.library.Member;
import backend.dataobjects.library.records.BorrowedItems;
import backend.dataobjects.libraryitems.LibraryItem;

import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Librarian {
    DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();

    public boolean isBorrowed(LibraryItem item){
        ArrayList results = borrowedItems.search(item.getId());
        return !results.isEmpty();
    }
}
