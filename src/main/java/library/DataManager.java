package library;

import java.util.ArrayList;
import java.util.HashMap;

/** responsible for querying the database and cache
 * updating the db and cache 
 * @param <K>
 * @param <V>
 */

public class DataManager<K,V>{
    private DatabaseInterface<K,V> database;
    private CacheInterface<K,V> cache;

    public DataManager(DatabaseInterface<K,V> database, CacheInterface<K,V> cache) {
        this.database = database;
        this.cache = cache;
    }

    public ArrayList<V> search(String query) {
        ArrayList<V> results = cache.search(query);
        if (results.isEmpty()) {
            results = database.search(query);
        }
        return results;
    }
    
    public void updateData(V item, 
            HashMap<K, ArrayList<V>> newData) {

        database.update(item, newData);
        V updatedItem = database.getItem(item);
        cache.invalidateKeys(updatedItem);
    }

}
