package common.models;

import common.Transaction;

public interface PaymentGateway{
    void initializePayment(String username, double targetAmount, Transaction transaction);
    void registerObservers(PaymentObserver o);
    void removeObservers(PaymentObserver o);
    void notifyPaymentStatus(String username, boolean status, double targetAmount, Transaction transaction);
}
