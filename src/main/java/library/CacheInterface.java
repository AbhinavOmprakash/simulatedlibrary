package library;

import java.util.ArrayList;

public interface CacheInterface<K,V> {
    void setCapacity(int newCapacity);
    ArrayList<V> search(K query);
    void insert(K key, ArrayList<V> values);
    ArrayList<K> invalidateKeys(V item);
}
