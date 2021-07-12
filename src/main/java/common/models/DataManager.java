package common.models;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager implements DataObservable {
    protected DataStoreInterface dataStore;
    private final Object table;
    private final String searchableAttribute;
    Has
    ArrayList<DataObserver> observers = new ArrayList<>();

    public DataManager(DataStoreInterface database, Searchable entity) {
        this.dataStore = database;
        this.table = entity.getTableName();
        this.searchableAttribute = entity.getSearchableAttribute();
    }

    private void indexObjects(){
        List<Object> allObjects = fetchAll();
        for (Object o: allObjects){
            addToIndex(o);
        }
    }

    private void addToIndex(Object o) {

    }

    public ArrayList<Object> fuzzySearch(Object query) {
       return  dataStore.fuzzySearch(query, table, searchableAttribute);
    }

    public Object search(Object query) {
        String someQuery = constructQuery(query);
        return dataStore.search(query, table, searchableAttribute);
    }

    private String constructQuery(Object query) {
        return null;
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
