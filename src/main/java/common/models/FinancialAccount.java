package common.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FinancialAccount implements Searchable{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;
    private String userName;
    private double feesDue = 0.0;
    private double totalMoneyPaid = 0.0;

    public FinancialAccount(){
        // for hibernate
    }

    public FinancialAccount(String userName){
        this.userName = userName;
    }

    public void addPenalty(double penalty){
        this.feesDue = penalty;
    }

    public void penaltyPaid(double penaltyPaid){
        this.feesDue -= penaltyPaid;
        this.totalMoneyPaid += penaltyPaid;
    }

    public void addMembershipFees(double membershipFees){
        this.totalMoneyPaid += membershipFees;
    }

    public String getUserName() {
        return userName;
    }

    public double getFeesDue() {
        return feesDue;
    }

    @Override
    public String getTableName() {
        return "FinancialAccount";
    }

    @Override
    public String getSearchableAttribute() {
        return "userName";
    }
}
