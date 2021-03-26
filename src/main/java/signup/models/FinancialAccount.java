package signup.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinancialAccount {
    @Id
    private long userID;
    private double penaltyDue = 0.0;
    private double totalMoneyPaid = 0.0;

    FinancialAccount(){
        // for hibernate
    }

    public FinancialAccount(long userID){
        this.userID =userID;
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

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public double getPenaltyDue() {
        return penaltyDue;
    }

    public void setPenaltyDue(double penaltyDue) {
        this.penaltyDue = penaltyDue;
    }

    public double getTotalMoneyPaid() {
        return totalMoneyPaid;
    }

    public void setTotalMoneyPaid(double totalMoneyPaid) {
        this.totalMoneyPaid = totalMoneyPaid;
    }

}
