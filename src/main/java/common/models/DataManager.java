package common.models;

import java.util.ArrayList;

public class DataManager implements DataObservable {
    protected DataStoreInterface dataStore;
    private final Object table;
    private final String searchableAttribute;

    ArrayList<DataObserver> observers = new ArrayList<>();

    public DataManager(DataStoreInterface database, Searchable entity) {
        this.dataStore = database;
        this.table = entity.getTableName();
        this.searchableAttribute = entity.getSearchableAttribute();
    }

    public ArrayList<Object> fuzzySearch(Object query) {
       return  dataStore.fuzzySearch(query, table, searchableAttribute);
    }

    public Object search(Object query) {
        return dataStore.search(query, table, searchableAttribute);
    }
    public void addItem(Object item){
        dataStore.addNewItem(item, table);
        notifyObservers();
    }

    public void updateData(Object item) {
        dataStore.updateItem(item, table);
        notifyObservers();
    }

    public void deleteItem(Object item){
        dataStore.deleteItem(item, table);
        notifyObservers();
    }

    public ArrayList<Object> fetchAll(){
        return dataStore.fetchAll(table);
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
