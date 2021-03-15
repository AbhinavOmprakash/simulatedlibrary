package backend.library;


import java.util.ArrayList;
import java.util.Map;
//
//public class PenaltyAccountant extends Accountant{
//
//    public PenaltyAccountant(DataManager<String, User> dataManager) {
//        super(dataManager);
//    }
//
//    public Double chargePenalty(User user, int overdueDays){
//        user = getUpdatedUserData(user);
//
//        Map<String, Double> relevantDetails = getRelevantPenaltyDetails(user);
//
//        return calculatePenalty(relevantDetails, overdueDays);
//    }
//
//    private User getUpdatedUserData(User user){
//        String id = String.valueOf(user.getID());
//        ArrayList<User> users = dataManager.search(id);
//        return users.get(0);
//    }
//
//    // find better function name
//    private Map<String,Double> getRelevantPenaltyDetails(User user){
//        Double previousPenalties = user.getPenaltyDue();
//        Double overduePerDay = user.getOverdueFeesPerDay();
//        //to be changed
////        Double discounts = user.getDiscountPercentage();
//        Double discounts = 0.9;
//        Map<String,Double> details = Map.of(
//                        "previousPenalties", previousPenalties,
//                        "overduePerDay",overduePerDay,
//                        "discounts", discounts
//        );
//        return details;
//    }
//
//    private Double calculatePenalty(Map<String,Double> necessaryDetails,
//                                    int overdueDays){
//
//        Double previousPenalties = necessaryDetails.get("previousPenalties");
//        Double overduePerDay = necessaryDetails.get("overduePerDay");
//        Double discounts =  necessaryDetails.get("discounts");
//
//        // do some quick mafs
//        return previousPenalties + (overdueDays)*overduePerDay*((1-discounts)/100);
//    }
//
//}
