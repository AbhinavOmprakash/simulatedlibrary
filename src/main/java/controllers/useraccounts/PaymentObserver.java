package controllers.useraccounts;

public interface PaymentObserver {
    void receivePaymentStatus(Long userID, boolean status);
}
