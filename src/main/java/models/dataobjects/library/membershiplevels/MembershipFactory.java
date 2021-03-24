package models.dataobjects.library.membershiplevels;

import controllers.DataManager;
import controllers.useraccounts.MembershipPolicyManager;

public class MembershipFactory {
    static DataManager allPolicies = new MembershipPolicyManager();

    public static MembershipLevel createMembership(String policyName){
        MembershipPolicy policy = (MembershipPolicy) allPolicies.search(policyName).get(0);
        return new MembershipLevel(policy);
    }
}
