package library.models;

import common.models.DataManager;
import common.models.Member;
import library.models.libraryitems.LibraryItem;

import java.time.LocalDateTime;

public class ReturnIncharge {
    DataManager borrowedItemsRecord;

    public ReturnIncharge(DataManager borrowedItemsRecord) {
        this.borrowedItemsRecord = borrowedItemsRecord;
    }

    public void returnItem(Member user, LibraryItem item){
        user.returnBorrowedItem(item);
        updateBorrowRecord(item);
    }

    private void updateBorrowRecord(LibraryItem item) {
        BorrowedItem borrowed = new BorrowedItem(item);
        borrowedItemsRecord.deleteItem(borrowed);
    }

    public boolean isOverdue(LibraryItem item){
        LocalDateTime returnDeadline = getReturnDeadline(item);
        LocalDateTime today = LocalDateTime.now();
        return (today.isAfter(returnDeadline));
    }

    private static void removeFromBorrowedItems(LibraryItem item) {
        BorrowedItems borrowed = new BorrowedItems(item);
        borrowedItems.deleteItem(borrowed);
    }
}
