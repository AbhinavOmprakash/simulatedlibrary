package library.models;

import common.models.DataManager;
import common.models.Member;
import library.models.libraryitems.LibraryItem;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ReturnIncharge {
    private static DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();

    public static void letUserReturn(Member user, LibraryItem item){
        user.returnBorrowedItem(item);
        removeFromBorrowedItems(item);
    }

    private static void removeFromBorrowedItems(LibraryItem item) {
        BorrowedItems borrowed = new BorrowedItems(item);
        borrowedItems.deleteItem(borrowed);
    }
}
