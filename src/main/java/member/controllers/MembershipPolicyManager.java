package member.controllers;

import common.DataManager;

public class MembershipPolicyManager extends DataManager {
    public MembershipPolicyManager() {
        super("MembershipPolicy", "name");
    }
}
