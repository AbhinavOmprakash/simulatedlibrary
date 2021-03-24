package backend.dataobjects.library.membershiplevels;



import javax.persistence.*;
import java.util.Calendar;

@Embeddable
@Access(AccessType.FIELD)
public class MembershipLevel {

    // subclasses must initialize these values
    String policy;
    @Column(name = "membershipFees")
    Double membershipFees;
    @Column(name = "overdueFeesPerDay")
    Double overdueFeesPerDay;
    int borrowLimit;
    Double discountPercentage; // value must be between 0.0 to 100.0
    int membershipPeriodInMonths;

    @Temporal(TemporalType.TIMESTAMP)
    Calendar expiringOn;

    public MembershipLevel(){
        // for hibernate
    }

    public MembershipLevel(MembershipPolicy policy){
        this.policy = policy.name;
        this.membershipFees = policy.membershipFees;
        this.overdueFeesPerDay = policy.overdueFeesPerDay;
        this.borrowLimit = policy.borrowLimit;
        this.discountPercentage = policy.discountPercentage;
        this.membershipPeriodInMonths = policy.membershipPeriodInMonths;
        this.expiringOn = calculateMembershipExpiry();
    }

    protected Calendar calculateMembershipExpiry() {
        Calendar expiryOn = Calendar.getInstance();
        expiryOn.add(Calendar.MONTH, this.membershipPeriodInMonths);
        return expiryOn;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
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
