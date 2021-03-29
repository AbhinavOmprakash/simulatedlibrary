package admin.models.factories;

import admin.models.NewPolicyData;
import common.models.MembershipPolicy;
import member.models.MembershipPolicyManager;

@SuppressWarnings({"rawtypes, unchecked"})
public class PolicyFactory {
    static MembershipPolicyManager policyManager = new MembershipPolicyManager();

    public static void createNewPolicy(NewPolicyData data){
        MembershipPolicy policy = new MembershipPolicy(data.name,
                data.membershipFees,
                data.overdueFeesPerDay,
                data.borrowLimit,
                data.discountPercentage,
                data.membershipPeriodInMonths);
        policyManager.addItem(policy);
    }
}
