package backend.externalservices;
import java.util.ArrayList;
import java.util.Map;

public interface DataStoreInterface<V> {

    ArrayList<V> search(String query, String table, String attribute);
    void updateItem(V item);
    void addNewItem(V item);
    void deleteItem(V item);
}
