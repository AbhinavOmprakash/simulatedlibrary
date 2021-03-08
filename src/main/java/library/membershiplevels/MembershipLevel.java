package library.membershiplevels;


import java.util.Calendar;

public interface MembershipLevel {


    static Double getOverdueFeesPerDay(){
        return null;
    }

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



