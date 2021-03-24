package backend.controllers;

import backend.dataobjects.library.Member;
import backend.dataobjects.library.records.BorrowedItems;
import backend.dataobjects.libraryitems.LibraryItem;

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
