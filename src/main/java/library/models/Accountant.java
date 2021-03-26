package library.models;

import common.DataManager;

public abstract class Accountant {
    protected DataManager accounts;

    public Accountant(DataManager accounts ) {
        this.accounts = accounts;
    }

}
