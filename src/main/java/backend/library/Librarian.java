package backend.library;

import backend.controllers.BorrowedItemsDataManager;
import backend.controllers.DataManager;
import backend.controllers.LibraryItemManager;
import backend.libraryitems.LibraryItem;

import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Librarian {
    DataManager borrowedItems = new BorrowedItemsDataManager();
    Accountant penaltyAccountant = new PenaltyAccountant();

    public void letUserBorrow(Member user, LibraryItem item){
        if(isNotBorrowed(item)){
            addToBorrowedItemsRecord(item);
            user.addBorrowedItem(item);
        }
    }

    private void addToBorrowedItemsRecord(LibraryItem item) {
        borrowedItems.addItem(item);
    }

    private boolean isNotBorrowed(LibraryItem item) {
        ArrayList results = borrowedItems.search(item.getTitle());
        return results.isEmpty();
    }

    public void letUserReturn(Member user, LibraryItem item){
        user.returnBorrowedItem(item);
    }
}
