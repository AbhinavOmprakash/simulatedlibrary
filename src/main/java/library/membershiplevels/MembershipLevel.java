package library.membershiplevels;


import java.util.Calendar;

public interface MembershipLevel {


    static Double getOverdueFeesPerDay(){
        return null;

    }
    default Calendar calculateMembershipExpiry(int membershipPeriodInMonths ){
        Calendar expiryOn = Calendar.getInstance();
        expiryOn.add(Calendar.MONTH, membershipPeriodInMonths);
        return expiryOn;
    }

    static Double getMembershipFees(){
        return 0.0;
    }

    static void setMembershipFees(Double membershipFees){};


    static void setOverdueFeesPerDay(Double overdueFeesPerDay){}

    static int getBorrowLimit(){
        return 0;
    }

    static void setBorrowLimit(int borrowLimit){}

    static Double getDiscounts(){
        return null;
    }

    static void setDiscounts(Double discounts){}

    static int getMembershipPeriodInMonths(){
        return 0;
    }

    static void setMembershipPeriodInMonths(int membershipPeriodInMonths){}

    Calendar getExpiringOn();
}



