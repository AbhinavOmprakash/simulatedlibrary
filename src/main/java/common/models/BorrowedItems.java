package common.models;

import library.models.libraryitems.LibraryItem;

import java.util.ArrayList;

public class BorrowedItems extends ArrayList<LibraryItem>{
    public void addItem(LibraryItem item){
        add(item);
    }

    public void removeItem(LibraryItem item){
        remove(item);
    }

    public int totalItemsBorrowed(){
        return size();
    }

    public boolean has(LibraryItem item){
        return contains(item);
    }

}
