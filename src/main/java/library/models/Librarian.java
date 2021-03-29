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

    public void borrowItem(Member member, LibraryItem item){
        if (borrowIncharge.borrowPossible(member, item)){
            borrowIncharge.borrowItem(member, item);
        }
    }

    public void returnItem(Member member, LibraryItem item){
        if(returnIncharge.isOverdue(item)){
            // do stuff
        } else{
            returnIncharge.returnItem(member, item);
        }
    }
}
