package common.models;


public class MembershipLevelFactory {
    private final DataManager allPolicies;

    public MembershipLevelFactory(DataManager allPolicies) {
        this.allPolicies = allPolicies;
    }

    public MembershipLevel createMembershipLevel(String policyName){
        MembershipPolicy policy = getMembershipPolicy(policyName);
        return createMembershipLevel(policy);
    }

    private MembershipPolicy getMembershipPolicy(String policyName) {
        return (MembershipPolicy) allPolicies.search(policyName);
    }

    public MembershipLevel createMembershipLevel(MembershipPolicy policy){
        return new MembershipLevel(policy);
    }
}
