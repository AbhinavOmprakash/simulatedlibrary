package controllers.useraccounts;

import controllers.DataManager;

public class MembershipPolicyManager extends DataManager {
    public MembershipPolicyManager() {
        super("MembershipPolicy", "name");
    }
}
