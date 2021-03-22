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
    public HibernateDB dataStore = HibernateDB.getTestInstance();
    private String inchargeOfTable;
    private String searchableAttribute;

    public DataManager(String inchargeOfTable, String searchableAttribute) {
        this.inchargeOfTable = inchargeOfTable;
        this.searchableAttribute = searchableAttribute;
    }

    public ArrayList<V> search(String query) {
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

    // getters and setters
    public void setDataStore(DataStoreInterface<V> newDataStore){
        dataStore = (HibernateDB) newDataStore;
    }

    public DataStoreInterface<V> getDataStore() {
        return dataStore;
    }

    public String getInchargeOfTable() {
        return inchargeOfTable;
    }

    public void setInchargeOfTable(String inchargeOfTable) {
        this.inchargeOfTable = inchargeOfTable;
    }

    public String getSearchableAttribute() {
        return searchableAttribute;
    }

    public void setSearchableAttribute(String searchableAttribute) {
        this.searchableAttribute = searchableAttribute;
    }

}
