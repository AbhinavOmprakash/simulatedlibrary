package controllers.library;

import controllers.financials.Accountant;
import controllers.DataManager;
import controllers.financials.PenaltyAccountant;
import models.dataobjects.library.Member;
import models.dataobjects.library.records.BorrowedItems;
import models.dataobjects.libraryitems.LibraryItem;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ReturnIncharge {
    DataManager borrowedItems = BorrowedItemsDataManager.getInstanceOf();
    Accountant penaltyAccountant = new PenaltyAccountant();

    public void letUserReturn(Member user, LibraryItem item){
        user.returnBorrowedItem(item);
        removeFromBorrowedItems(item);
    }

    private void removeFromBorrowedItems(LibraryItem item) {
        BorrowedItems borrowed = new BorrowedItems(item);
        borrowedItems.deleteItem(borrowed);
    }
}
