package library.membershiplevels;

import java.util.Calendar;

public class BasicMembership implements MembershipLevel {

    static Double membershipFees = 50.0;
    static Double overdueFeesPerDay = 1.0;
    static int borrowLimit = 1;
    static Double discounts = 0.0; // value must be between 0.0 to 1.0
    static int membershipPeriodInMonths = 12;
    Calendar expiringOn;

    public BasicMembership(){
        this.expiringOn = calculateMembershipExpiry(membershipPeriodInMonths);
    }

    public static Double getMembershipFees() {
        return membershipFees;
    }

    public static void setMembershipFees(Double membershipFees) {
        BasicMembership.membershipFees = membershipFees;
    }

    public static Double getOverdueFeesPerDay() {
        return overdueFeesPerDay;
    }

    protected static void setOverdueFeesPerDay(Double overdueFeesPerDay) {
        BasicMembership.overdueFeesPerDay = overdueFeesPerDay;
    }

    public static int getBorrowLimit() {
        return borrowLimit;
    }

    protected static void setBorrowLimit(int borrowLimit) {
        BasicMembership.borrowLimit = borrowLimit;
    }

    public static Double getDiscounts() {
        return discounts;
    }

    protected static void setDiscounts(Double discounts) {
        BasicMembership.discounts = discounts;
    }

    public static int getMembershipPeriodInMonths() {
        return membershipPeriodInMonths;
    }

    protected static void setMembershipPeriodInMonths(int membershipPeriodInMonths) {
        BasicMembership.membershipPeriodInMonths = membershipPeriodInMonths;
    }

    public Calendar getExpiringOn() {
        return expiringOn;
    }

}