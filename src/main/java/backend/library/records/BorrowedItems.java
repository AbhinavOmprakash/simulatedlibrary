package backend.library.records;

import backend.library.User;
import backend.libraryitems.LibraryItem;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
public class BorrowedItems{
    @Id
    private int userID;
    @ElementCollection
    private Map<LibraryItem, LocalDateTime> items = new HashMap<>();

    public BorrowedItems(){
        // for hibernate
    }

    public BorrowedItems(User user){
        userID = user.getID();
    }

    public void addLibraryItem(LibraryItem item){
        items.put(item, LocalDateTime.now());
    }

    public void removeLibraryItem(LibraryItem item){
        items.remove(item);
    }
    public String getBorrowedDateFor(LibraryItem item){
        LocalDateTime borrowedOn = items.get(item);
        DateTimeFormatter formatter = getFormatter();
        return formatter.format(borrowedOn);
    }

    private DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Map<LibraryItem, LocalDateTime> getItems() {
        return items;
    }

    public void setItems(Map<LibraryItem, LocalDateTime> items) {
        this.items = items;
    }
}