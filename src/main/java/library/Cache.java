package library;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import library.MapUtilities;

@SuppressWarnings("serial")
public class Cache<K,V> implements CacheInterface<K,V> {
    private LinkedHashMap<K, ArrayList<V>> cachedData;
    int capacity;
    
    public Cache(int capacity) {
        this.capacity = capacity;
        this.cachedData = new LinkedHashMap<K, ArrayList<V>>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,ArrayList<V>>e)
            {
                return this.size() > capacity;
            }
        };
    }

    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

    public int getCapacity(){
        return capacity;
    }
     
    public ArrayList<V> search(String query) {
        ArrayList<V> results = cachedData.get(query);
        return results;
    }

    public void insert(K key, ArrayList<V> values) {
        cachedData.put(key, values);
    }
    
    public void invalidateKeys(V item) {
        // item is one of the va
        ArrayList<K> staleKeys = MapUtilities.getAllKeysForValue(cachedData, item);
        for (K key : staleKeys) {
            cachedData.remove(key);
        }
    }

        
}