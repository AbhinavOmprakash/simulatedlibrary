package library.models;


import common.DataManager;

public class LibraryItemManager<V> extends DataManager {
    public LibraryItemManager() {
        super("LibraryItem",  "title");
    }


}
