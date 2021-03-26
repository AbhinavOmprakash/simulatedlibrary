package common;

public interface PaymentObserver {
    void receivePaymentStatus(Long userID, boolean status);
}
