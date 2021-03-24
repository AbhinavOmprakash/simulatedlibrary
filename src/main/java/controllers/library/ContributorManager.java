package controllers.library;

import controllers.DataManager;

@SuppressWarnings({"unchecked"})
public class ContributorManager extends DataManager {
    public ContributorManager() {
        super("Contributor", "name");
    }

}
