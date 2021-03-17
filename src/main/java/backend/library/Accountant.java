package backend.library;

import backend.controllers.DataController;

public abstract class Accountant {
    protected DataController< User> dataController;

    public Accountant(DataController< User> controller) {
        this.dataController= controller;
    }

    public DataController<User> getDataManager() {
        return dataController;
    }

    public void setDataManager(DataController<User> newController) {
        this.dataController = newController;
    }

}
