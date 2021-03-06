package library;

import externalservices.PaymentGateway;

import java.util.ArrayList;
import java.util.Map;

public class PenaltyAccountant implements Accountant{
    DataManager<String, User> dataManager;


    public PenaltyAccountant(DataManager<String, User> dataManager, PaymentGateway paymentGateway) {
        this.dataManager = dataManager;
    }

    public Double chargePenalty(User user, int overdueDays){
        user = getUpdatedUserData(user);

        Map<String, Double> relevantDetails = getRelevantPenaltyDetails(user);

        return calculatePenalty(relevantDetails, overdueDays);
    }

    private User getUpdatedUserData(User user){
        String id = String.valueOf(user.getID());
        ArrayList<User> users = dataManager.search(id);
        return users.get(0);
    }

    // find better function name
    private Map<String,Double> getRelevantPenaltyDetails(User user){
        Double previousPenalties = user.getPenaltyDue();
        Double overduePerDay = user.getOverdueFeesPerDay();
        Map<String,Double> details = Map.of(
                        "previousPenalties", previousPenalties,
                        "overduePerDay",overduePerDay
        );
        return details;
    }

    private Double calculatePenalty(Map<String,Double> necessaryDetails,
                                    int overdueDays){

        Double previousPenalties = necessaryDetails.get("previousPenalties");
        Double overduePerDay = necessaryDetails.get("overduePerDay");
        return previousPenalties + (overdueDays)*overduePerDay;

    }
}
