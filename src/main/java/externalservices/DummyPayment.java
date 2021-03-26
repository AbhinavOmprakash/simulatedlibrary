package externalservices;

import signup.models.AccountsDataManager;
import common.models.DataManager;
import common.models.PaymentObserver;
import signup.models.FinancialAccount;

import java.util.ArrayList;

@SuppressWarnings({"rawtypes","unchecked"})
public class DummyPayment implements PaymentGateway{
    DataManager financialAccounts = new AccountsDataManager();
    ArrayList<PaymentObserver> observers = new ArrayList<>();


    @Override
    public void acceptPayment(Long userID, double targetAmount) {
        notifyPaymentStatus(userID, true);
        updateAccounts(userID, targetAmount);
    }

    private void updateAccounts(Long userID, double targetAmount) {
        FinancialAccount account = new FinancialAccount(userID);
        account.addMembershipFees(targetAmount);
//        financialAccounts.updateData(account);
        financialAccounts.addItem(account);
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
    public void notifyPaymentStatus(Long userID, boolean status) {
        for(PaymentObserver o: observers){
            o.receivePaymentStatus(userID, status);
        }
    }
}
