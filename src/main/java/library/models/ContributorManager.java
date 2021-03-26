package library.models;

import common.models.DataManager;

@SuppressWarnings({"unchecked"})
public class ContributorManager extends DataManager {
    public ContributorManager() {
        super("Contributor", "name");
    }

}
