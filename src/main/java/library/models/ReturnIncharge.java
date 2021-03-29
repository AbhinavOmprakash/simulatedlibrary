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

    private LocalDateTime getReturnDeadline(LibraryItem item) {
        LocalDateTime borrowedOn = getBorrowedOnDate(item);
        int borrowPeriod = item.getBorrowPeriodInDays();
        return borrowedOn.plusDays(borrowPeriod);
    }

    private LocalDateTime getBorrowedOnDate(LibraryItem item) {
        BorrowedItem record = (BorrowedItem) borrowedItemsRecord.search(item.getId());
        return record.getBorrowedOn();
    }

}
