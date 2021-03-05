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
        this.cachedData = new LinkedHashMap<>(capacity, 1.0f, true) {
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
     
    public ArrayList<V> search(K query) {
        ArrayList<V> results = cachedData.get(query);
        if (results==null){
            return new ArrayList<>();
        }
        return results;
    }

    public void insert(K key, ArrayList<V> values) {
        cachedData.put(key, values);
    }
    
    public void invalidateKeys(V item) {
        // item is one of the values to one or multiple keys
        ArrayList<K> staleKeys = findStaleKeys(item);
        removeStaleKeys(staleKeys);

    }

    private ArrayList<K> findStaleKeys(V item){
        return MapUtilities.getAllKeysForValue(cachedData, item);
    }

    private void removeStaleKeys(ArrayList<K> staleKeys){
        for (K key : staleKeys) {
            cachedData.remove(key);
        }
    }

        
}
