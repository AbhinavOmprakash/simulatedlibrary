package externalservices;


import controllers.useraccounts.PaymentObserver;

public interface PaymentGateway{
    void acceptPayment(Long userID, double targetAmount);
    void registerObservers(PaymentObserver o);
    void removeObservers(PaymentObserver o);
    void notifyPaymentStatus(Long userID, boolean status);
}
