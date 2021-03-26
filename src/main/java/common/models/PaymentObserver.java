package common.models;

public interface PaymentObserver {
    void receivePaymentStatus(Long userID, boolean status);
}
