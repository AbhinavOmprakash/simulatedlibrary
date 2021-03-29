package common.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FinancialAccount {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;
    private String username;
    private double penaltyDue = 0.0;
    private double totalMoneyPaid = 0.0;

    FinancialAccount(){
        // for hibernate
    }

    public FinancialAccount(String username){
        this.username = username;
    }

    public void addPenalty(double penalty){
        this.penaltyDue = penalty;
    }

    public void penaltyPaid(double penaltyPaid){
        this.penaltyDue -= penaltyPaid;
        this.totalMoneyPaid += penaltyPaid;
    }

    public void addMembershipFees(double membershipFees){
        this.totalMoneyPaid += membershipFees;
    }

}
