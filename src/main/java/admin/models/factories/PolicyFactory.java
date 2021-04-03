package admin.models.factories;

import admin.models.NewPolicyData;
import common.factory.CleanData;
import common.factory.Factory;
import common.models.MembershipPolicy;

import java.util.List;

public class PolicyFactory implements Factory<MembershipPolicy> {

    @Override
    public MembershipPolicy create(CleanData cleanData) {
        NewPolicyData data = (NewPolicyData) cleanData;
        return new MembershipPolicy(data.name,
                data.membershipFees,
                data.overdueFeesPerDay,
                data.borrowLimit,
                data.discountPercentage,
                data.membershipPeriodInMonths);
    }
}