package library;

import externalservices.DataStoreInterface;

import java.util.ArrayList;

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
    
    public void updateData(V item) {
        dataStore.updateItem(item);
    }

    public void setDataStore(DataStoreInterface<K,V> newDataStore){
        dataStore = newDataStore;
    }

    public DataStoreInterface<K, V> getDataStore() {
        return dataStore;
    }
}
