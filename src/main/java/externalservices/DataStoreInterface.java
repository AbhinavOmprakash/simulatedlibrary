package externalservices;

import java.util.ArrayList;
import java.util.Map;

public interface DataStoreInterface<K,V> {

    ArrayList<V> search(K query);
    void updateItem(V item);
    void addNewItem(V item);

}
