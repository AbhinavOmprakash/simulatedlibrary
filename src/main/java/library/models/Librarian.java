package library.models;

import common.models.Member;
import library.models.libraryitems.LibraryItem;

public class Librarian {
    BorrowIncharge borrowIncharge;
    ReturnIncharge returnIncharge;

    public Librarian(BorrowIncharge borrowIncharge, ReturnIncharge returnIncharge) {
        this.borrowIncharge = borrowIncharge;
        this.returnIncharge = returnIncharge;
    }

    public boolean isBorrowed(LibraryItem item){
        ArrayList results = borrowedItems.search(item.getId());
        return !results.isEmpty();
    }
}
