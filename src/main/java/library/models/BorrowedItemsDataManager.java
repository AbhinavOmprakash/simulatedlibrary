package library.models;

import common.models.DataManager;

public class BorrowedItemsDataManager extends DataManager {
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
