package common.models;

import common.Transaction;

public interface PaymentObserver {
    void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction);
}
