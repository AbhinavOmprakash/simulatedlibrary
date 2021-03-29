package payment.models;

import common.Transaction;

public class PaymentDetails {
    protected String userName;
    protected double targetAmount;
    protected Transaction transaction;

    public PaymentDetails(String userName, double targetAmount, Transaction transaction) {
        this.userName = userName;
        this.targetAmount = targetAmount;
        this.transaction = transaction;
    }

    public double getTargetAmount() {
        return targetAmount;
    }
}
