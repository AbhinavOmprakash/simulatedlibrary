package admin.models;

public class PolicyDataAdapter {
    String name;
    Object rawFees;
    Object rawOverdue;
    Object rawBorrowLimit;
    Object rawDiscount;
    Object rawMembershipPeriod;

    public PolicyDataAdapter(String name, Object rawFees, Object rawOverdue,
                             Object rawBorrowLimit,Object rawDiscount, Object rawMembershipPeriod) {
        this.name = name;
        this.rawFees = rawFees;
        this.rawOverdue = rawOverdue;
        this.rawBorrowLimit = rawBorrowLimit;
        this.rawDiscount = rawDiscount;
        this.rawMembershipPeriod = rawMembershipPeriod;
    }

    public NewPolicyData getCompatibleData(){
        return new NewPolicyData(name,
                Double.parseDouble((String) rawFees),
                Double.parseDouble((String) rawOverdue),
                Integer.parseInt((String) rawDiscount),
                Double.parseDouble((String) rawDiscount),
                Integer.parseInt((String) rawMembershipPeriod));
    }
}
