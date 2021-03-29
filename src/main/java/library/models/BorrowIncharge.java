package library.models;

import common.models.DataManager;
import common.models.Member;
import common.models.MembershipLevel;
import library.models.libraryitems.LibraryItem;

public class BorrowIncharge {
    DataManager borrowedItemsRecord;

    public BorrowIncharge(DataManager borrowedItemsRecord) {
        this.borrowedItemsRecord = borrowedItemsRecord;
    }

    public void borrowItem(Member user, LibraryItem item){
        user.addBorrowedItem(item);
        updateBorrowRecord(item);
    }

    private void updateBorrowRecord(LibraryItem item) {
        BorrowedItem borrowed = new BorrowedItem(item);
        borrowedItemsRecord.addItem(borrowed);
    }

    public static boolean userCanBorrow(Member user){
        MembershipLevel membershipLevel =  user.getMembershipLevel();
        int borrowLimit = membershipLevel.getBorrowLimit();
        System.out.println(borrowLimit);
        System.out.println(user.getBorrowedItems().size());
        return user.getBorrowedItems().size() < borrowLimit;
    }

    private void addToBorrowedItems(LibraryItem item) {
        BorrowedItems borrowed = new BorrowedItems(item);
        borrowedItems.addItem(borrowed);
    }

    private boolean isNotBorrowed(LibraryItem item) {
        ArrayList results = borrowedItems.search(item.getId());
        return results.isEmpty();
    }
}
