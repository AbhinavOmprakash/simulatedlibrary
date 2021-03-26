package library.models;

import common.models.DataManager;

public abstract class Accountant {
    protected DataManager accounts;

    public Accountant(DataManager accounts ) {
        this.accounts = accounts;
    }

}
