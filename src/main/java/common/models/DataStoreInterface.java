package common.models;
import java.util.ArrayList;

public interface DataStoreInterface {

    Object search(Object query, Object itemType, String attribute);
    ArrayList<Object> fuzzySearch(Object query, Object itemType, String attribute);
    void updateItem(Object item, Object itemType);
    void addNewItem(Object item, Object itemType);
    void deleteItem(Object item, Object itemType);
    ArrayList<Object> fetchAll(Object itemType);
}
