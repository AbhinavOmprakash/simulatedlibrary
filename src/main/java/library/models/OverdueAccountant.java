package library.models;

import common.Transaction;
import common.models.*;

public class OverdueAccountant implements PaymentObserver {
    DataManager accounts;
    PaymentGateway paymentGateway;

    public OverdueAccountant(DataManager accounts, PaymentGateway paymentGateway) {
        this.accounts = accounts;
        this.paymentGateway = paymentGateway;
        paymentGateway.registerObservers(this);
    }

    public void initiatePayment(Member member, int daysPastDeadline){
        chargeOverdueFees(member, daysPastDeadline);
    }

    private void chargeOverdueFees(Member member, int daysPastDeadline){
        Double feesDue = calculatePenalty(member, daysPastDeadline);
        updateAccounts(member, feesDue);
        forwardToPaymentGateway(member, feesDue);
    }

    private Double calculatePenalty(Member member, int daysPastDeadline){
        Double currentOverdue = getCurrentOverdueFor(member);
        Double overduePerDay = member.getOverduePerDay();
        return doMath(currentOverdue, overduePerDay, daysPastDeadline);
    }

    private Double getCurrentOverdueFor(Member member) {
        FinancialAccount account = getAccountFor(member);
        return account.getFeesDue();
    }

    private FinancialAccount getAccountFor(Member member){
        return (FinancialAccount) accounts.search(String.valueOf(member.getUserName()));
    }

    //todo find better name
    private Double doMath(Double currentOverdue, Double overduePerDay, int daysPastDeadline) {
        return ((overduePerDay * daysPastDeadline) + currentOverdue);
    }

    private void updateAccounts(Member member,Double feesDue) {
        FinancialAccount account = getAccountFor(member);
        account.addPenalty(feesDue);
        accounts.updateData(account);
    }

    private void forwardToPaymentGateway(Member member, Double feesDue) {
        paymentGateway.initializePayment(member.getUserName(), feesDue, Transaction.OVERDUE_FEES);
    }

    @Override
    public void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {

    }
}
