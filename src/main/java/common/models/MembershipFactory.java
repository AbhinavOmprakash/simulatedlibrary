package common.models;

import member.models.MembershipPolicyManager;

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
