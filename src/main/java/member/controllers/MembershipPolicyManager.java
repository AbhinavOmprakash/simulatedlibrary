package member.controllers;

import common.models.DataManager;

public class MembershipPolicyManager extends DataManager {
    public MembershipPolicyManager() {
        super("MembershipPolicy", "name");
    }
}
