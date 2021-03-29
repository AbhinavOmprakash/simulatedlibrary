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

    public boolean borrowPossible(Member user, LibraryItem item){
        return (userCanBorrow(user) && isNotBorrowed(item));
    }

    private boolean userCanBorrow(Member user){
        MembershipLevel membershipLevel =  user.getMembershipLevel();
        int borrowLimit = membershipLevel.getBorrowLimit();
        return user.getBorrowedItems().size() < borrowLimit;
    }

    private boolean isNotBorrowed(LibraryItem item){
        LibraryItem results = (LibraryItem) borrowedItemsRecord.search(item.getId());
        return (results!=null);
    }
}
