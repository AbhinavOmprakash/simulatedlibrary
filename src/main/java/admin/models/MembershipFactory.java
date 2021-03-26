package admin.models;

import common.models.DataManager;
import member.controllers.MembershipPolicyManager;
import common.models.MembershipLevel;
import common.models.MembershipPolicy;

public class MembershipFactory {
    static DataManager allPolicies = new MembershipPolicyManager();

    public static MembershipLevel createMembership(String policyName){
        MembershipPolicy policy = (MembershipPolicy) allPolicies.search(policyName).get(0);
        return new MembershipLevel(policy);
    }

    public static MembershipLevel createMembership(MembershipPolicy policy){
        return new MembershipLevel(policy);
    }
}
