package backend.controllers;

import backend.externalservices.DataStoreInterface;

import java.awt.event.ActionEvent;

@SuppressWarnings({"unchecked"})
public class UserDataController extends DataController{
    public UserDataController(DataStoreInterface dataStore) {
        super(dataStore,"User", "name");
    }

}
