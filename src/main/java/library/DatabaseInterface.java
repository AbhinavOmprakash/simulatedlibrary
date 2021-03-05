package library;

import java.util.ArrayList;
import java.util.Map;

public interface DatabaseInterface<K,V> {

    public ArrayList<V> search(K query);

    public void update(V item, Map<K, ArrayList<V>> itemAttributes);

    public V getItem(V item);
}
