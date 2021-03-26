package common.models;

import externalservices.DataStoreInterface;
import externalservices.HibernateDB;

import java.util.ArrayList;

/** responsible for querying the database and cache
 * updating the db and cache 
 * @param <V>
 */

@SuppressWarnings({"unchecked","rawtypes"})
public abstract class DataManager<V> implements DataObservable {
    public DataStoreInterface dataStore = HibernateDB.getTestInstance();
    private final String inchargeOfTable;
    private final String searchableAttribute;

    ArrayList<DataObserver> observers = new ArrayList<>();

    public DataManager(String inchargeOfTable, String searchableAttribute) {
        this.inchargeOfTable = inchargeOfTable;
        this.searchableAttribute = searchableAttribute;
    }

    public ArrayList<V> search(Object query) {
       return dataStore.search(query, inchargeOfTable,searchableAttribute);
    }

    public void addItem(V item){
        dataStore.addNewItem(item);
        notifyObservers();
    }

    public void updateData(V item) {
        dataStore.updateItem(item);
        notifyObservers();
    }


    public void deleteItem(V item){
        dataStore.deleteItem(item);
        notifyObservers();
    }

    public ArrayList<V> fetchAll(){
        return dataStore.fetchAll(inchargeOfTable);
    }

    @Override
    public void registerListener(DataObserver listener) {
        observers.add(listener);
    }

    @Override
    public void removeListener(DataObserver listener) {
        observers.remove(listener);
    }

    @Override
    public void notifyObservers() {
        for (DataObserver o : observers) {
            o.performAction();
        }
    }
}
