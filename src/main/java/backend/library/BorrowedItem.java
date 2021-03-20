package backend.library;

import backend.libraryitems.LibraryItem;

import javax.persistence.ElementCollection;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class BorrowedItem {
    private LibraryItem item;
    private Calendar borrowedOn;

    protected BorrowedItem(LibraryItem item) {
        this.item = item;
        this.borrowedOn = Calendar.getInstance();
    }
    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }
}