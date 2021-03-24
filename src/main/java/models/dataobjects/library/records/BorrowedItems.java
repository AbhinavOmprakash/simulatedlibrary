package models.dataobjects.library.records;

import models.dataobjects.libraryitems.LibraryItem;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
public class BorrowedItems{
    @Id
    private long ID;
    private LocalDateTime borrowedOn;


    public BorrowedItems(){
        // for hibernate
    }

    public BorrowedItems(LibraryItem item){
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
}