package library.models;

import common.models.DataManager;
import common.models.Member;
import library.models.libraryitems.LibraryItem;

import java.time.LocalDateTime;

public class NormalReturn implements ReturnIncharge {
    DataManager borrowedItemsRecord;
    DataManager users;

    public NormalReturn(DataManager borrowedItemsRecord, DataManager users) {
        this.borrowedItemsRecord = borrowedItemsRecord;
        this.users = users;
    }

    @Override
    public void returnItem(Member user, LibraryItem item){
        user.returnItem(item);
        users.updateData(user);
        updateBorrowRecord(item);
        System.out.println("item returned Successfully");
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
