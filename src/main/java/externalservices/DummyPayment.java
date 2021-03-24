package externalservices;

import controllers.financials.AccountsDataManager;
import controllers.DataManager;
import controllers.financials.Accountant;
import models.dataobjects.library.User;

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
