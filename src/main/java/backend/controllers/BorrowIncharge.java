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
            /* this is a hacky solution for a bug arising from concurrent access of data
            * the item must be first added to the user's borrowed items
            * and then to the main borrowed items list
            * because a function in LibraryItem display is called when
            * the BorrowedItems table is modified.
            * this function gets the user instance which has old data
            * and works with that. hence updating the user data first
            * is an easy solution (for now).
            * */
            user.addBorrowedItem(item);
            addToBorrowedItems(item);
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
