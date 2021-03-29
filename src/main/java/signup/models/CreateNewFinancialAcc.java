package signup.models;

import common.Transaction;
import common.models.*;
import library.models.AccountsDataManager;
import member.models.UserDataManager;
import payment.models.DummyPayment;

import java.util.HashMap;

@SuppressWarnings("rawtypes, unchecked")
public class CreateNewFinancialAcc implements PaymentObserver {

    private DataManager financialAccounts = new AccountsDataManager();
    private final DataManager userDataManager = UserDataManager.getInstanceOf();
    private HashMap<String, SignUpData> signUpQueue = new HashMap<>();

    public CreateNewFinancialAcc() {
        DummyPayment.getInstanceOf().registerObservers(this);
    }

    //todo find better name
    public void enqueueCreation(SignUpData data) {
        signUpQueue.put(data.userName,data);
    }

    @Override
    public void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {
        if(transaction.equals(Transaction.SIGNUP) && status) {
            createFinancialAccount(username, targetAmount);
        }
    }

    private void createFinancialAccount(String username, double targetAmount) {
        FinancialAccount account = new FinancialAccount(username);
        account.addMembershipFees(targetAmount);
        financialAccounts.addItem(account);
    }
}
