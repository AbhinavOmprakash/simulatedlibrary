package library;

import java.util.ArrayList;

public interface CacheInterface<K,V> {
    void setCapacity(int newCapacity);
    ArrayList<V> search(String query);
    void insert(K key, ArrayList<V> values);
    void invalidateKeys(V item);
}