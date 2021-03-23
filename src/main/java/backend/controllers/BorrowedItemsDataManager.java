package backend.controllers;

import backend.libraryitems.LibraryItem;

import java.util.ArrayList;

public class BorrowedItemsDataManager extends DataManager{
    public BorrowedItemsDataManager() {
        super("BorrowedItems","itemTitle");
    }
}
