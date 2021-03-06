package library;

import externalservices.PaymentGateway;

import java.util.ArrayList;
import java.util.Map;

public class PenaltyAccountant implements Accountant{
    DataManager<String, User> dataManager;
    PaymentGateway paymentGateway;


    public PenaltyAccountant(DataManager<String, User> dataManager, PaymentGateway paymentGateway) {
        this.dataManager = dataManager;
        this.paymentGateway = paymentGateway;
        this.paymentGateway.registerAccountant(this);
    }

    public void chargePenalty(User user, int overdueDays){
        user = getUpdatedUserData(user);

        Map<String, Double> relevantDetails = getRelevantPenaltyDetails(user);

        double totalPenaltyDue = calculatePenalty(relevantDetails, overdueDays);

        forwardToPaymentGateway(user, totalPenaltyDue);
    }

    private User getUpdatedUserData(User user){
        String id = String.valueOf(user.getID());
        ArrayList<User> users = dataManager.search(id);
        return users.get(0);
    }

    // find better function name
    private Map<String,Double> getRelevantPenaltyDetails(User user){
        MembershipLevel membershipLevel = user.getMembershipLevel();
        Double previousPenalties = user.getPenaltyDue();
        Double overduePerDay = membershipLevel.getOverdueFeesPerDay();
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

    private void forwardToPaymentGateway(User user, double paymentDue){
        paymentGateway.initializePayment(user, paymentDue);
    }

    //To-Do find better name. has side effects
    public void receivePaymentStatus(boolean status, User user) {
        if(status==true) {
            updateUserPenaltyData(user);
            sendUpdatedDataToManager(user);
        }
    }

    private void updateUserPenaltyData(User user){
        user.setPenaltyDue(0);
    }

    private void sendUpdatedDataToManager(User user){
        dataManager.updateData(user);
    }

}
