package backend.library.membershiplevels;

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

}
