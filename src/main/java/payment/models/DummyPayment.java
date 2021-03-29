package payment.models;

import common.Transaction;
import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class DummyPayment implements PaymentGateway {
    ArrayList<PaymentObserver> observers = new ArrayList<>();
    Map<String, PaymentDetails> transactionQueue = new HashMap<>();

    // hacky
    PaymentDetails latestPayment;

    private static DummyPayment uniqueInstance;

    private DummyPayment(){}

    public static DummyPayment getInstanceOf(){
        if(uniqueInstance==null){
            synchronized (DummyPayment.class){
                if(uniqueInstance==null){
                    uniqueInstance= new DummyPayment();
                }
            }
        }
        return uniqueInstance;
    }

    @Override
    public void initializePayment(String username, double targetAmount, Transaction transaction) {
        PaymentDetails details = new PaymentDetails(username, targetAmount, transaction);
        transactionQueue.put(username,details);
        latestPayment = details;
        EventCotroller.getInstanceOf().dispatch(CustomEvent.NEW_PAYMENT);
    }

    public void completePayment(PaymentDetails details){
        // true for dummy purposes.
        notifyPaymentStatus(details.userName, true, details.targetAmount, details.transaction);

        transactionQueue.remove(details.userName);
    }
    public PaymentDetails getLatestPayment() {
        return latestPayment;
    }


    @Override
    public void registerObservers(PaymentObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObservers(PaymentObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyPaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {
        for(PaymentObserver o: observers){
            o.receivePaymentStatus(username, status, targetAmount, transaction);
        }
    }
}
