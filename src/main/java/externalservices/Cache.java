package externalservices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Cache<K,V> implements CacheInterface<K,V> {

    private LinkedHashMap<K, ArrayList<V>> cachedData;
    private DataStoreInterface<K,V> dataStore;
    int capacity;
    
    public Cache(DataStoreInterface<K, V> dataStore, int capacity) {
        this.dataStore = dataStore;
        this.capacity = capacity;
        this.cachedData = new LinkedHashMap<>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,ArrayList<V>>e)
            {
                return this.size() > capacity;
            }
        };
    }

    //to do find better name for search.
    // function has side-effect
    public ArrayList<V> search(K query) {
        ArrayList<V> results = cachedData.get(query);
        if (results==null){
            results = dataStore.search(query);
            updateCache(query, results);
        }
        return results;
    }

    public void updateItem(V item){
        invalidateKeys(item);
        dataStore.updateItem(item);
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

    public void updateCache(K key, ArrayList<V> values) {
        cachedData.put(key, values);
    }

    public void addNewItem(V item) {
        dataStore.addNewItem(item);
    }

    public void deleteItem(V item) {
        dataStore.deleteItem(item);
        invalidateKeys(item);
    }

    // getters and setters

    public DataStoreInterface<K, V> getDataStore() {
        return dataStore;
    }

    public void setDataStore(DataStoreInterface<K, V> dataStore) {
        this.dataStore = dataStore;
    }

    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

    public int getCapacity(){
        return capacity;
    }
}
