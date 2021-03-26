package library.models;

import common.DataManager;

@SuppressWarnings({"unchecked"})
public class ContributorManager extends DataManager {
    public ContributorManager() {
        super("Contributor", "name");
    }

}
