package controllers;

public abstract class Accountant {
    protected DataManager accounts;

    public Accountant(DataManager accounts ) {
        this.accounts = accounts;
    }

}
