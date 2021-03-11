package library.membershiplevels;

public interface MembershipPolicy {

    String toString();

    //getters
    Double getMembershipFees();
    Double getOverdueFeesPerDay();
    int getBorrowLimit();
    Double getDiscountPercentage();
    int getMembershipPeriodInMonths();

    //setters
    void setMembershipFees(Double membershipFees);
    void setOverdueFeesPerDay(Double overdueFeesPerDay);
    void setBorrowLimit(int borrowLimit);
    void setDiscountPercentage(Double discountPercentage);
    void setMembershipPeriodInMonths(int membershipPeriodInMonths);


}
