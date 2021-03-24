package backend.controllers;

import backend.externalservices.DataStoreInterface;
import backend.externalservices.HibernateDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** responsible for querying the database and cache
 * updating the db and cache 
 * @param <V>
 */

@SuppressWarnings({"unchecked","rawtypes"})
public abstract class DataManager<V> {
    public DataStoreInterface dataStore = HibernateDB.getTestInstance();
    private final String inchargeOfTable;
    private final String searchableAttribute;

    public DataManager(String inchargeOfTable, String searchableAttribute) {
        this.inchargeOfTable = inchargeOfTable;
        this.searchableAttribute = searchableAttribute;
    }

    public ArrayList<V> search(Object query) {
       return dataStore.search(query, inchargeOfTable,searchableAttribute);
    }

    public void addItem(V item){
        dataStore.addNewItem(item);
    }

    public void updateData(V item) {
        dataStore.updateItem(item);
    }

    public void deleteItem(V item){
        dataStore.deleteItem(item);
    }

    public ArrayList<V> fetchAll(){
        return dataStore.fetchAll(inchargeOfTable);
    }

}
