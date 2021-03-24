package backend.library.records;

import backend.library.User;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts{
    @Id
    private int userID;
    private double penaltyDue = 0.0;
    private double totalMoneyPaid = 0.0;

    Accounts(){
        // for hibernate
    }

    public Accounts(User user){
        this.userID = user.getID();
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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
