package admin.models;

import common.factory.CleanData;
import common.factory.RawData;

public class PolicyDataAdapter implements RawData {
    String name;
    String rawFees;
    String rawOverdue;
    String rawBorrowLimit;
    String rawDiscount;
    String rawMembershipPeriod;

    public PolicyDataAdapter(String name,
                             String rawFees,
                             String rawOverdue,
                             String rawBorrowLimit,
                             String rawDiscount,
                             String rawMembershipPeriod) {
        this.name = name;
        this.rawFees = rawFees;
        this.rawOverdue = rawOverdue;
        this.rawBorrowLimit = rawBorrowLimit;
        this.rawDiscount = rawDiscount;
        this.rawMembershipPeriod = rawMembershipPeriod;
    }

    public CleanData getCompatibleData(){
        return new NewPolicyData(name,
                Double.parseDouble(rawFees),
                Double.parseDouble(rawOverdue),
                Integer.parseInt(rawBorrowLimit),
                Double.parseDouble(rawDiscount),
                Integer.parseInt(rawMembershipPeriod));
    }
}
