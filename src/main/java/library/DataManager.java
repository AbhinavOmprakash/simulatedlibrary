package library;

import java.util.ArrayList;
import java.util.HashMap;

/** responsible for querying the database and cache
 * updating the db and cache 
 * @param <K>
 * @param <V>
 */

public class DataManager<K,V>{
    private DataStoreInterface<K,V> dataStore;

    public DataManager(DataStoreInterface<K,V> dataStore) {
        this.dataStore = dataStore;
    }

    public ArrayList<V> search(K query) {
       return dataStore.search(query);
    }
    
    public void updateData(V item, 
            HashMap<K, ArrayList<V>> newData) {
        dataStore.update(item, newData);
    }

    public void setDataStore(DataStoreInterface<K,V> newDataStore){
        dataStore = newDataStore;
    }

    public void getDataStore(){
        return dataStore
    }




}
