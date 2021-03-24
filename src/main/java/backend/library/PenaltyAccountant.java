package backend.library;


import backend.controllers.AccountsDataManager;
import backend.controllers.DataManager;

import java.util.ArrayList;
import java.util.Map;

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
