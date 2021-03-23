package backend.library.records;

import backend.libraryitems.LibraryItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
public class BorrowedItems{
    private String itemTitle;
    private LocalDateTime borrowedOn;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int ID;

    public BorrowedItems(){
        // for hibernate
    }

    public BorrowedItems(LibraryItem item){
        this.itemTitle = item.getTitle();
        this.borrowedOn = LocalDateTime.now();
    }

    public String getBorrowedDate(){
        DateTimeFormatter formatter = getFormatter();
        return formatter.format(borrowedOn);
    }

    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public LocalDateTime getBorrowedOn() {
        return borrowedOn;
    }

    public void setBorrowedOn(LocalDateTime borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}