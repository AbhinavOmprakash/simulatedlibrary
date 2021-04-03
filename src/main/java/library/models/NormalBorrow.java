package library.models;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.models.DataManager;
import common.models.Member;
import library.models.libraryitems.LibraryItem;

public class NormalBorrow implements BorrowIncharge{
    DataManager borrowedItemsRecord;
    DataManager users;

    public NormalBorrow(DataManager borrowedItemsRecord, DataManager users) {
        this.borrowedItemsRecord = borrowedItemsRecord;
        this.users = users;
    }

    @Override
    public void borrowItem(Member member, LibraryItem item){
        member.borrowItem(item);
        users.updateData(member);
        updateBorrowRecord(item);
    }

    private void updateBorrowRecord(LibraryItem item) {
        BorrowedItem borrowed = new BorrowedItem(item);
        borrowedItemsRecord.addItem(borrowed);
        EventCotroller.getInstanceOf().dispatch(CustomEvent.BORROWED);
    }
}
