package admin.models;

public class NewPolicyData {
    public String name;
    public Double membershipFees;
    public Double overdueFeesPerDay;
    public int borrowLimit;
    public Double discountPercentage; // value must be between 0.0 to 100.0
    public int membershipPeriodInMonths;

    public NewPolicyData(String name, Double membershipFees,
                         Double overdueFeesPerDay, int borrowLimit,
                         Double discountPercentage, int membershipPeriodInMonths) {
        this.name = name;
        this.membershipFees = membershipFees;
        this.overdueFeesPerDay = overdueFeesPerDay;
        this.borrowLimit = borrowLimit;
        this.discountPercentage = discountPercentage;
        this.membershipPeriodInMonths = membershipPeriodInMonths;
    }
}
