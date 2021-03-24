package backend.externalservices;

import backend.controllers.AccountsDataManager;
import backend.controllers.DataManager;
import backend.controllers.Accountant;
import backend.dataobjects.library.User;

public class DummyPayment implements PaymentGateway{
    DataManager accounts = new AccountsDataManager();



    @Override
    public void acceptPayment(User user, double targetAmount) {

    }

    @Override
    public void registerAccountant(Accountant accountant) {

    }

    @Override
    public void removeAccountant(Accountant accountant) {

    }

    @Override
    public void notifyPaymentStatus(Accountant accountant, boolean status) {

    }
}
