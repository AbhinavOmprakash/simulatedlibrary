package backend.controllers;

import backend.externalservices.DataStoreInterface;

import java.awt.event.ActionEvent;

@SuppressWarnings({"unchecked"})
public class ContributorController extends DataController{
    public ContributorController(DataStoreInterface dataStore) {
        super(dataStore, "Contributor", "name");
    }

}
