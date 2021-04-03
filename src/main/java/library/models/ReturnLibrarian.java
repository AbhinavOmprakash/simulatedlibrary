package library.models;

import common.Transaction;
import common.models.DataManager;
import common.models.Member;
import common.models.PaymentGateway;
import common.models.PaymentObserver;
import library.models.libraryitems.LibraryItem;

import java.util.*;

public class ReturnLibrarian implements PaymentObserver {
    ReturnIncharge normalReturn;
    LibraryUtils libraryUtils;
    OverdueAccountant accountant;
    PaymentGateway paymentGateway;
    Map<String, ReturnTransaction> returnQueue = new HashMap<>();

    public ReturnLibrarian(ReturnIncharge normalReturn,
                           LibraryUtils libraryUtils,
                           OverdueAccountant accountant,
                           PaymentGateway paymentGateway) {
        this.normalReturn = normalReturn;
        this.libraryUtils = libraryUtils;
        this.accountant = accountant;
        this.paymentGateway = paymentGateway;
        paymentGateway.registerObservers(this);
    }

    public void returnItem(Member member, LibraryItem item){
        if(libraryUtils.isOverdue(item)){
            int overDueDays = libraryUtils.getOverdueDays(item);
            addToQueue(member, item);
            accountant.initiatePayment(member, overDueDays);
        } else {
            normalReturn.returnItem(member, item);
        }
    }

    private void addToQueue(Member member, LibraryItem item) {
        returnQueue.put(member.getUserName(),
                new ReturnTransaction(member, item));
    }

    @Override
    public void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {
        if (status && transaction.equals(Transaction.OVERDUE_FEES)) {
            completeReturn(username);
        }
    }

    private void completeReturn(String username) {
        ReturnTransaction returnTransaction = returnQueue.get(username);
        normalReturn.returnItem(returnTransaction.member, returnTransaction.item);
    }

}
