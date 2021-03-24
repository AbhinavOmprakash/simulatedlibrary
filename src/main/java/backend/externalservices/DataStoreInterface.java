package backend.externalservices;
import java.util.ArrayList;
import java.util.Map;

public interface DataStoreInterface<V> {

    ArrayList<V> search(Object query, String table, String attribute);
    void updateItem(V item);
    void addNewItem(V item);
    void deleteItem(V item);
    ArrayList<V> fetchAll(String table);
}
