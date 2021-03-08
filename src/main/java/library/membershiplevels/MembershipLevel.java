package library.membershiplevels;


import java.util.Calendar;

public abstract class MembershipLevel {

    protected static Double overdueFeesPerDay = 10.0;
    protected static int borrowLimit = 1;
    protected static Double discounts = 0.0; // value must be between 0.0 to 1.0
    protected static int membershipPeriodInMonths = 12;
    protected Calendar expiringOn;

    public MembershipLevel(){
        calculateMembershipExpiry();
    }

    private void calculateMembershipExpiry(){
        expiringOn = Calendar.getInstance();
        expiringOn.add(Calendar.MONTH, membershipPeriodInMonths);
    }

    public static Double getOverdueFeesPerDay() {
        return overdueFeesPerDay;
    }

    public static void setOverdueFeesPerDay(Double overdueFeesPerDay) {
        MembershipLevel.overdueFeesPerDay = overdueFeesPerDay;
    }

    public static int getBorrowLimit() {
        return borrowLimit;
    }

    public static void setBorrowLimit(int borrowLimit) {
        MembershipLevel.borrowLimit = borrowLimit;
    }

    public static Double getDiscounts() {
        return discounts;
    }

    public static void setDiscounts(Double discounts) throws IllegalArgumentException {
        if (0<= discounts && discounts <=1.0) {
            MembershipLevel.discounts = discounts;
        } else {
            throw new IllegalArgumentException("Discount can't be more than 1");
        }
    }

    public static int getMembershipPeriodInMonths() {
        return membershipPeriodInMonths;
    }

    public static void setMembershipPeriodInMonths(int membershipPeriodInMonths) {
        MembershipLevel.membershipPeriodInMonths = membershipPeriodInMonths;
    }

    public Calendar getExpiringOn() {
        return expiringOn;
    }

}
