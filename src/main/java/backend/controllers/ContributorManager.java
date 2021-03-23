package backend.controllers;

import backend.externalservices.DataStoreInterface;

@SuppressWarnings({"unchecked"})
public class ContributorManager extends DataManager {
    public ContributorManager() {
        super("Contributor", "name");
    }

}
