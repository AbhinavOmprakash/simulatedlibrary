package library.membershiplevels;


import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.HashMap;

@Entity
public class MembershipLevel {

    // subclasses must initialize these values
    String policy;
    Double membershipFees;
    Double overdueFeesPerDay;
    int borrowLimit;
    Double discountPercentage; // value must be between 0.0 to 100.0
    int membershipPeriodInMonths;

    @Temporal(TemporalType.TIMESTAMP)
    Calendar expiringOn;

    MembershipLevel(MembershipPolicy policy){
        this.policy = policy.toString();
        this.membershipFees = policy.getMembershipFees();
        this.overdueFeesPerDay = policy.getOverdueFeesPerDay();
        this.borrowLimit = policy.getBorrowLimit();
        this.discountPercentage = policy.getDiscountPercentage();
        this.membershipPeriodInMonths = policy.getMembershipPeriodInMonths();
        this.expiringOn = calculateMembershipExpiry();
    }

    protected Calendar calculateMembershipExpiry() {
        Calendar expiryOn = Calendar.getInstance();
        expiryOn.add(Calendar.MONTH, this.membershipPeriodInMonths);
        return expiryOn;
    }

    public Double getMembershipFees() {
        return membershipFees;
    }

    public void setMembershipFees(Double membershipFees) {
        this.membershipFees = membershipFees;
    }

    public Double getOverdueFeesPerDay() {
        return overdueFeesPerDay;
    }

    public void setOverdueFeesPerDay(Double overdueFeesPerDay) {
        this.overdueFeesPerDay = overdueFeesPerDay;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMembershipPeriodInMonths() {
        return membershipPeriodInMonths;
    }

    public void setMembershipPeriodInMonths(int membershipPeriodInMonths) {
        this.membershipPeriodInMonths = membershipPeriodInMonths;
    }

    public Calendar getExpiringOn() {
        return expiringOn;
    }

    public void setExpiringOn(Calendar expiringOn) {
        this.expiringOn = expiringOn;
    }

}
