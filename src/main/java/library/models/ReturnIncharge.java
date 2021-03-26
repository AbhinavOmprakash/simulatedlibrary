package library.models;

import common.models.DataManager;
import common.models.Member;
import library.models.libraryitems.LibraryItem;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ReturnIncharge {
    DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();
    Accountant penaltyAccountant = new PenaltyAccountant();

    public void letUserReturn(Member user, LibraryItem item){
        user.returnBorrowedItem(item);
        removeFromBorrowedItems(item);
    }

    private void removeFromBorrowedItems(LibraryItem item) {
        BorrowedItems borrowed = new BorrowedItems(item);
        borrowedItems.deleteItem(borrowed);
    }
}
