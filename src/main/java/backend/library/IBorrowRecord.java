package backend.library;

import backend.libraryitems.LibraryItem;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface IBorrowRecord {
    void addItem(String username, LibraryItem item);
    void removeItem(String username, LibraryItem item);
    List fetchRecordsFor(String username);
}
