package controllers.library;


import controllers.DataManager;

public class LibraryItemManager<V> extends DataManager {
    public LibraryItemManager() {
        super("LibraryItem",  "title");
    }


}
