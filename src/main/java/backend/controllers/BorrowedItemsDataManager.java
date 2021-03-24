package backend.controllers;

import ui.library.DataObserver;

import java.util.ArrayList;

public class BorrowedItemsDataManager extends DataManager{
    private static BorrowedItemsDataManager instance;
    private BorrowedItemsDataManager() {
        super("BorrowedItems","ID");
    }

    public static BorrowedItemsDataManager getInstanceOf() {
        if(instance==null){
            instance = new BorrowedItemsDataManager();
        }
        return instance;
    }
}
