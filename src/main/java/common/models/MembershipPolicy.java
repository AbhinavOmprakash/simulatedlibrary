package common.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MembershipPolicy {

    public String name;
    public Double membershipFees;
    public Double overdueFeesPerDay;
    public int borrowLimit;
    public Double discountPercentage; // value must be between 0.0 to 100.0
    public int membershipPeriodInMonths = 12;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int Id;

    public MembershipPolicy(){
        // for hibernate
    }

    public MembershipPolicy(String name, Double membershipFees,
                            Double overdueFeesPerDay, int borrowLimit,
                            Double discountPercentage,
                            int membershipPeriodInMonths) {
        this.name = name;
        this.membershipFees = membershipFees;
        this.overdueFeesPerDay = overdueFeesPerDay;
        this.borrowLimit = borrowLimit;
        this.discountPercentage = discountPercentage;
        this.membershipPeriodInMonths = membershipPeriodInMonths;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembershipPolicy)) return false;
        MembershipPolicy that = (MembershipPolicy) o;
        return getName().equals(that.getName());
    }

}
