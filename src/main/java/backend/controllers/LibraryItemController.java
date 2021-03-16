package backend.controllers;

import backend.externalservices.DataStoreInterface;

import java.awt.event.ActionEvent;

@SuppressWarnings({"unchecked"})
public class LibraryItemController extends DataController{

    public LibraryItemController(DataStoreInterface dataStore) {
        super(dataStore,"LibraryItem",  "title");
    }


}
