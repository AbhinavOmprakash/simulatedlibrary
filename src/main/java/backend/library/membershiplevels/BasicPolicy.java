package backend.library.membershiplevels;

public class BasicPolicy implements MembershipPolicy {
    Double membershipFees;
    Double overdueFeesPerDay;
    int borrowLimit;
    Double discountPercentage; // value must be between 0.0 to 100.0
    int membershipPeriodInMonths = 12;

    public BasicPolicy(){}

    @Override
    public String toString(){
        return "Basic membership";
    }

    @Override
    public Double getMembershipFees() {
        return membershipFees;
    }

    @Override
    public void setMembershipFees(Double membershipFees) {
        this.membershipFees = membershipFees;
    }

    @Override
    public Double getOverdueFeesPerDay() {
        return overdueFeesPerDay;
    }

    @Override
    public void setOverdueFeesPerDay(Double overdueFeesPerDay) {
        this.overdueFeesPerDay = overdueFeesPerDay;
    }

    @Override
    public int getBorrowLimit() {
        return borrowLimit;
    }

    @Override
    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    @Override
    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getMembershipPeriodInMonths() {
        return membershipPeriodInMonths;
    }

    @Override
    public void setMembershipPeriodInMonths(int membershipPeriodInMonths) {
        this.membershipPeriodInMonths = membershipPeriodInMonths;
    }




}
