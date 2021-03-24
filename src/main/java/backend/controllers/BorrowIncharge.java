package backend.controllers;

import backend.dataobjects.library.Member;
import backend.dataobjects.library.membershiplevels.MembershipLevel;
import backend.dataobjects.library.records.BorrowedItems;
import backend.dataobjects.libraryitems.LibraryItem;

import java.util.ArrayList;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BorrowIncharge {
    DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();

    public void letUserBorrow(Member user, LibraryItem item){
        if(isNotBorrowed(item) && userCanBorrow(user)){
            addToBorrowedItems(item);
            user.addBorrowedItem(item);
        }
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
