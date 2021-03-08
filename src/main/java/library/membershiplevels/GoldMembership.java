package library.membershiplevels;

import java.util.Calendar;

public class GoldMembership implements MembershipLevel{


    static Double membershipFees = 100.0;
    static Double overdueFeesPerDay = 0.5;
    static int borrowLimit = 5;
    static Double discounts = 0.0; // value must be between 0.0 to 1.0
    static int membershipPeriodInMonths = 12;
    Calendar expiringOn;

    public GoldMembership() {
        this.expiringOn = calculateMembershipExpiry(membershipPeriodInMonths);
    }

    public static Double getMembershipFees() {
        return membershipFees;
    }

    public static void setMembershipFees(Double membershipFees) {
        GoldMembership.membershipFees = membershipFees;
    }


    public static Double getOverdueFeesPerDay() {
        return overdueFeesPerDay;
    }

    protected static void setOverdueFeesPerDay(Double overdueFeesPerDay) {
        GoldMembership.overdueFeesPerDay = overdueFeesPerDay;
    }

    protected static int getBorrowLimit() {
        return borrowLimit;
    }

    protected static void setBorrowLimit(int borrowLimit) {
        GoldMembership.borrowLimit = borrowLimit;
    }

    public static Double getDiscounts() {
        return discounts;
    }

    protected static void setDiscounts(Double discounts) {
        GoldMembership.discounts = discounts;
    }

    protected static int getMembershipPeriodInMonths() {
        return membershipPeriodInMonths;
    }

    protected static void setMembershipPeriodInMonths(int membershipPeriodInMonths) {
        GoldMembership.membershipPeriodInMonths = membershipPeriodInMonths;
    }

    public Calendar getExpiringOn() {
        return expiringOn;
    }


}
