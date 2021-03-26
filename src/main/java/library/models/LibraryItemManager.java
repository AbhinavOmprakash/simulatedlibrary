package library.models;


import common.models.DataManager;

public class LibraryItemManager<V> extends DataManager {
    public LibraryItemManager() {
        super("LibraryItem",  "title");
    }


}
