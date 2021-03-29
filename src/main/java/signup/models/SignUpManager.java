package signup.models;

import common.Transaction;
import common.customevents.CustomEvent;
import common.customevents.EventCotroller;
import common.models.*;
import member.models.UserDataManager;
import payment.models.DummyPayment;
import common.models.PaymentGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//todo - refactor, class is doing too much.
@SuppressWarnings({"rawtypes","unchecked"})
public class SignUpManager implements PaymentObserver{
    DataManager userDataManager = UserDataManager.getInstanceOf();
    Map<String, SignUpData> signUpQueue = new HashMap<>();
    PaymentGateway paymentGateway = DummyPayment.getInstanceOf();
    CreateNewFinancialAcc accountCreator = new CreateNewFinancialAcc();

    public SignUpManager() {
        paymentGateway.registerObservers(this);
    }

    public void signUp(SignUpData data){
        signUpQueue.put(data.userName, data);
        // todo improve design. chained calls.
        if(!(data.policy.name.equals("Basic"))) {
            // can't call payment gateway before creating user.
            forwardToPaymentGateway(data);
            EventCotroller.getInstanceOf().dispatch(CustomEvent.PAYMENT_GATEWAY);
        } else{
            completeSignUp(data.userName);
        }
    }

    @Override
    public void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {
        if(transaction.equals(Transaction.SIGNUP) && status){
            completeSignUp(username);
        }
    }
    private void forwardToPaymentGateway(SignUpData data) {
        paymentGateway.initializePayment(data.userName, data.policy.membershipFees, Transaction.SIGNUP);
    }


    private void completeSignUp(String username) {
        SignUpData data = signUpQueue.get(username);
        signUpQueue.remove(username);

        forwardToCreators(data);
        changeCurrentUser(data.userName);

        EventCotroller.getInstanceOf().dispatch(CustomEvent.SIGNED_UP);
    }

    //todo find better name
    private void forwardToCreators(SignUpData data) {
        CreateNewMember.createMember(data);
        CreateNewLogin.createLoginCredentials(data);
        accountCreator.enqueueCreation(data);
    }

    private void changeCurrentUser(String userName) {
        List results = userDataManager.search(userName);
        User newUser = (User) results.get(0);
        CurrentUser.changeUser(newUser);
    }


}
