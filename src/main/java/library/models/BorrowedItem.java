package library.models;

import common.models.Searchable;
import library.models.libraryitems.LibraryItem;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
public class BorrowedItem implements Searchable {
    @Id
    private long ID;
    private LocalDateTime borrowedOn;

    public BorrowedItem(){
        // for hibernate
    }

    public BorrowedItem(LibraryItem item){
        this.ID = item.getId();
        this.borrowedOn = LocalDateTime.now();
    }

    public String getBorrowedDate(){
        DateTimeFormatter formatter = getFormatter();
        return formatter.format(borrowedOn);
    }

    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
    }


    public LocalDateTime getBorrowedOn() {
        return borrowedOn;
    }

    public void setBorrowedOn(LocalDateTime borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String getTableName() {
        return "BorrowedItem";
    }

    @Override
    public String getSearchableAttribute() {
        return "ID";
    }
}