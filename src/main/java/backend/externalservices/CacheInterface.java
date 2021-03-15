package backend.externalservices;

import java.util.ArrayList;

public interface CacheInterface<K,V> extends DataStoreInterface<K,V> {
    void setCapacity(int newCapacity);
    void updateCache(K key, ArrayList<V> values);
    void invalidateKeys(V item);
}
