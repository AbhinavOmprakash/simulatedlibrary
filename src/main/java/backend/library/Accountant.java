package backend.library;

import backend.controllers.DataManager;
import backend.externalservices.PaymentGateway;

public abstract class Accountant {
    protected DataManager accounts;

    public Accountant(DataManager accounts ) {
        this.accounts = accounts;
    }

}
