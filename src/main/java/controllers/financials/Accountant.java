package controllers.financials;

import controllers.DataManager;

public abstract class Accountant {
    protected DataManager accounts;

    public Accountant(DataManager accounts ) {
        this.accounts = accounts;
    }

}
