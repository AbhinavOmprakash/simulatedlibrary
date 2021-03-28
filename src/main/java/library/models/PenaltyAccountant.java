package library.models;


import common.models.User;
import signup.models.AccountsDataManager;

public class PenaltyAccountant extends Accountant {

    public PenaltyAccountant() {
        super(new AccountsDataManager());
    }

    public Double calculatePenalty(User user){
        Double overduePenalties = getOverdueFor(user);
        return 0.0;
    }

    private Double getOverdueFor(User user) {
        return (Double) accounts.search(String.valueOf(user.getID())).get(0);
    }
}