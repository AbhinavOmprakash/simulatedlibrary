package backend.library;

import backend.libraryitems.LibraryItem;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchcked"})
public class BorrowRecord implements IBorrowRecord {
    private Map<String, List<BorrowedItem>> records = new HashMap<>();

    @Override
    public void addItem(String username, LibraryItem item) {
        if(records.containsKey(username)){
            appendRecord(username,item);
        } else {
            createRecord(username, item);
        }
    }

    private void appendRecord(String username, LibraryItem item){
        List borrowedItems = records.get(username);
        borrowedItems.add(new BorrowedItem(item));
        records.replace(username, borrowedItems);
    }

    private void createRecord(String username, LibraryItem item) {
        List borrowedItems = new ArrayList<>();
        borrowedItems.add( new BorrowedItem(item));
        records.put(username, borrowedItems);
    }

    @Override
    public void removeItem(String username, LibraryItem item) throws UnsupportedOperationException{
        if(isValidRequest(username, item)){
            List borrowedItems = records.get(username);
            borrowedItems.remove(item);
            records.replace(username, borrowedItems);
        }
    }

    private boolean isValidRequest(String username, LibraryItem item){
        return records.containsKey(username);
    }

    @Override
    public List fetchRecordsFor(String username) {
        return records.get(username);
    }
}
